package com.ktcn.entity.opcaddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ktcn.entity.Electric_massage;

import lombok.Data;

@Component
public class KyjOpcAddress1 {
	private final static String A1="Siemens Ethernet.S7-200 SMART.1#A相电压";
	private final static String A2="Siemens Ethernet.S7-200 SMART.1#A相电流";
	private final static String A3="Siemens Ethernet.S7-200 SMART.1#主机温度";
	private final static String A4="Siemens Ethernet.S7-200 SMART.1#冷却剂温度";
	private final static String A5="Siemens Ethernet.S7-200 SMART.1#分离前压力";
	private final static String A6="Siemens Ethernet.S7-200 SMART.1#加载压力";
	private final static String A7="Siemens Ethernet.S7-200 SMART.1#加载时间";
	private final static String A8="Siemens Ethernet.S7-200 SMART.1#卸载压力";
	private final static String A9="Siemens Ethernet.S7-200 SMART.1#报警号";
	private final static String A10="Siemens Ethernet.S7-200 SMART.1#排气压力";
	private final static String A11="Siemens Ethernet.S7-200 SMART.1#排气温度";
	private final static String A12="Siemens Ethernet.S7-200 SMART.1#控制状态字";
	private final static String A13="Siemens Ethernet.S7-200 SMART.1#正向有功总电能";
	private final static String A14="Siemens Ethernet.S7-200 SMART.1#警告号";
	private final static String A15="Siemens Ethernet.S7-200 SMART.1#运行时间";
	private final static String A16="Siemens Ethernet.S7-200 SMART.1#远程功能开关";
	private final static String A17="Siemens Ethernet.S7-200 SMART.AI-1#有功功率";
	private final static String A18="Siemens Ethernet.S7-200 SMART.压力";
	private final static String A19="Siemens Ethernet.S7-200 SMART.瞬时流量";
	private final static String A20="Siemens Ethernet.S7-200 SMART.瞬时功率";
	private final static String A21="Siemens Ethernet.S7-200 SMART.补偿后流量";
    List<String> listaddress=new ArrayList<String>();
    public List<String> getListAddress() {
    	listaddress.add(A1);
    	listaddress.add(A2);
    	listaddress.add(A3);
    	listaddress.add(A4);
    	listaddress.add(A5);
    	listaddress.add(A6);
    	listaddress.add(A7);
    	listaddress.add(A8);
    	listaddress.add(A9);
    	listaddress.add(A10);
    	listaddress.add(A11);
    	listaddress.add(A12);
    	listaddress.add(A13);
    	listaddress.add(A14);
    	listaddress.add(A15);
    	listaddress.add(A16);
    	listaddress.add(A17);
    	listaddress.add(A18);
    	listaddress.add(A19);
    	listaddress.add(A20);
    	listaddress.add(A21);
		return listaddress;
    }
}
