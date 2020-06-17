package com.ktcn.controller.semensData;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月15日 下午3:34:59
* 类说明
*/

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Peripheral_Alarm;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.Peripheral_qt;
import com.ktcn.service.siemensService.Peripheral_service;
import com.ktcn.service.siemensServiceImp.Newly_serviceimp;
import com.ktcn.simens.PLCdata.Peripheral_data;

@RestController
public class PeripheralDataController {
	    //PLC数据获取类
        @Autowired
        Peripheral_data Peripheral_data;
	    //实体类
		@Autowired
		Peripheral_entity Peripheral_entity;
		//实体类
		@Autowired
		Peripheral_qt Peripheral_qt;
		//service
		@Autowired
		Newly_serviceimp Newly_serviceimp;
		//service
		@Autowired
		Peripheral_service Peripheral_serviceimp;
		
		@Autowired
		Peripheral_Alarm Pp_Alarm;
		
		
		@Scheduled(cron = "0/1 * * * * ?")
		public  void setPeripheral_dataBB() {
			Map<String, Object> map = Peripheral_data.getPeripheral_data();
			Peripheral_entity Peripheral_entity =(Peripheral_entity) map.get("PeripheralData");
			Peripheral_qt Peripheral_qt =(Peripheral_qt) map.get("Peripheral_qt");
			Peripheral_serviceimp.setPeripheral_data(Peripheral_entity);
			Newly_serviceimp.setNewlyData(Peripheral_qt);
			
			
			Boolean ww5 =(Boolean) Peripheral_entity.getWw5();
			Boolean ww6 =(Boolean) Peripheral_entity.getWw6();
			Boolean ww12 =(Boolean) Peripheral_entity.getWw12();
			Boolean ww13 =(Boolean) Peripheral_entity.getWw13();
			Boolean ww19 =(Boolean) Peripheral_entity.getWw19();
			Boolean ww20 =(Boolean) Peripheral_entity.getWw20();
			Boolean ww35 =(Boolean) Peripheral_entity.getWw35();
			Boolean ww36 =(Boolean) Peripheral_entity.getWw36();
			Boolean ww42 =(Boolean) Peripheral_entity.getWw42();
			Boolean ww43 =(Boolean) Peripheral_entity.getWw43();
			Boolean ww49 =(Boolean) Peripheral_entity.getWw49();
			Boolean ww50 =(Boolean) Peripheral_entity.getWw50();
			Boolean ww56 =(Boolean) Peripheral_entity.getWw56();
			Boolean ww57 =(Boolean) Peripheral_entity.getWw57();
			Boolean ww63 =(Boolean) Peripheral_entity.getWw63();
			Boolean ww64 =(Boolean) Peripheral_entity.getWw64();
			Boolean ww70 =(Boolean) Peripheral_entity.getWw70();
			Boolean ww71 =(Boolean) Peripheral_entity.getWw71();
			Boolean ww77 =(Boolean) Peripheral_entity.getWw77();
			Boolean ww78 =(Boolean) Peripheral_entity.getWw78();
			Boolean ww84 =(Boolean) Peripheral_entity.getWw84();
			Boolean ww85 =(Boolean) Peripheral_entity.getWw85();
			
			if (ww5==true||ww6==true) {
				Pp_Alarm.setPdjname("冷却水供水流量");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw0());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw1());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw2());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw3());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw4());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw5());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw6());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww12==true||ww13==true) {
				Pp_Alarm.setPdjname("冷却水供水压力");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw7());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw8());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw9());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw10());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw11());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw12());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw13());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww19==true||ww20==true) {
				Pp_Alarm.setPdjname("冷却水供水温度");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw14());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw15());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw16());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw17());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw18());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw19());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw20());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww35==true||ww36==true) {
				Pp_Alarm.setPdjname("外供净化压缩空气主管压力");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw30());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw31());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw32());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw33());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw34());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw35());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw36());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww42==true||ww43==true) {
				Pp_Alarm.setPdjname("外供普通压缩空气主管压力");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw37());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw38());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw39());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw40());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw41());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw42());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw43());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww49==true||ww50==true) {
				Pp_Alarm.setPdjname("外供二冷压缩空气主管压力");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw44());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw45());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw46());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw47());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw48());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw49());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw50());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww56==true||ww57==true) {
				Pp_Alarm.setPdjname("综合水处理器进出口压差");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw51());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw52());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw53());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw54());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw55());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw56());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw57());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww63==true||ww64==true) {
				Pp_Alarm.setPdjname("干燥机进气压力");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw58());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw59());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw60());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw61());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw62());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw63());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw64());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww70==true||ww71==true) {
				Pp_Alarm.setPdjname("干燥机排气压力");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw65());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw66());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw67());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw68());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw69());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw70());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw71());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww77==true||ww78==true) {
				Pp_Alarm.setPdjname("干燥机进气温度");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw72());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw73());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw74());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw75());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw76());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw77());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw78());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			if (ww84==true||ww85==true) {
				Pp_Alarm.setPdjname("干燥机排气温度");
				Pp_Alarm.setPbj0(Peripheral_entity.getWw79());
				Pp_Alarm.setPbj1(Peripheral_entity.getWw80());
				Pp_Alarm.setPbj2(Peripheral_entity.getWw81());
				Pp_Alarm.setPbj3(Peripheral_entity.getWw82());
				Pp_Alarm.setPbj4(Peripheral_entity.getWw83());
				Pp_Alarm.setPbj5(Peripheral_entity.getWw84());
				Pp_Alarm.setPbj6(Peripheral_entity.getWw85());
				Peripheral_serviceimp.setBJPeripheral_data(Pp_Alarm);
			}
			
			
			
		}
//		每小时存储一次
		@Scheduled(cron = "0 0 * * * ?")
//		@Scheduled(cron = "0/1 * * * * ?")
		public  void setPeripheralData() {
			Map<String, Object> map = Peripheral_data.getPeripheral_data();
			Peripheral_entity Peripheral_entity =(Peripheral_entity) map.get("PeripheralData");
			Peripheral_serviceimp.setPeripheral_data_hour(Peripheral_entity);
			
		}
		
		//页面刷新获取实时数据
		@RequestMapping("/getPeripheralRealData")
		public Peripheral_entity getPeripheralRealData() {
			return Peripheral_entity;
		}
		
		//页面刷新获取其他实时数据
		@RequestMapping("/getNewLyRealData")
		public Peripheral_qt getNewLyRealData() {
			return Peripheral_qt;
		}
}
