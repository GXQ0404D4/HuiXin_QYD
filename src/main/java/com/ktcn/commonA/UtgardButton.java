package com.ktcn.commonA;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.core.JIVariant;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.common.NotConnectedException;
import org.openscada.opc.lib.da.AddFailedException;
import org.openscada.opc.lib.da.DuplicateGroupException;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.Server;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.entity.ConfigPojo;
import com.ktcn.utils.OPCConfig;

@Component
public class UtgardButton {
	final ConnectionInformation ci = new ConnectionInformation();
	ConfigPojo te = new ConfigPojo();
	@Transactional 
	public String UpdateUtgard(String Address, int button) {
		
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
		final String itemId = "Siemens Ethernet.S7-200 SMART." + Address; // 项的名字按实际，没有实际PLC，用的模拟器：simulator
		// create a new server，启动服务
		final Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());
		try {
			// connect to server，连接到服务
			server.connect();
			// 组的名字随意，给组起名字是因为，server可以addGroup也可以removeGroup，读一次值，就先添加组，然后移除组，再读一次就再添加然后删除
			final Group group = server.addGroup("test");
			// Add a new item to the group，
			final Item item = group.addItem(itemId);
			final JIVariant value = new JIVariant(button); // 写入
			Integer write = item.write(value);
			
			System.out.println(write + "write 返回字");
			System.out.println(value + "value 返回字");
		} catch (final JIException e) {
			// System.out.println(String.format("%08X: %s", e.getErrorCode(),
			// server.getErrorMessage(e.getErrorCode())));
		} catch (AddFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotConnectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyConnectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemId ;

	}
}
