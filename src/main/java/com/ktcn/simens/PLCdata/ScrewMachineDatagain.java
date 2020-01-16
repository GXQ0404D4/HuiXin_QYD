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

import com.ktcn.service.siemensService.ScrewMachineService;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2019年12月27日 下午4:39:57 类说明 
 * ScrewMachine 螺杆机数据获取
 */
//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)

@PropertySource({ "classpath:config/screw_machine.properties" })
public final class ScrewMachineDatagain {
	// 空压机1
	@Value("${PLC0.LGJ26}")
	private String LGJ26;
	@Value("${PLC0.LGJ27}")
	private String LGJ27;
	@Value("${PLC0.LGJ28}")
	private String LGJ28;
	// 空压机2
	@Value("${PLC1.LGJ26}")
	private String LGJ1_26;
	@Value("${PLC1.LGJ27}")
	private String LGJ1_27;
	@Value("${PLC1.LGJ28}")
	private String LGJ1_28;
	// 空压机3
	@Value("${PLC2.LGJ26}")
	private String LGJ2_26;
	@Value("${PLC2.LGJ27}")
	private String LGJ2_27;
	@Value("${PLC2.LGJ28}")
	private String LGJ2_28;
	// 空压机4
	@Value("${PLC3.LGJ26}")
	private String LGJ3_26;
	@Value("${PLC3.LGJ27}")
	private String LGJ3_27;
	@Value("${PLC3.LGJ28}")
	private String LGJ3_28;
	// 空压机5
	@Value("${PLC4.LGJ26}")
	private String LGJ4_26;
	@Value("${PLC4.LGJ27}")
	private String LGJ4_27;
	@Value("${PLC4.LGJ28}")
	private String LGJ4_28;
	// 空压机6
	@Value("${PLC5.LGJ26}")
	private String LGJ5_26;
	@Value("${PLC5.LGJ27}")
	private String LGJ5_27;
	@Value("${PLC5.LGJ28}")
	private String LGJ5_28;
	// 空压机7
	@Value("${PLC6.LGJ26}")
	private String LGJ6_26;
	@Value("${PLC6.LGJ27}")
	private String LGJ6_27;
	@Value("${PLC6.LGJ28}")
	private String LGJ6_28;
	// 烧结变频1
	@Value("${PLC7.LGJ5}")
	private String LGJ7_5;
	@Value("${PLC7.LGJ6}")
	private String LGJ7_6;
	@Value("${PLC7.LGJ25}")
	private String LGJ7_25;
	@Value("${PLC7.LGJ26}")
	private String LGJ7_26;
	@Value("${PLC7.LGJ27}")
	private String LGJ7_27;
	// 烧结变频2
	@Value("${PLC8.LGJ5}")
	private String LGJ8_5;
	@Value("${PLC8.LGJ6}")
	private String LGJ8_6;
	@Value("${PLC8.LGJ25}")
	private String LGJ8_25;
	@Value("${PLC8.LGJ26}")
	private String LGJ8_26;
	@Value("${PLC8.LGJ27}")
	private String LGJ8_27;

	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
	@Autowired
	ScrewMachineService screwMachineServiceImp;
	
//	@Async
	@Scheduled(cron = "0/10 * * * * ?")
	public void getScrewMachineData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		final  Map<String,List> DataMap= new HashMap<String, List>();
		final  List<Boolean> ScrewMachineData = new ArrayList<Boolean>();
		final  List<Boolean> ScrewMachineData1 = new ArrayList<Boolean>();
		final  List<Boolean> ScrewMachineData2 = new ArrayList<Boolean>();
		final  List<Boolean> ScrewMachineData3 = new ArrayList<Boolean>();
		final  List<Boolean> ScrewMachineData4 = new ArrayList<Boolean>();
		final  List<Boolean> ScrewMachineData5 = new ArrayList<Boolean>();
		final  List<Boolean> ScrewMachineData6 = new ArrayList<Boolean>();
		final  List<Object> ScrewMachineData7 = new ArrayList<Object>();
		final  List<Object> ScrewMachineData8 = new ArrayList<Object>();
		if (siemensPLC.ConnectServer().IsSuccess) {
			//空压机1
			ScrewMachineData.add(siemensPLC.ReadBool(LGJ26).Content);
			ScrewMachineData.add(siemensPLC.ReadBool(LGJ27).Content);
			ScrewMachineData.add(siemensPLC.ReadBool(LGJ28).Content);
			//空压机2
			ScrewMachineData1.add(siemensPLC.ReadBool(LGJ1_26).Content);
			ScrewMachineData1.add(siemensPLC.ReadBool(LGJ1_27).Content);
			ScrewMachineData1.add(siemensPLC.ReadBool(LGJ1_28).Content);
			//空压机3
			ScrewMachineData2.add(siemensPLC.ReadBool(LGJ2_26).Content);
			ScrewMachineData2.add(siemensPLC.ReadBool(LGJ2_27).Content);
			ScrewMachineData2.add(siemensPLC.ReadBool(LGJ2_28).Content);
			//空压机4                        
			ScrewMachineData3.add(siemensPLC.ReadBool(LGJ3_26).Content);
			ScrewMachineData3.add(siemensPLC.ReadBool(LGJ3_27).Content);
			ScrewMachineData3.add(siemensPLC.ReadBool(LGJ3_28).Content);
			//空压机5                        
			ScrewMachineData4.add(siemensPLC.ReadBool(LGJ4_26).Content);
			ScrewMachineData4.add(siemensPLC.ReadBool(LGJ4_27).Content);
			ScrewMachineData4.add(siemensPLC.ReadBool(LGJ4_28).Content);
			//空压机6                        
			ScrewMachineData5.add(siemensPLC.ReadBool(LGJ5_26).Content);
			ScrewMachineData5.add(siemensPLC.ReadBool(LGJ5_27).Content);
			ScrewMachineData5.add(siemensPLC.ReadBool(LGJ5_28).Content);
			//空压机7                        
			ScrewMachineData6.add(siemensPLC.ReadBool(LGJ6_26).Content);
			ScrewMachineData6.add(siemensPLC.ReadBool(LGJ6_27).Content);
			ScrewMachineData6.add(siemensPLC.ReadBool(LGJ6_28).Content);
			//烧结变频1
			ScrewMachineData7.add(siemensPLC.ReadFloat(LGJ7_5).Content);
			ScrewMachineData7.add(siemensPLC.ReadFloat(LGJ7_6).Content);
			ScrewMachineData7.add(siemensPLC.ReadFloat(LGJ7_25).Content);
			ScrewMachineData7.add(siemensPLC.ReadBool(LGJ7_26).Content);
			ScrewMachineData7.add(siemensPLC.ReadBool(LGJ7_27).Content);
			//烧结变频1
			ScrewMachineData8.add(siemensPLC.ReadFloat(LGJ8_5).Content);
			ScrewMachineData8.add(siemensPLC.ReadFloat(LGJ8_6).Content);
			ScrewMachineData8.add(siemensPLC.ReadFloat(LGJ8_25).Content);
			ScrewMachineData8.add(siemensPLC.ReadBool(LGJ8_26).Content);
			ScrewMachineData8.add(siemensPLC.ReadBool(LGJ8_27).Content);

			siemensPLC.ConnectClose();
			
			DataMap.put("ScrewMachineData", ScrewMachineData);
			DataMap.put("ScrewMachineData1", ScrewMachineData1);
			DataMap.put("ScrewMachineData2", ScrewMachineData2);
			DataMap.put("ScrewMachineData3", ScrewMachineData3);
			DataMap.put("ScrewMachineData4", ScrewMachineData4);
			DataMap.put("ScrewMachineData5", ScrewMachineData5);
			DataMap.put("ScrewMachineData6", ScrewMachineData6);
			DataMap.put("ScrewMachineData7", ScrewMachineData7);
			DataMap.put("ScrewMachineData8", ScrewMachineData8);
			//传递MAP 9个空压机数据ArrayList 集合
			screwMachineServiceImp.setScrewMachineData(DataMap);
		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message);
		}
		
		// 数据读取完毕 获取当前时间
		System.out.println(" ");
		System.out.println("螺杆机数据获取" +siemensPLC.hashCode()+  new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}
}
