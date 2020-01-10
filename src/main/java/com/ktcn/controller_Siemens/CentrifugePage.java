package com.ktcn.controller_Siemens;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.simensaddress.Centrifuge_Address;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月9日 下午4:33:30
* 类说明 监控页面实时 离心机数据
*/
@RestController
public final class CentrifugePage {
	// PLC 连接池 封装类配置类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
	@Autowired
	Centrifuge_Address centrifuge_Address;
	@RequestMapping("/centrifuge")
	public Map <String,Object> getCentrifugePageData() {
		SiemensS7Net siemens_net = SiemensPlcConfig.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> LXJData=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			LXJData.put("LXJ0",siemens_net.ReadFloat(centrifuge_Address.getLXJ7()).Content);
			LXJData.put("LXJ1",siemens_net.ReadFloat(centrifuge_Address.getLXJ8()).Content);
			LXJData.put("LXJ2",siemens_net.ReadFloat(centrifuge_Address.getLXJ9()).Content);
			LXJData.put("LXJ3",siemens_net.ReadFloat(centrifuge_Address.getLXJ10()).Content);
			LXJData.put("LXJ4",siemens_net.ReadFloat(centrifuge_Address.getLXJ11()).Content);
			LXJData.put("LXJ5",siemens_net.ReadFloat(centrifuge_Address.getLXJ16()).Content);
			LXJData.put("LXJ6",siemens_net.ReadFloat(centrifuge_Address.getLXJ17()).Content);
			LXJData.put("LXJ7",siemens_net.ReadFloat(centrifuge_Address.getLXJ18()).Content);
			LXJData.put("LXJ8",siemens_net.ReadFloat(centrifuge_Address.getLXJ19()).Content);
			LXJData.put("LXJ9",siemens_net.ReadFloat(centrifuge_Address.getLXJ20()).Content);
			LXJData.put("LXJ10",siemens_net.ReadFloat(centrifuge_Address.getLXJ21()).Content);
			LXJData.put("LXJ11",siemens_net.ReadFloat(centrifuge_Address.getLXJ22()).Content);
			
			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return LXJData;
	}
}
