package com.ktcn.simens.PLCdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ktcn.service.siemensServiceImp.AmmeterServiceImp;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午1:17:32
*     电表数据获取   
*     西门子 S7-1200 PLC 获取
*/


@EnableScheduling // 此注解必加,必须要加，重中之重

@Component // 此注解必加

@Order(value = 1)

@PropertySource({"classpath:config/ammeter.properties"})
public final class AmmeterDatagain {
//	烧结电表地址值
	@Value("${PLC0.DB9}")
	private   String DB9;
	@Value("${PLC0.DB10}")
	private  String DB10;
	@Value("${PLC0.DB11}")
	private  String DB11;
	@Value("${PLC0.DB12}")
	private  String DB12;
//  离心机电表地址值
	@Value("${PLC1.DB9}")
	private  String DB9_1;
	@Value("${PLC1.DB10}")
	private  String DB10_1;
	@Value("${PLC1.DB11}")
	private  String DB11_1;
	@Value("${PLC1.DB12}")
	private  String DB12_1;
//  空压机1电表地址值
	@Value("${PLC2.DB9}")
	private  String DB9_2;
	@Value("${PLC2.DB10}")
	private  String DB10_2;
	@Value("${PLC2.DB11}")
	private  String DB11_2;
	@Value("${PLC2.DB12}")
	private  String DB12_2;
//  空压机2电表地址值	
	@Value("${PLC3.DB9}")
	private  String DB9_3;
	@Value("${PLC3.DB10}")
	private  String DB10_3;
	@Value("${PLC3.DB11}")
	private  String DB11_3;
	@Value("${PLC3.DB12}")
	private  String DB12_3;
//  空压机3电表地址值
	@Value("${PLC4.DB9}")
	private  String DB9_4;
	@Value("${PLC4.DB10}")
	private  String DB10_4;
	@Value("${PLC4.DB11}")
	private  String DB11_4;
	@Value("${PLC4.DB12}")
	private  String DB12_4;
//  空压机4电表地址值
	@Value("${PLC5.DB9}")
	private  String DB9_5;
	@Value("${PLC5.DB10}")
	private  String DB10_5;
	@Value("${PLC5.DB11}")
	private  String DB11_5;
	@Value("${PLC5.DB12}")
	private  String DB12_5;
//  空压机5电表地址值
	@Value("${PLC6.DB9}")
	private  String DB9_6;
	@Value("${PLC6.DB10}")
	private  String DB10_6;
	@Value("${PLC6.DB11}")
	private  String DB11_6;
	@Value("${PLC6.DB12}")
	private  String DB12_6;
//  空压机6电表地址值
	@Value("${PLC7.DB9}")
	private  String DB9_7;
	@Value("${PLC7.DB10}")
	private  String DB10_7;
	@Value("${PLC7.DB11}")
	private  String DB11_7;
	@Value("${PLC7.DB12}")
	private  String DB12_7;
//  空压机7电表地址值
	@Value("${PLC8.DB9}")
	private  String DB9_8;
	@Value("${PLC8.DB10}")
	private  String DB10_8;
	@Value("${PLC8.DB11}")
	private  String DB11_8;
	@Value("${PLC8.DB12}")
	private   String DB12_8;
	
	// PLC 连接池 封装类配置类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
	//电表数据处理类
	@Autowired
	AmmeterServiceImp ammeterServiceImp;
			
	
//	@Async
	@Scheduled(cron = "0/10 * * * * ?")
	public void getAmmeterData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		Map <String,List> DataMap=new HashMap<String,List>();

		List<Float> DataList1 = new ArrayList<Float>();
		List<Float> DataList2 = new ArrayList<Float>();
		List<Float> DataList3 = new ArrayList<Float>();
		List<Float> DataList4 = new ArrayList<Float>();
		List<Float> DataList5 = new ArrayList<Float>();
		List<Float> DataList6 = new ArrayList<Float>();
		List<Float> DataList7 = new ArrayList<Float>();
		List<Float> DataList8 = new ArrayList<Float>();
		List<Float> DataList9 = new ArrayList<Float>();
		
		if (siemensPLC.ConnectServer().IsSuccess) {
			//烧结电表获取数据
			DataList1.add(siemensPLC.ReadFloat(DB9).Content);
			DataList1.add(siemensPLC.ReadFloat(DB10).Content);
			DataList1.add(siemensPLC.ReadFloat(DB11).Content);
			DataList1.add(siemensPLC.ReadFloat(DB12).Content);
			//离心机电表获取数据
			DataList2.add(siemensPLC.ReadFloat(DB9_1).Content);
			DataList2.add(siemensPLC.ReadFloat(DB10_1).Content);
			DataList2.add(siemensPLC.ReadFloat(DB11_1).Content);
			DataList2.add(siemensPLC.ReadFloat(DB12_1).Content);
			//空压机1电表数据获取
			DataList3.add(siemensPLC.ReadFloat(DB9_2).Content);
			DataList3.add(siemensPLC.ReadFloat(DB10_2).Content);
			DataList3.add(siemensPLC.ReadFloat(DB11_2).Content);
			DataList3.add(siemensPLC.ReadFloat(DB12_2).Content);
			//空压机2电表数据获取
			DataList4.add(siemensPLC.ReadFloat(DB9_3).Content);
			DataList4.add(siemensPLC.ReadFloat(DB10_3).Content);
			DataList4.add(siemensPLC.ReadFloat(DB11_3).Content);
			DataList4.add(siemensPLC.ReadFloat(DB12_3).Content);
			//空压机3电表数据获取
			DataList5.add(siemensPLC.ReadFloat(DB9_4).Content);
			DataList5.add(siemensPLC.ReadFloat(DB10_4).Content);
			DataList5.add(siemensPLC.ReadFloat(DB11_4).Content);
			DataList5.add(siemensPLC.ReadFloat(DB12_4).Content);
			//空压机4电表数据获取
			DataList6.add(siemensPLC.ReadFloat(DB9_5).Content);
			DataList6.add(siemensPLC.ReadFloat(DB10_5).Content);
			DataList6.add(siemensPLC.ReadFloat(DB11_5).Content);
			DataList6.add(siemensPLC.ReadFloat(DB12_5).Content);
			//空压机5电表数据获取
			DataList7.add(siemensPLC.ReadFloat(DB9_6).Content);
			DataList7.add(siemensPLC.ReadFloat(DB10_6).Content);
			DataList7.add(siemensPLC.ReadFloat(DB11_6).Content);
			DataList7.add(siemensPLC.ReadFloat(DB12_6).Content);
			//空压机6电表数据获取
			DataList8.add(siemensPLC.ReadFloat(DB9_7).Content);
			DataList8.add(siemensPLC.ReadFloat(DB10_7).Content);
			DataList8.add(siemensPLC.ReadFloat(DB11_7).Content);
			DataList8.add(siemensPLC.ReadFloat(DB12_7).Content);
			//空压机7电表数据获取
			DataList9.add(siemensPLC.ReadFloat(DB9_8).Content);
			DataList9.add(siemensPLC.ReadFloat(DB10_8).Content);
			DataList9.add(siemensPLC.ReadFloat(DB11_8).Content);
			DataList9.add(siemensPLC.ReadFloat(DB12_8).Content);
			
			siemensPLC.ConnectClose();
			
			DataMap.put("DataList1", DataList1);
			DataMap.put("DataList2", DataList2);
			DataMap.put("DataList3", DataList3);
			DataMap.put("DataList4", DataList4);
			DataMap.put("DataList5", DataList5);
			DataMap.put("DataList6", DataList6);
			DataMap.put("DataList7", DataList7);
			DataMap.put("DataList8", DataList8);
			DataMap.put("DataList9", DataList9);
			ammeterServiceImp.setAmmeterData(DataMap);
			System.out.println(DataMap);
		} else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
		
//		System.out.println(DataMap);
		// 数据读取完毕 获取当前时间
	    System.out.println(" ");
		System.out.println("电表持续化到数据库" +siemensPLC.hashCode()+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}

}
