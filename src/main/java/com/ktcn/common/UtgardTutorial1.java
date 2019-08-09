/*package com.ktcn.common;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.core.JIString;
import org.jinterop.dcom.core.JIVariant;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.common.NotConnectedException;
import org.openscada.opc.lib.da.AccessBase;
import org.openscada.opc.lib.da.AddFailedException;
import org.openscada.opc.lib.da.DataCallback;
import org.openscada.opc.lib.da.DuplicateGroupException;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.openscada.opc.lib.da.SyncAccess;


public class UtgardTutorial1 {

	public static void main(String[] args) throws Exception {
		
		Runnable runnable = new Runnable() {
			public void run() {
				// task to run goes here
				System.out.println("Hello !!");
		
		
		// 连接信息
		final ConnectionInformation ci = new ConnectionInformation();
		// 获取IP地址
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ci.setHost(ip); // 电脑IP
		ci.setDomain(""); // 域，为空就行
		ci.setUser("OPCServer"); // 电脑上自己建好的用户名
		ci.setPassword("122360"); // 密码

		// 使用KEPServer的配置
		ci.setClsid("7BC0CC8E-482C-47CA-ABDC-0FE7F9C6E729"); // KEPServer的注册表ID，可以在“组件服务”里看到

		// 提取采集short数据
		ArrayList<Short> sl = new ArrayList<Short>();
		ArrayList<Float> fl = new ArrayList<Float>();

		ArrayList<String> str2 = new ArrayList<String>();
		str2.add("总功率");
		str2.add("总电量");
		str2.add("主机压力2");
		str2.add("主机压力");
		str2.add("主机温度");
		str2.add("主机温度2");
		str2.add("整数1");
		str2.add("整数2");
		str2.add("整数3");
		str2.add("油压");
		str2.add("测试数据");
		str2.add("测试数据2");

		for (int i = 0; i < str2.size(); i++) {
			String address1 = str2.get(i);
			System.out.println(address1.toString());

			final String itemId = "Siemens Ethernet.S7-200 SMART." + address1.toString(); // 项的名字按实际，没有实际PLC，用的模拟器：simulator
			// final String itemId = "通道 1.设备 1.标记 1";

			// 启动服务
			final Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());

			try {
				// 连接到服务
				server.connect();
				// add sync access, poll every 500
				// ms，启动一个同步的access用来读取地址上的值，线程池每500ms读值一次
				// 这个是用来循环读值的，只读一次值不用这样			

				final AccessBase access = new SyncAccess(server, 50);
				// 这是个回调函数，就是读到值后执行这个打印，是用匿名类写的，当然也可以写到外面去
				access.addItem(itemId, new DataCallback() {
					@Override
					public void changed(Item item, ItemState itemState) {
						int type = 0;
						try {
							type = itemState.getValue().getType(); // 类型实际是数字，用常量定义的
						} catch (JIException e) {
							e.printStackTrace();
						}				
						// 如果读到是short类型的值
						if (type == JIVariant.VT_I2) {
							short n = 0;
							try {
								n = itemState.getValue().getObjectAsShort();

								sl.add(n);

							} catch (JIException e) {
								e.printStackTrace();
							}
							System.out.println("-----short类型值： " + n);
							System.out.println("监控项的数据类型是：itemState.getValue()返回上传参数-----" + itemState.getValue());
							System.out.println("监控项的数据类型是：-----" + type);
							System.out
									.println("监控项的时间戳是：getTimestamp.getTime-----" + itemState.getTimestamp().getTime());
							System.out.println("监控项的详细信息是：itemState-----" + itemState);
							System.out.println("这是啥：hashCode-----" + itemState.hashCode());
						}

						// 如果读到是Float类型的值
						if (type == JIVariant.VT_R4) {
							Float f = null;
							try {
								f = itemState.getValue().getObjectAsFloat();
								fl.add(f);
								byte[] bs = Float2bytes.float2byte(f);
								System.out.println(bs + "bs字节+++++++++++");
							} catch (JIException e) {
								e.printStackTrace();
							}
							System.out.println("-----Float类型值： " + f);
							System.out.println("监控项的数据类型是：itemState.getValue()返回上传参数-----" + itemState.getValue());
							System.out.println("监控项的数据类型是：-----" + type);
							System.out
									.println("监控项的时间戳是：getTimestamp.getTime-----" + itemState.getTimestamp().getTime());
							System.out.println("监控项的详细信息是：itemState-----" + itemState);
							System.out.println("这是啥：hashCode-----" + itemState.hashCode());
						}

						// 如果读到是字符串类型的值
						if (type == JIVariant.VT_BSTR) { // 字符串的类型是8
							JIString value = null;
							try {
								value = itemState.getValue().getObjectAsString();
							} catch (JIException e) {
								e.printStackTrace();
							} // 按字符串读取
							String str = value.getString(); // 得到字符串
							System.out.println("-----String类型值： " + str);
						}
					}
				});
				// start reading，开始读值
				access.bind();

				SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
				String format = date.format(new Date(System.currentTimeMillis()));
				System.out.println("开始时间：" + format);

				// wait a little bit，有个10秒延时(1000 1秒可用)
				Thread.sleep(100);

				System.out.println(sl + "+++++++++++++++++++++++++++++++++++采集short数据集合");
				System.out.println(fl + "+++++++++++++++++++++++++++++++++++采集Float数据集合");
				System.out.println(format + "+++++++++++++++++++++++++++++++++++采集开始时间数据");

				// stop reading，停止读取
				access.unbind();

				SimpleDateFormat date1 = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
				String format1 = date.format(new Date(System.currentTimeMillis()));
				System.out.println("结束时间：" + format1);
				System.out.println(format1 + "+++++++++++++++++++++++++++++++++++采集结束时间数据");
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
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, 0, 20	, TimeUnit.SECONDS);
		
	}
}*/