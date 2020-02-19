package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年2月11日 上午11:35:39
* 类说明
*/

@RestController
@PropertySource({"classpath:config/communicate.properties"})
public final class CommunicatePage {

	//通信状态网络图
	@Value("${PLC.TX0}")
	private String TX0;
	@Value("${PLC.TX1}")
	private String TX1;
	@Value("${PLC.TX2}")
	private String TX2;
	@Value("${PLC.TX3}")
	private String TX3;
	@Value("${PLC.TX4}")
	private String TX4;
	@Value("${PLC.TX5}")
	private String TX5;
	@Value("${PLC.TX6}")
	private String TX6;
	@Value("${PLC.TX7}")
	private String TX7;
	@Value("${PLC.TX8}")
	private String TX8;
	@Value("${PLC.TX9}")
	private String TX9;
	@Value("${PLC.TX10}")
	private String TX10;
	@Value("${PLC.TX11}")
	private String TX11;
	
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	//通信状态 网络图
	@RequestMapping("/communicatePage")
	public Map<String,Object> getCommunicatePage(){
		SiemensS7Net siemens_net = SiemensPlcConfig.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> CommPage=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			CommPage.put("Comm0",siemens_net.ReadBool(TX0).Content);
			CommPage.put("Comm1",siemens_net.ReadBool(TX1).Content);
			CommPage.put("Comm2",siemens_net.ReadBool(TX2).Content);
			CommPage.put("Comm3",siemens_net.ReadBool(TX3).Content);
			CommPage.put("Comm4",siemens_net.ReadBool(TX4).Content);
			CommPage.put("Comm5",siemens_net.ReadBool(TX5).Content);
			CommPage.put("Comm6",siemens_net.ReadBool(TX6).Content);
			CommPage.put("Comm7",siemens_net.ReadBool(TX7).Content);
			CommPage.put("Comm8",siemens_net.ReadBool(TX8).Content);
			CommPage.put("Comm9",siemens_net.ReadBool(TX9).Content);
			CommPage.put("Comm10",siemens_net.ReadBool(TX10).Content);
			CommPage.put("Comm11",siemens_net.ReadBool(TX11).Content);
		
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		return CommPage;
	}
}
