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
	
		@Value("${PLC0.GZJ19}")
		private static String GZJ0_19;
		@Value("${PLC0.GZJ20}")
		private static String GZJ0_20;
		@Value("${PLC0.GZJ21}")
		private static String GZJ0_21;
		@Value("${PLC0.GZJ22}")
		private static String GZJ0_22;
		@Value("${PLC0.GZJ23}")
		private static String GZJ0_23;
		@Value("${PLC0.GZJ24}")
		private static String GZJ0_24;
		@Value("${PLC0.GZJ25}")
		private static String GZJ0_25;
		@Value("${PLC0.GZJ26}")
		private static String GZJ0_26;
		@Value("${PLC0.GZJ27}")
		private static String GZJ0_27;
		@Value("${PLC0.GZJ28}")
		private static String GZJ0_28;
		@Value("${PLC0.GZJ29}")
		private static String GZJ0_29;
		@Value("${PLC0.GZJ30}")
		private static String GZJ0_30;
		@Value("${PLC0.GZJ31}")
		private static String GZJ0_31;
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
			//烧结干燥机 1-13 阀门状态灯
			SJGZJData.put("SJGZJ9",siemens_net.ReadFloat(GZJ0_19).Content);
			SJGZJData.put("SJGZJ10",siemens_net.ReadFloat(GZJ0_20).Content);
			SJGZJData.put("SJGZJ11",siemens_net.ReadFloat(GZJ0_21).Content);
			SJGZJData.put("SJGZJ12",siemens_net.ReadFloat(GZJ0_22).Content);
			SJGZJData.put("SJGZJ13",siemens_net.ReadFloat(GZJ0_23).Content);
			SJGZJData.put("SJGZJ14",siemens_net.ReadFloat(GZJ0_24).Content);
			SJGZJData.put("SJGZJ15",siemens_net.ReadFloat(GZJ0_25).Content);
			SJGZJData.put("SJGZJ16",siemens_net.ReadFloat(GZJ0_26).Content);
			SJGZJData.put("SJGZJ17",siemens_net.ReadFloat(GZJ0_27).Content);
			SJGZJData.put("SJGZJ18",siemens_net.ReadFloat(GZJ0_28).Content);
			SJGZJData.put("SJGZJ19",siemens_net.ReadFloat(GZJ0_29).Content);
			SJGZJData.put("SJGZJ20",siemens_net.ReadFloat(GZJ0_30).Content);
			SJGZJData.put("SJGZJ21",siemens_net.ReadFloat(GZJ0_31).Content);

			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return SJGZJData;
	}
}
