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
public class SiemensPlcConfig {
	
	@Value("${PLC.IP}")
	private String IP;
	
	public SiemensS7Net getSiemensPLC() {
		
		return new SiemensS7Net(SiemensPLCS.S1200, IP);
	}
	
}
