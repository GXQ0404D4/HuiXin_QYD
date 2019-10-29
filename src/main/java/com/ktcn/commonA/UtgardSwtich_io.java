package com.ktcn.commonA;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.ktcn.entity.ConfigPojo;
import com.ktcn.utils.OpcDataKyjSwitch;

@EnableScheduling // 此注解必加,必须要加，重中之重

//@Component // 此注解必加
//
//@Order(value = 1)
public class UtgardSwtich_io {

	@Autowired
	OpcDataKyjSwitch opcDataKyjInsert;
	
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
				ci.setClsid(te.getClsid()); // KEPServer的注册表ID，可以在“组件服务”里看到
				List<Boolean> f1 = new ArrayList<Boolean>();
				List<Boolean> f2 = new ArrayList<Boolean>();
				// 查询数据库所有采集通道点位
				Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());
				// JISystem.setJavaCoClassAutoCollection(false);
//				JISystem.setJavaCoClassAutoCollection(false);
				try {
					// 启动服务
					server.connect();
					// 添加到group组
					Group group = server.addGroup("swtich");

					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#KYJJZ/XZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#KYJJZ/XZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#FKDJ/LJ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#KYJBD/YC").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#KYJBJGZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#KYJJX").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#KYJJZ/XZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#KYJTJGZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#KYJYX").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#LGJGDYBJ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#LGJGZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-1#LGJYX").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#FKDJ/LJ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#KYJBD/YC").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#KYJBJGZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#KYJJX").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#KYJTJGZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#KYJYX").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#LGJGDYBJ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#LGJGZ").read(true).getValue().getObjectAsBoolean());			
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-2#LGJYX").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#FKDJ/LJ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#KYJBD/YC").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#KYJBJGZ").read(true).getValue().getObjectAsBoolean());
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#KYJJX").read(true).getValue().getObjectAsBoolean());					
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#KYJTJGZ").read(true).getValue().getObjectAsBoolean());					
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#KYJYX").read(true).getValue().getObjectAsBoolean());					
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#LGJGDYBJ").read(true).getValue().getObjectAsBoolean());					
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#LGJGZ").read(true).getValue().getObjectAsBoolean());					
					f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.DI-3#LGJYX").read(true).getValue().getObjectAsBoolean());					
					
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-1#KYJQD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-1#KYJTZ").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-1#LGJQD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-1#LGJTZ").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-2#KYJQD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-2#KYJTZ").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-2#LGJQD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-2#LGJTZ").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-3#KYJQD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-3#KYJTZ").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-3#LGJQD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-3#LGJTZ").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-1#KYJZD/SD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-2#KYJZD/SD").read(true).getValue().getObjectAsBoolean());
					f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.DO-3#KYJZD/SD").read(true).getValue().getObjectAsBoolean());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				server.dispose();

				opcDataKyjInsert.setKyjDataSwtich(f1,f2);
				
				 


	}
}
