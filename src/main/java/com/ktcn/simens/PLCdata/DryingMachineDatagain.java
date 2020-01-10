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

import com.ktcn.service.DryingMachineService;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2019年12月27日 下午4:36:02 类说明 干燥机PLC 获取数据类
// */
//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)
@PropertySource({ "classpath:config/drying_machine.properties" })
public final class DryingMachineDatagain {

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
	@Value("${PLC.GZJ15}")
	private static String GZJ15;
	@Value("${PLC.GZJ16}")
	private static String GZJ16;
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
	@Value("${PLC0.GZJ12}")
	private static String GZJ0_12;
	@Value("${PLC0.GZJ13}")
	private static String GZJ0_13;
	@Value("${PLC0.GZJ14}")
	private static String GZJ0_14;
	@Value("${PLC0.GZJ15}")
	private static String GZJ0_15;
	@Value("${PLC0.GZJ16}")
	private static String GZJ0_16;

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

	// 干燥机1
	@Value("${PLC1.GZJ1}")
	private static String GZJ1_1;
	@Value("${PLC1.GZJ2}")
	private static String GZJ1_2;
	@Value("${PLC1.GZJ3}")
	private static String GZJ1_3;
	@Value("${PLC1.GZJ4}")
	private static String GZJ1_4;

	// 干燥机2
	@Value("${PLC2.GZJ1}")
	private static String GZJ2_1;
	@Value("${PLC2.GZJ2}")
	private static String GZJ2_2;
	@Value("${PLC2.GZJ3}")
	private static String GZJ2_3;
	@Value("${PLC2.GZJ4}")
	private static String GZJ2_4;

	// 干燥机3
	@Value("${PLC3.GZJ1}")
	private static String GZJ3_1;
	@Value("${PLC3.GZJ2}")
	private static String GZJ3_2;
	@Value("${PLC3.GZJ3}")
	private static String GZJ3_3;
	@Value("${PLC3.GZJ4}")
	private static String GZJ3_4;

	// 干燥机4
	@Value("${PLC4.GZJ1}")
	private static String GZJ4_1;
	@Value("${PLC4.GZJ2}")
	private static String GZJ4_2;
	@Value("${PLC4.GZJ3}")
	private static String GZJ4_3;
	@Value("${PLC4.GZJ4}")
	private static String GZJ4_4;

	// 干燥机5
	@Value("${PLC5.GZJ1}")
	private static String GZJ5_1;
	@Value("${PLC5.GZJ2}")
	private static String GZJ5_2;
	@Value("${PLC5.GZJ3}")
	private static String GZJ5_3;
	@Value("${PLC5.GZJ4}")
	private static String GZJ5_4;

	// 干燥机6
	@Value("${PLC6.GZJ1}")
	private static String GZJ6_1;
	@Value("${PLC6.GZJ2}")
	private static String GZJ6_2;
	@Value("${PLC6.GZJ3}")
	private static String GZJ6_3;
	@Value("${PLC6.GZJ4}")
	private static String GZJ6_4;

	// 干燥机7
	@Value("${PLC7.GZJ1}")
	private static String GZJ7_1;
	@Value("${PLC7.GZJ2}")
	private static String GZJ7_2;
	@Value("${PLC7.GZJ3}")
	private static String GZJ7_3;
	@Value("${PLC7.GZJ4}")
	private static String GZJ7_4;
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	 
	@Autowired
	DryingMachineService DryingMachineServiceImp;
	
//	@Async
	@Scheduled(cron = "0/1 * * * * ?")
	public  void getDryingMachineData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		Map<String, List> MapData=new HashMap<String, List>();
		List<Object> DryingMachineData0 = new ArrayList<Object>();
		List<Object> DryingMachineData1 = new ArrayList<Object>();
		List<Object> DryingMachineData2 = new ArrayList<Object>();
		List<Object> DryingMachineData3 = new ArrayList<Object>();
		List<Object> DryingMachineData4 = new ArrayList<Object>();
		List<Object> DryingMachineData5 = new ArrayList<Object>();
		List<Object> DryingMachineData6 = new ArrayList<Object>();
		List<Object> DryingMachineData7 = new ArrayList<Object>();
		List<Object> DryingMachineData8 = new ArrayList<Object>();
		
		if (siemensPLC.ConnectServer().IsSuccess) {
			//制氧干燥机数据获取
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ0).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ1).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ2).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ3).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ4).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ5).Content);
			
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ12).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ15).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ16).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ19).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ20).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ21).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ22).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ23).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ24).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ25).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ26).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ27).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ28).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ29).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ30).Content);
			DryingMachineData0.add(siemensPLC.ReadBool(GZJ31).Content);
			
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ32).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ33).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ34).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ35).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ36).Content);
			DryingMachineData0.add(siemensPLC.ReadFloat(GZJ37).Content);
			
			//烧结干燥机数据获取
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_0).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_1).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_2).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_3).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_4).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_5).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_6).Content);			
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_10).Content);
			DryingMachineData1.add(siemensPLC.ReadFloat(GZJ0_11).Content);
			
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_12).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_13).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_14).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_15).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_16).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_19).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_20).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_21).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_22).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_23).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_24).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_25).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_26).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_27).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_28).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_29).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_30).Content);
			DryingMachineData1.add(siemensPLC.ReadBool(GZJ0_31).Content);
			
			//干燥机1
			DryingMachineData2.add(siemensPLC.ReadBool(GZJ1_1).Content);
			DryingMachineData2.add(siemensPLC.ReadBool(GZJ1_2).Content);
			DryingMachineData2.add(siemensPLC.ReadBool(GZJ1_3).Content);
			DryingMachineData2.add(siemensPLC.ReadBool(GZJ1_4).Content);
			
			//干燥机2
			DryingMachineData3.add(siemensPLC.ReadBool(GZJ2_1).Content);
			DryingMachineData3.add(siemensPLC.ReadBool(GZJ2_2).Content);
			DryingMachineData3.add(siemensPLC.ReadBool(GZJ2_3).Content);
			DryingMachineData3.add(siemensPLC.ReadBool(GZJ2_4).Content);
			
			//干燥机3                                                        
			DryingMachineData4.add(siemensPLC.ReadBool(GZJ3_1).Content);  
			DryingMachineData4.add(siemensPLC.ReadBool(GZJ3_2).Content);  
			DryingMachineData4.add(siemensPLC.ReadBool(GZJ3_3).Content);  
			DryingMachineData4.add(siemensPLC.ReadBool(GZJ3_4).Content);  
			
			//干燥机4                                                        
			DryingMachineData5.add(siemensPLC.ReadBool(GZJ4_1).Content);  
			DryingMachineData5.add(siemensPLC.ReadBool(GZJ4_2).Content);  
			DryingMachineData5.add(siemensPLC.ReadBool(GZJ4_3).Content);  
			DryingMachineData5.add(siemensPLC.ReadBool(GZJ4_4).Content);  
			
			//干燥机5                                                        
			DryingMachineData6.add(siemensPLC.ReadBool(GZJ5_1).Content);  
			DryingMachineData6.add(siemensPLC.ReadBool(GZJ5_2).Content);  
			DryingMachineData6.add(siemensPLC.ReadBool(GZJ5_3).Content);  
			DryingMachineData6.add(siemensPLC.ReadBool(GZJ5_4).Content);  
			
			//干燥机6                                                        
			DryingMachineData7.add(siemensPLC.ReadBool(GZJ6_1).Content);  
			DryingMachineData7.add(siemensPLC.ReadBool(GZJ6_2).Content);  
			DryingMachineData7.add(siemensPLC.ReadBool(GZJ6_3).Content);  
			DryingMachineData7.add(siemensPLC.ReadBool(GZJ6_4).Content);  
			
			//干燥机7                                                        
			DryingMachineData8.add(siemensPLC.ReadBool(GZJ7_1).Content);  
			DryingMachineData8.add(siemensPLC.ReadBool(GZJ7_2).Content);  
			DryingMachineData8.add(siemensPLC.ReadBool(GZJ7_3).Content);  
			DryingMachineData8.add(siemensPLC.ReadBool(GZJ7_4).Content);  
			siemensPLC.ConnectClose();
		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message);
		}
		MapData.put("DryingMachineData0", DryingMachineData0);
		MapData.put("DryingMachineData1", DryingMachineData1);
		MapData.put("DryingMachineData2", DryingMachineData2);
		MapData.put("DryingMachineData3", DryingMachineData3);
		MapData.put("DryingMachineData4", DryingMachineData4);
		MapData.put("DryingMachineData5", DryingMachineData5);
		MapData.put("DryingMachineData6", DryingMachineData6);
		MapData.put("DryingMachineData7", DryingMachineData7);
		MapData.put("DryingMachineData8", DryingMachineData8);
		DryingMachineServiceImp.setDryingMachineData(MapData);
		
		// 数据读取完毕 获取当前时间
		System.out.println(" ");
		System.out.println("干燥机数据持久化" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}
}
