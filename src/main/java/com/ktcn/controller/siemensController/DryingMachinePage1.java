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
* 类说明  监控页面制氧干燥机数据
*/
@RestController
@PropertySource({ "classpath:config/drying_machine.properties" })
public final class DryingMachinePage1 {
//制氧干燥机
	@Value("${PLC.GZJ0}")
	private static String GZJ0;
	@Value("${PLC.GZJ1}")
	private static String GZJ1;
	@Value("${PLC.GZJ2}")
	private static String GZJ2;
	@Value("${PLC.GZJ3}")
	private static String GZJ3;
	@Value("${PLC.GZJ4}")
	private static String GZJ4;
	@Value("${PLC.GZJ5}")
	private static String GZJ5;
	@Value("${PLC.GZJ12}")
	private static String GZJ12;
	
	@Value("${PLC.GZJ19}")
	private static String GZJ19;
	@Value("${PLC.GZJ20}")
	private static String GZJ20;
	@Value("${PLC.GZJ21}")
	private static String GZJ21;
	@Value("${PLC.GZJ22}")
	private static String GZJ22;
	@Value("${PLC.GZJ23}")
	private static String GZJ23;
	@Value("${PLC.GZJ24}")
	private static String GZJ24;
	@Value("${PLC.GZJ25}")
	private static String GZJ25;
	@Value("${PLC.GZJ26}")
	private static String GZJ26;
	@Value("${PLC.GZJ27}")
	private static String GZJ27;
	@Value("${PLC.GZJ28}")
	private static String GZJ28;
	@Value("${PLC.GZJ29}")
	private static String GZJ29;
	@Value("${PLC.GZJ30}")
	private static String GZJ30;
	@Value("${PLC.GZJ31}")
	private static String GZJ31;
	
	@Value("${PLC.GZJ32}")
	private static String GZJ32;
	@Value("${PLC.GZJ33}")
	private static String GZJ33;
	@Value("${PLC.GZJ34}")
	private static String GZJ34;
	@Value("${PLC.GZJ35}")
	private static String GZJ35;
	@Value("${PLC.GZJ36}")
	private static String GZJ36;
	@Value("${PLC.GZJ37}")
	private static String GZJ37;
	
	// PLC 连接池 封装类配置类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	@RequestMapping("/dryingmachine1")
	public Map <String,Object> getDryingMachineData1() {
		SiemensS7Net siemens_net = SiemensPlcConfig.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> ZYGZJData=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			ZYGZJData.put("ZYGZJ0",siemens_net.ReadFloat(GZJ0).Content);
			ZYGZJData.put("ZYGZJ1",siemens_net.ReadFloat(GZJ1).Content);
			ZYGZJData.put("ZYGZJ2",siemens_net.ReadFloat(GZJ2).Content);
			ZYGZJData.put("ZYGZJ3",siemens_net.ReadFloat(GZJ3).Content);
			ZYGZJData.put("ZYGZJ4",siemens_net.ReadFloat(GZJ4).Content);
			ZYGZJData.put("ZYGZJ5",siemens_net.ReadFloat(GZJ5).Content);
			ZYGZJData.put("ZYGZJ6",siemens_net.ReadFloat(GZJ12).Content);
			ZYGZJData.put("ZYGZJ7",siemens_net.ReadFloat(GZJ32).Content);
			ZYGZJData.put("ZYGZJ8",siemens_net.ReadFloat(GZJ33).Content);
			ZYGZJData.put("ZYGZJ9",siemens_net.ReadFloat(GZJ34).Content);
			ZYGZJData.put("ZYGZJ10",siemens_net.ReadFloat(GZJ35).Content);
			ZYGZJData.put("ZYGZJ11",siemens_net.ReadFloat(GZJ36).Content);
			ZYGZJData.put("ZYGZJ12",siemens_net.ReadFloat(GZJ37).Content);
			//制氧干燥机 1-13阀门状态
			ZYGZJData.put("ZYGZJ13",siemens_net.ReadFloat(GZJ19).Content);
			ZYGZJData.put("ZYGZJ14",siemens_net.ReadFloat(GZJ20).Content);
			ZYGZJData.put("ZYGZJ15",siemens_net.ReadFloat(GZJ21).Content);
			ZYGZJData.put("ZYGZJ16",siemens_net.ReadFloat(GZJ22).Content);
			ZYGZJData.put("ZYGZJ17",siemens_net.ReadFloat(GZJ23).Content);
			ZYGZJData.put("ZYGZJ18",siemens_net.ReadFloat(GZJ24).Content);
			ZYGZJData.put("ZYGZJ19",siemens_net.ReadFloat(GZJ25).Content);
			ZYGZJData.put("ZYGZJ20",siemens_net.ReadFloat(GZJ26).Content);
			ZYGZJData.put("ZYGZJ21",siemens_net.ReadFloat(GZJ27).Content);
			ZYGZJData.put("ZYGZJ22",siemens_net.ReadFloat(GZJ28).Content);
			ZYGZJData.put("ZYGZJ23",siemens_net.ReadFloat(GZJ29).Content);
			ZYGZJData.put("ZYGZJ24",siemens_net.ReadFloat(GZJ30).Content);
			ZYGZJData.put("ZYGZJ25",siemens_net.ReadFloat(GZJ31).Content);
			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return ZYGZJData;
	}
}
