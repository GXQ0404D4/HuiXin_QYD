package com.ktcn.simens.PLCdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ktcn.service.siemensService.CentrifugeService;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午4:03:37
* 类说明  离心机获取数据类
*/


//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)
@PropertySource({"classpath:config/centrifuge.properties"})
public final class CentrifugeDatagain {
	
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
	
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;

	@Autowired
	CentrifugeService centrifugeServiceImp;
	

	
//	@Async
	@Scheduled(cron = "0/10 * * * * ?")
	public  void getCentrifugeData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		ArrayList<Float> CentrifugeData = new ArrayList<Float>();
		if (siemensPLC.ConnectServer().IsSuccess) {
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ5).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ7).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ8).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ9).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ10).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ11).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ14).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ15).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ16).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ17).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ18).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ19).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ20).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ21).Content);
			CentrifugeData.add(siemensPLC.ReadFloat(LXJ22).Content);
			
			siemensPLC.ConnectClose();
			centrifugeServiceImp.setCentrifugeData(CentrifugeData);
			
		} else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
		
//		System.out.println("第一组数据————————%%%%%%%%%%%%%%%%%%%%%%%%__________-!"+CentrifugeData );
			// 数据读取完毕 获取当前时间
		System.out.println(" ");
		System.out.println("持久化到离心机" +siemensPLC.hashCode()+  new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}

}
