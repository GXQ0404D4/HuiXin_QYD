package com.ktcn.simens.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午1:34:33
*    SiemensPLC获取对象封装类 IP192.168.1.1
*/
@Component
@PropertySource({"classpath:config/plc_ip.properties"})
public class SiemensPlcConfig6 {
	
//	@Value("${PLC.IP}")
//	private static String IP;
	
	static SiemensS7Net siemens_net = null;

	
	public static SiemensS7Net getSiemensPLC() {
		if (siemens_net==null) {
			siemens_net=new SiemensS7Net(SiemensPLCS.S1200,"192.168.1.1");
		}
		return siemens_net;
	}
	
}
