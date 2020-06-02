//package com.ktcn.controller.alarmController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.annotation.Order;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ktcn.service.AlarmService.AlarmService;
//import com.ktcn.simens.utils.SiemensPlcConfig1;
//
//import HslCommunication.Profinet.Siemens.SiemensPLCS;
//import HslCommunication.Profinet.Siemens.SiemensS7Net;
//
///**
//* @author 作者 :Runaway programmer
//* @version 创建时间：2020年2月20日 下午2:25:13
//* 类说明 报警设置模块
//*/
//@EnableScheduling // 此注解必加,必须要加，重中之重
//
//@Component // 此注解必加
//
//@Order(value = 1)
//
//@RestController
//@PropertySource({"classpath:config/Alarm/alarm_set.properties"})
//public class AlarmController {
//// 报警设置 获取报警点位
//	@Value("${alarm.pt0}")
//	private String pt0;
//	@Value("${alarm.pt1}")
//	private String pt1;
//	@Value("${alarm.pt2}")
//	private String pt2;
//	@Value("${alarm.pt3}")
//	private String pt3;
//	@Value("${alarm.pt4}")
//	private String pt4;
//	@Value("${alarm.pt05}")
//	private String pt5;
//	@Value("${alarm.pt6}")
//	private String pt6;
//	
//	// PLC 连接池 封装类配置类
//	@Autowired
//	SiemensPlcConfig1 SiemensPlcConfig;
//	
//	@Autowired
//	AlarmService alarmService;
//	
//	@Scheduled(cron = "0/10 * * * * ?")
//	public void AlarmData() {
//		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
//		Map <String,List> DataMap=new HashMap<String,List>();
//		List<Float> DataList1 = new ArrayList<Float>();
//		if (siemensPLC.ConnectServer().IsSuccess) {
//			if (siemensPLC.ReadBool(pt0).Content==false) {
//				alarmService.AlarmMonitoring("空压机0",pt0,siemensPLC.ReadBool(pt0).Content);
//			}if (siemensPLC.ReadBool(pt1).Content==true) {
//				alarmService.AlarmMonitoring("空压机1",pt1,siemensPLC.ReadBool(pt1).Content);
//			}if (siemensPLC.ReadBool(pt2).Content==true) {
//				alarmService.AlarmMonitoring("空压机2",pt2,siemensPLC.ReadBool(pt2).Content);
//			}if (siemensPLC.ReadBool(pt3).Content==true) {
//				alarmService.AlarmMonitoring("空压机3",pt3,siemensPLC.ReadBool(pt3).Content);
//			}if (siemensPLC.ReadBool(pt4).Content==true) {
//				alarmService.AlarmMonitoring("空压机4",pt4,siemensPLC.ReadBool(pt4).Content);
//			}if (siemensPLC.ReadBool(pt5).Content==true) {
//				alarmService.AlarmMonitoring("空压机5",pt5,siemensPLC.ReadBool(pt5).Content);
//			}if (siemensPLC.ReadBool(pt6).Content==true) {
//				alarmService.AlarmMonitoring("空压机6",pt6,siemensPLC.ReadBool(pt6).Content);
//			}
//					} else {
//			System.out.println("failed:" +siemensPLC.ConnectServer().Message+"电表数据异常");
//		}
//		siemensPLC.ConnectClose();
//	}
//}
