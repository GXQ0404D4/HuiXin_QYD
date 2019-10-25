package com.ktcn.entity.opcaddress;

import java.util.ArrayList;
import java.util.List;

public class SwitchOutput {
	private final static String  O1="Siemens Ethernet.S7-200 SMART.DO-1#KYJQD";
	private final static String  O2="Siemens Ethernet.S7-200 SMART.DO-1#KYJTZ";
	private final static String  O3="Siemens Ethernet.S7-200 SMART.DO-1#LGJQD";
	private final static String  O4="Siemens Ethernet.S7-200 SMART.DO-1#LGJTZ";
	
	private final static String  O5="Siemens Ethernet.S7-200 SMART.DO-2#KYJQD";
	private final static String  O6="Siemens Ethernet.S7-200 SMART.DO-2#KYJTZ";
	private final static String  O7="Siemens Ethernet.S7-200 SMART.DO-2#LGJQD";
	private final static String  O8="Siemens Ethernet.S7-200 SMART.DO-2#LGJTZ";
	
	private final static String  O9="Siemens Ethernet.S7-200 SMART.DO-3#KYJQD";
	private final static String  O10="Siemens Ethernet.S7-200 SMART.DO-3#KYJTZ";
	private final static String  O11="Siemens Ethernet.S7-200 SMART.DO-3#LGJQD";
	private final static String  O12="Siemens Ethernet.S7-200 SMART.DO-3#LGJTZ";
	
	private final static String  O13="Siemens Ethernet.S7-200 SMART.DO-1#KYJZD/SD";
	private final static String  O14="Siemens Ethernet.S7-200 SMART.DO-2#KYJZD/SD";
	private final static String  O15="Siemens Ethernet.S7-200 SMART.DO-3#KYJZD/SD";
	
	List <String> list=new ArrayList<String>();
	
	public void getSwitchOutputAddress() {
		list.add(O1);
		list.add(O2);
		list.add(O3);
		list.add(O4);
		list.add(O5);
		list.add(O6);
		list.add(O7);
		list.add(O8);
		list.add(O9);
		list.add(O10);
		list.add(O11);
		list.add(O12);
		list.add(O13);
		list.add(O14);
		list.add(O15);
	}

}
