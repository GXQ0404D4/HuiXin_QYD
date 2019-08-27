package com.ktcn.common;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.common.JISystem;
import org.jinterop.dcom.core.JIVariant;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.common.NotConnectedException;
import org.openscada.opc.lib.da.AccessBase;
import org.openscada.opc.lib.da.AddFailedException;
import org.openscada.opc.lib.da.Async20Access;
import org.openscada.opc.lib.da.DataCallback;
import org.openscada.opc.lib.da.DuplicateGroupException;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ktcn.entity.Data_master_table;
import com.ktcn.entity.Opc_address;
import com.ktcn.utils.OPCAddress;
import com.ktcn.utils.OPCAddressInsert;
import com.ktcn.utils.OPCConfig;

@Component
@Order(value = 2)
public class UtgardTutorial1 implements CommandLineRunner {
	private static final int PERIOD = 1000;

	private static final int SLEEP = 50;
	// 获取连接池信息
	//private static final ConnectionInformation ci = OPCConfig.getConnectionInformation();
	
	
	// 获取地址值 的controller类
	@Autowired
	OPCAddress opcaddress;

	public void run(String... args) throws Exception {
     Runnable runnable = new Runnable() {
			public void run() {			
		
		         System.out.println("进入run方法"); 
				// 获取连接池信息
				ConnectionInformation ci = OPCConfig.getConnectionInformation();
				
				//Data_master_table master_table = new Data_master_table();
				
				//System.out.println("new 主数据表类"); 		
				
				Map <String,Object> map= new HashMap<String,Object>();
				// 获取所有点位值
				List<Opc_address> allAddress = opcaddress.GetAllAddress();
				System.out.println("获取所有的点位");
				for (Opc_address address : allAddress) {
					String Address = address.getTag_name();
				
								
				    final String itemId = "Siemens Ethernet.S7-200 SMART." + Address;
					final Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());
					
					try {						// 连接到服务
						JISystem.setJavaCoClassAutoCollection(false);
						server.connect();
						// ms，启动一个异步的access用来读取地址上的值，线程池每500ms读值一次
						final AccessBase access = new Async20Access(server, PERIOD, true); // 使用Async20Access类隔时间段地进行异步读取数据，它实现了IOPCDataCallback接口，					
						// 这是个回调函数，就是读到值后执行这个打印，是用匿名类写的，当然也可以写到外面去
						access.addItem(itemId, new DataCallback() {
							@Override
							public void changed(Item item, ItemState itemState) {
								JIVariant value = itemState.getValue();
								System.out.println(value+"value+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
								map.put(Address, value);					
							}
						});
						// start reading，开始读值
						access.bind();
						SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");						
						String format = date.format(new Date(System.currentTimeMillis()));					
						System.out.println(map + "+++++++++++++++++++++++++++++++++++采集Boolean数据集合");
						System.out.println(map + "+++++++++++++++++++++++++++++++++++采集Float数据集合");
						System.out.println(format + "+++++++++++++++++++++++++++++++++++采集开始时间数据");
						// wait a little bit，有个10秒延时(1000 1秒可用)
						Thread.sleep(SLEEP);
						System.out.println("Thread.sleep(SLEEP);");		
						// stop reading，停止读取
						access.unbind();
						SimpleDateFormat date1 = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
						String format1 = date1.format(new Date(System.currentTimeMillis()));						
						System.out.println(format1 + "+++++++++++++++++++++++++++++++++++采集结束时间数据");
						
						/*if (id == 3) {
							//System.out.println("hahahahahahahahahahahahahahahahahahahahahahahahahahahah");
							OPCAddressInsert opcAddressInsert = new OPCAddressInsert();
							opcAddressInsert.GetOPCInsert(sl,fl);
						}*/
					} catch (final JIException e) {
						System.out.println(String.format("%08X: %s", e.getErrorCode(), server.getErrorMessage(e.getErrorCode())));
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (AlreadyConnectedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotConnectedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DuplicateGroupException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (AddFailedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, 0, 1000, TimeUnit.SECONDS);

	}
}
