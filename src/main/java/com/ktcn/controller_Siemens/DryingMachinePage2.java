package com.ktcn.controller_Siemens;

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
* @version 创建时间：2020年1月9日 下午5:07:08
* 类说明  监控页面烧结干燥机数据
*/
@RestController
@PropertySource({ "classpath:config/drying_machine.properties" })
public final class DryingMachinePage2 {
	// 烧结干燥机
		@Value("${PLC0.GZJ0}")
		private static String GZJ0_0;
		@Value("${PLC0.GZJ1}")
		private static String GZJ0_1;
		@Value("${PLC0.GZJ2}")
		private static String GZJ0_2;
		@Value("${PLC0.GZJ3}")
		private static String GZJ0_3;
		@Value("${PLC0.GZJ4}")
		private static String GZJ0_4;
		@Value("${PLC0.GZJ5}")
		private static String GZJ0_5;
		@Value("${PLC0.GZJ6}")
		private static String GZJ0_6;
		@Value("${PLC0.GZJ10}")
		private static String GZJ0_10;
		@Value("${PLC0.GZJ11}")
		private static String GZJ0_11;
	
	// PLC 连接池 封装类配置类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
	@RequestMapping("/dryingmachine2")
	public Map <String,Object> getDryingMachineData2() {
		SiemensS7Net siemens_net = SiemensPlcConfig.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> SJGZJData=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			SJGZJData.put("SJGZJ0",siemens_net.ReadFloat(GZJ0_0).Content);
			SJGZJData.put("SJGZJ1",siemens_net.ReadFloat(GZJ0_1).Content);
			SJGZJData.put("SJGZJ2",siemens_net.ReadFloat(GZJ0_2).Content);
			SJGZJData.put("SJGZJ3",siemens_net.ReadFloat(GZJ0_3).Content);
			SJGZJData.put("SJGZJ4",siemens_net.ReadFloat(GZJ0_4).Content);
			SJGZJData.put("SJGZJ5",siemens_net.ReadFloat(GZJ0_5).Content);
			SJGZJData.put("SJGZJ6",siemens_net.ReadFloat(GZJ0_6).Content);
			SJGZJData.put("SJGZJ7",siemens_net.ReadFloat(GZJ0_10).Content);
			SJGZJData.put("SJGZJ8",siemens_net.ReadFloat(GZJ0_11).Content);
			
			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return SJGZJData;
	}
}
