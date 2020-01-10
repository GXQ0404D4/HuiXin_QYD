package com.ktcn.simens.PLCdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ktcn.service.FlowGaugeService;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午4:38:48
* 类说明
* 流量计 PLC 数据获取
*/
//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)

@PropertySource({"classpath:config/flow_gauge.properties"})
public final class FlowGaugeDatagain {
	
	@Value("${PLC0.LLJ2]")
	private static String LLJ2;
	@Value("${PLC0.LLJ3]")
	private static String LLJ3;
	@Value("${PLC0.LLJ4]")
	private static String LLJ4;
	@Value("${PLC0.LLJ5]")
	private static String LLJ5;
	
	@Value("${PLC1.LLJ2]")
	private static String LLJ1_2;
	@Value("${PLC1.LLJ1_3]")
	private static String LLJ1_3;
	@Value("${PLC1.LLJ4]")
	private static String LLJ1_4;
	@Value("${PLC1.LLJ5]")
	private static String LLJ1_5;
	
	
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
	@Autowired
	FlowGaugeService FlowGaugeServiceImp;
	
//	@Async
	@Scheduled(cron = "0/1 * * * * ?")
	public  void getFlowGaugeData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		List<Float> FlowGaugeData = new ArrayList <Float>();
		List<Float> FlowGaugeData1 = new ArrayList <Float>();
		if (siemensPLC.ConnectServer().IsSuccess) {
			//制氧总管
			FlowGaugeData.add(siemensPLC.ReadFloat(LLJ2).Content);
			FlowGaugeData.add(siemensPLC.ReadFloat(LLJ3).Content);
			FlowGaugeData.add(siemensPLC.ReadFloat(LLJ4).Content);
			FlowGaugeData.add(siemensPLC.ReadFloat(LLJ5).Content);
			//烧结总管
			FlowGaugeData1.add(siemensPLC.ReadFloat(LLJ1_2).Content);
			FlowGaugeData1.add(siemensPLC.ReadFloat(LLJ1_3).Content);
			FlowGaugeData1.add(siemensPLC.ReadFloat(LLJ1_4).Content);
			FlowGaugeData1.add(siemensPLC.ReadFloat(LLJ1_5).Content);
			
			siemensPLC.ConnectClose();
		} else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
		//持久化到冷却剂数据表
		FlowGaugeServiceImp.setFlowGaugeData(FlowGaugeData,FlowGaugeData1);
		
//		System.out.println("第一组数据————————制氧总管__________-!"+FlowGaugeData );
//		System.out.println("第一组数据————————烧结总管__________-!"+FlowGaugeData1 );
		// 数据读取完毕 获取当前时间
		System.out.println(" ");
		System.out.println("持久化到冷却剂" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}
}
