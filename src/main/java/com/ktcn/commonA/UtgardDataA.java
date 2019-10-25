package com.ktcn.commonA;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import org.jinterop.dcom.common.JISystem;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ktcn.entity.ConfigPojo;
import com.ktcn.entity.opcaddress.KyjOpcAddress1;
import com.ktcn.utils.OPCAddress;
import com.ktcn.utils.OPCAddressInsert2;

@EnableScheduling // 此注解必加,必须要加，重中之重

//@Component // 此注解必加
@Service

@Order(value = 1)
public class UtgardDataA {
	// 获取地址值 的controller类
	@Autowired
	KyjOpcAddress1 kyjOpcAddress1;

	@Autowired
	OPCAddressInsert2 OPCAddressInsert2;
	ConfigPojo te = new ConfigPojo();
	// 获取连接池信息
	ConnectionInformation ci = new ConnectionInformation();
	
	@Scheduled(cron = "0/1 * * * * ?")
	public void SwitchData() {

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
		ci.setUser(te.getUsername()); // 电脑上自己建好的用户名
		ci.setPassword(te.getPassword()); // 密码
		// 使用KEPServer的配置
		ci.setClsid(te.getClsid()); // KEPServer的注册表ID，可以在“组件服务”里看到
		// 提取采集short数据
		List<Boolean> fl = new ArrayList<Boolean>();
		// 查询数据库所有采集通道点位
		List<String> allAddress2 = kyjOpcAddress1.getListAddress();

//		SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
//		String format = date.format(new Date(System.currentTimeMillis()));
//		System.out.println(format + "服务开启读值￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
		for (int i = 0; i < allAddress2.size(); i++) {
			String address1 = allAddress2.get(i);

			String itemId2 = "Siemens Ethernet.S7-200 SMART." + address1.toString(); // 项的名字按实际，没有实际PLC，用的模拟器：simulator
			// 启动服务
			Server server2 = new Server(ci, Executors.newSingleThreadScheduledExecutor());
			// JISystem.setJavaCoClassAutoCollection(false);
			JISystem.setJavaCoClassAutoCollection(false);
			try {
				// 启动服务
				server2.connect();
				// 添加到group组
				Group group2 = server2.addGroup("test");
				Item item2 = group2.addItem(itemId2);
				ItemState itemState2 = item2.read(true);
				fl.add((Boolean) itemState2.getValue().getObject());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				break;
			}
//		    server.disconnect();
			server2.dispose();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		SimpleDateFormat date2 = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
//		String format2 = date2.format(new Date(System.currentTimeMillis()));

//		int b = 1;
//		for (Object string : fl) {
//			System.out.println((b++) + "____" + string);
//		}
//		System.out.println("LIST 集合数据" + fl);
//		System.out.println(format + "服务开启读值￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
//		System.out.println(format2 + "服务读值完毕%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		

		OPCAddressInsert2.GetOPCInsert(fl);

	}
}
