package com.ktcn.common;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.openscada.opc.lib.da.SyncAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ktcn.utils.OPCAddress;
import com.ktcn.utils.OPCAddressInsert;
import com.ktcn.utils.OPCConfig;

//@EnableScheduling // 此注解必加,必须要加，重中之重
//@Component // 此注解必加
//@Order(value = 1)
public class UtgardData {
	// 获取连接池信息
	private static final ConnectionInformation ci = OPCConfig.getConnectionInformation();
	// 获取地址值 的controller类
	@Autowired
	OPCAddress opcaddress;

	@Autowired
	OPCAddressInsert opcaddressinsert;

	@Scheduled(cron = "0/1 * * * * ?")
	public void kepserverdata() {

		// 提取采集short数据
		ArrayList<Object> fl = new ArrayList<Object>();
		// 查询数据库所有采集通道点位
		List<String> allAddress = opcaddress.GetAllAddress();

//		SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
//		String format = date.format(new Date(System.currentTimeMillis()));
//		System.out.println(format + "服务开启读值￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
		for (int i = 0; i < allAddress.size(); i++) {
			String address1 = allAddress.get(i);
			String itemId = "Siemens Ethernet.S7-200 SMART." + address1.toString(); // 项的名字按实际，没有实际PLC，用的模拟器：simulator
			// 启动服务
			Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());
			// JISystem.setJavaCoClassAutoCollection(false);
			JISystem.setJavaCoClassAutoCollection(false);
				
				try {
					// 启动服务
					server.connect();
					// 添加到group组
					Group group = server.addGroup("test");
					Item item = group.addItem(itemId);
					ItemState itemState = item.read(true);
					fl.add(itemState.getValue().getObject());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					break;
				}
//		    server.disconnect();
			server.dispose();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			} 
		}
//		SimpleDateFormat date2 = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
//		String format2 = date2.format(new Date(System.currentTimeMillis()));

//		int a = 1;
//		for (Object string : fl) {
//			System.out.println((a++) + "____" + string);
//		}
//		System.out.println("LIST 集合数据" + fl);
//		System.out.println(format + "服务开启读值￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
//		System.out.println(format2 + "服务读值完毕%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
		  try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		opcaddressinsert.GetOPCInsert(fl);

	}

}
