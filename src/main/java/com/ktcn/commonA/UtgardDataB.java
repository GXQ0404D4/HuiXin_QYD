package com.ktcn.commonA;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import org.jinterop.dcom.common.JISystem;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ktcn.entity.ConfigPojo;
import com.ktcn.entity.opcaddress.KyjOpcAddress2;
import com.ktcn.utils.OpcDataKyjInsertB;

//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)
public class UtgardDataB {
	@Autowired
	OpcDataKyjInsertB opcDataKyjInsertB;
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
		// 提取采集float数据
		ArrayList<Object> f1 = new ArrayList<Object>();
		ArrayList<Object> f2 = new ArrayList<Object>();
		ArrayList<Object> f3 = new ArrayList<Object>();
		// 查询数据库所有采集通道点位

		Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());
		// JISystem.setJavaCoClassAutoCollection(false);
		JISystem.setJavaCoClassAutoCollection(false);
		try {
			// 启动服务
			server.connect();
			// 添加到group组
			Group group = server.addGroup("test");

			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#A相电压").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#A相电流").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#主机温度").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#冷却剂温度").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#分离前压力").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#加载压力").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#加载时间").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#卸载压力").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#报警号").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#排气压力").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#排气温度").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#控制状态字").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#正向有功总电能").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#警告号").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#运行时间").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.1#远程功能开关").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.AI-1#有功功率").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.压力").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.瞬时流量").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.瞬时功率").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.补偿后流量").read(true).getValue().getObject());			
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.露点1").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.总功率").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.总电量").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.电量1").read(true).getValue().getObject());
			f1.add(group.addItem("Siemens Ethernet.S7-200 SMART.功率因数1").read(true).getValue().getObject());
			
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#A相电压").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#A相电流").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#主机温度").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#冷却剂温度").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#分离前压力").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#加载压力").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#加载时间").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#卸载压力").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#报警号").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#排气压力").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#排气温度").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#控制状态字").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#正向有功总电能").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#警告号").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#运行时间").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.2#远程功能开关").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.AI-2#有功功率").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.压力").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.瞬时流量").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.瞬时功率").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.补偿后流量").read(true).getValue().getObject());			
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.露点1").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.总功率").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.总电量").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.电量2").read(true).getValue().getObject());
			f2.add(group.addItem("Siemens Ethernet.S7-200 SMART.功率因数2").read(true).getValue().getObject());
			
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#A相电压").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#A相电流").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#主机温度").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#冷却剂温度").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#分离前压力").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#加载压力").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#加载时间").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#卸载压力").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#报警号").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#排气压力").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#排气温度").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#控制状态字").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#正向有功总电能").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#警告号").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#运行时间").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.3#远程功能开关").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.AI-3#有功功率").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.压力").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.瞬时流量").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.瞬时功率").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.补偿后流量").read(true).getValue().getObject());			
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.露点1").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.总功率").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.总电量").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.电量3").read(true).getValue().getObject());
			f3.add(group.addItem("Siemens Ethernet.S7-200 SMART.功率因数3").read(true).getValue().getObject());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		server.dispose();

		opcDataKyjInsertB.setKyjDataTable(f1,f2,f3);

	}
}