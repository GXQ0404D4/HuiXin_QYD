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
* @version 创建时间：2020年1月9日 下午4:33:30
* 类说明 监控页面实时 离心机数据
*/
@RestController
@PropertySource({"classpath:config/centrifuge.properties"})
public final class CentrifugePage {
	@Value("${PLC.LXJ5}")
	private  String LXJ5;
	@Value("${PLC.LXJ7}")
	private  String LXJ7;
	@Value("${PLC.LXJ8}")
	private  String LXJ8;
	@Value("${PLC.LXJ9}")
	private  String LXJ9;
	@Value("${PLC.LXJ10}")
	private  String LXJ10;
	@Value("${PLC.LXJ11}")
	private  String LXJ11;
	@Value("${PLC.LXJ14}")
	private  String LXJ14;
	@Value("${PLC.LXJ15}")
	private  String LXJ15;
	@Value("${PLC.LXJ16}")
	private  String LXJ16;
	@Value("${PLC.LXJ17}")
	private  String LXJ17;
	@Value("${PLC.LXJ18}")
	private  String LXJ18;
	@Value("${PLC.LXJ19}")
	private  String LXJ19;
	@Value("${PLC.LXJ20}")
	private  String LXJ20;
	@Value("${PLC.LXJ21}")
	private  String LXJ21;
	@Value("${PLC.LXJ22}")
	private  String LXJ22;
	
	// PLC 连接池 封装类配置类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
//	@Autowired
//	Centrifuge_Address centrifuge_Address;
	@RequestMapping("/centrifuge")
	public Map <String,Object> getCentrifugePageData() {
		SiemensS7Net siemens_net = SiemensPlcConfig.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> LXJData=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			LXJData.put("LXJ0",siemens_net.ReadFloat(LXJ7).Content);
			LXJData.put("LXJ1",siemens_net.ReadFloat(LXJ8).Content);
			LXJData.put("LXJ2",siemens_net.ReadFloat(LXJ9).Content);
			LXJData.put("LXJ3",siemens_net.ReadFloat(LXJ10).Content);
			LXJData.put("LXJ4",siemens_net.ReadFloat(LXJ11).Content);
			LXJData.put("LXJ5",siemens_net.ReadFloat(LXJ16).Content);
			LXJData.put("LXJ6",siemens_net.ReadFloat(LXJ17).Content);
			LXJData.put("LXJ7",siemens_net.ReadFloat(LXJ18).Content);
			LXJData.put("LXJ8",siemens_net.ReadFloat(LXJ19).Content);
			LXJData.put("LXJ9",siemens_net.ReadFloat(LXJ20).Content);
			LXJData.put("LXJ10",siemens_net.ReadFloat(LXJ21).Content);
			LXJData.put("LXJ11",siemens_net.ReadFloat(LXJ22).Content);
			
			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return LXJData;
	}
}
