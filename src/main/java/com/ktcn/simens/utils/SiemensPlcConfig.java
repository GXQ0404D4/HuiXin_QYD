package com.ktcn.simens.utils;

import org.springframework.stereotype.Component;

import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午1:34:33
*    SiemensPLC获取对象封装类 IP192.168.0.1
*/
@Component
public class SiemensPlcConfig {
	
	public SiemensS7Net getSiemensPLC() {
			SiemensS7Net siemens_net = new SiemensS7Net(SiemensPLCS.S1200,"192.168.0.1");
		return siemens_net;
	}
	
}
