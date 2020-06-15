package com.ktcn.simens.PLCdata;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2019年12月27日 下午4:36:02 类说明 
 * 干燥机PLC 获取数据类
 */
//@EnableScheduling // 此注解必加,必须要加，重中之重
@Order(value = 1)
@Component
@PropertySource({ "classpath:config/drying_machine.properties" })
public  class DryingMachineDatagain {

	//制氧干燥机
	@Value("${PLC.GZJ0}")
	private  String GZJ0;
	@Value("${PLC.GZJ1}")
	private  String GZJ1;
	@Value("${PLC.GZJ2}")
	private  String GZJ2;
	@Value("${PLC.GZJ3}")
	private  String GZJ3;
	@Value("${PLC.GZJ4}")
	private  String GZJ4;
	@Value("${PLC.GZJ5}")
	private  String GZJ5;
	@Value("${PLC.GZJ6}")
	private  String GZJ6;
	@Value("${PLC.GZJ7}")
	private  String GZJ7;
	@Value("${PLC.GZJ8}")
	private  String GZJ8;
	@Value("${PLC.GZJ9}")
	private  String GZJ9;
	@Value("${PLC.GZJ10}")
	private  String GZJ10;
	@Value("${PLC.GZJ11}")
	private  String GZJ11;


	@Autowired
	SiemensPlcConfig SiemensPlcConfig;	 	
	
	@Autowired
	DryingMachine DryingMachine;
	
	
//	@Async
//	@Scheduled(cron = "0/1 * * * * ?")
	public  DryingMachine getDryingMachineData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		
		if (siemensPLC.ConnectServer().IsSuccess) {
			//制氧干燥机数据获取
			DryingMachine.setGZJ0(siemensPLC.ReadFloat(GZJ0).Content);
			DryingMachine.setGZJ1(siemensPLC.ReadFloat(GZJ1).Content);
			DryingMachine.setGZJ2(siemensPLC.ReadFloat(GZJ2).Content);
			DryingMachine.setGZJ3(siemensPLC.ReadFloat(GZJ3).Content);
			DryingMachine.setGZJ4(siemensPLC.ReadFloat(GZJ4).Content);
			DryingMachine.setGZJ5(siemensPLC.ReadFloat(GZJ5).Content);
			DryingMachine.setGZJ6(siemensPLC.ReadInt32(GZJ6).Content);
			DryingMachine.setGZJ7(siemensPLC.ReadInt32(GZJ7).Content);
			DryingMachine.setGZJ8(siemensPLC.ReadBool(GZJ8).Content);
			DryingMachine.setGZJ9(siemensPLC.ReadBool(GZJ9).Content);
			DryingMachine.setGZJ10(siemensPLC.ReadBool(GZJ10).Content);
			DryingMachine.setGZJ11(siemensPLC.ReadBool(GZJ11).Content);
			
//			DryingMachine_serviceimp.setDryingMachineData(DryingMachine);
		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message+"干燥机异常");
		}
		siemensPLC.ConnectClose();
		// 数据读取完毕 获取当前时间
		System.out.println(DryingMachine );
		System.out.println("干燥机数据持久化+555" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
		return DryingMachine;
	}
	
}
