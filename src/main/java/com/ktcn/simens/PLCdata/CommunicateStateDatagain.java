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

import com.ktcn.service.siemensService.CommunicateService;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午4:29:30
* 类说明
* 通信状态获取PLC 数据类
*/
//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)

@PropertySource({"classpath:config/communicate.properties"})
public final class CommunicateStateDatagain {
	
	@Value("${PLC.TX0}")
	private  String TX0;
	@Value("${PLC.TX1}")
	private  String TX1;
	@Value("${PLC.TX2}")
	private  String TX2;
	@Value("${PLC.TX3}")
	private  String TX3;
	@Value("${PLC.TX4}")
	private  String TX4;
	@Value("${PLC.TX5}")
	private  String TX5;
	@Value("${PLC.TX6}")
	private  String TX6;
	@Value("${PLC.TX7}")
	private  String TX7;
	@Value("${PLC.TX8}")
	private  String TX8;
	@Value("${PLC.TX9}")
	private  String TX9;
	@Value("${PLC.TX10}")
	private  String TX10;
	@Value("${PLC.TX11}")
	private  String TX11;
	
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	 
	@Autowired
	CommunicateService CommunicateServiceImp;
	
//	@Async
	@Scheduled(cron = "0/1 * * * * ?")
	public  void getCommunicateData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		List<Boolean> CommunicationData = new ArrayList<Boolean>();
		//通信状态数据获取
		if (siemensPLC.ConnectServer().IsSuccess) {
			CommunicationData.add(siemensPLC.ReadBool(TX0).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX1).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX2).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX3).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX4).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX5).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX6).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX7).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX8).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX9).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX10).Content);
			CommunicationData.add(siemensPLC.ReadBool(TX11).Content);
			siemensPLC.ConnectClose();
			System.out.println(CommunicationData);
			CommunicateServiceImp.setCommunicateData(CommunicationData);
		} else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
		
//		System.out.println("第一组数据————————%%%%%%%%%%%%%%%%%%%%%%%%__________-!"+CommunicationData );
			// 数据读取完毕 获取当前时间
		System.out.println(" ");
		System.out.println("持久化通信状态" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}

}
