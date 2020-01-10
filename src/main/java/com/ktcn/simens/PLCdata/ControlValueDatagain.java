package com.ktcn.simens.PLCdata;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;

import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.service.siemensService.ControlValueService;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月27日 下午4:32:18
* 类说明
* 调节阀PLC 数据获取
*/
//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)
@PropertySource({"classpath:config/control_value.properties"})
public final class ControlValueDatagain {
	@Value("${PLC0.TJF0}")
	private static String TJF0;
	@Value("${PLC0.TJF1}")
	private static String TJF1;
	@Value("${PLC0.TJF2}")
	private static String TJF2;
	@Value("${PLC0.TJF3}")
	private static String TJF3;
	@Value("${PLC0.TJF4}")
	private static String TJF4;
	@Value("${PLC0.TJF5}")
	private static String TJF5;
	@Value("${PLC0.TJF6}")
	private static String TJF6;
	@Value("${PLC0.TJF9}")
	private static String TJF9;
	
	
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	 
	@Autowired
	ControlValueService ControlValueServiceImp;
	
	@Autowired
	ControlValue  controlValue;
	
//	@Async
	@Scheduled(cron = "0/1 * * * * ?")
	public  void getControlValueData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			controlValue.setTJF0((siemensPLC.ReadFloat(TJF0).Content));
			controlValue.setTJF1((siemensPLC.ReadBool(TJF1).Content));
			controlValue.setTJF2((siemensPLC.ReadFloat(TJF2).Content));
			controlValue.setTJF3((siemensPLC.ReadFloat(TJF3).Content));
			controlValue.setTJF4((siemensPLC.ReadFloat(TJF4).Content));
			controlValue.setTJF5((siemensPLC.ReadFloat(TJF5).Content));
			controlValue.setTJF6((siemensPLC.ReadFloat(TJF6).Content));
			controlValue.setTJF9((siemensPLC.ReadFloat(TJF9).Content));
			
			siemensPLC.ConnectClose();
		} else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
		//持久化到调节阀数据表
		ControlValueServiceImp.setControlValueData(controlValue);
//		System.out.println("第一组数据————————@@@@@@@@@@@@@@@@@@@@@__________-!"+controlValue );
		// 数据读取完毕 获取当前时间
		System.out.println(" ");
		System.out.println("持久化到调节阀" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
	}


}
