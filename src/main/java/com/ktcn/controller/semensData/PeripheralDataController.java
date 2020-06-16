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
		
		
		@Scheduled(cron = "0/1 * * * * ?")
		public  void setPeripheral_dataBB() {
			System.out.println("外围实时数据和其他实时数据，存储到数据库");
			Map<String, Object> map = Peripheral_data.getPeripheral_data();
			Peripheral_entity Peripheral_entity =(Peripheral_entity) map.get("PeripheralData");
			Peripheral_qt Peripheral_qt =(Peripheral_qt) map.get("Peripheral_qt");
			Peripheral_serviceimp.setPeripheral_data(Peripheral_entity);
			Newly_serviceimp.setNewlyData(Peripheral_qt);
			
		}
//		每小时存储一次
		@Scheduled(cron = "0 0 * * * ?")
//		@Scheduled(cron = "0/1 * * * * ?")
		public  void setPeripheralData() {
//			System.out.println("外围实时数据和其他实时数据，存储到数据库");
			Map<String, Object> map = Peripheral_data.getPeripheral_data();
			Peripheral_entity Peripheral_entity =(Peripheral_entity) map.get("PeripheralData");
			Peripheral_serviceimp.setPeripheral_data_hour(Peripheral_entity);
			
		}
		
		//页面刷新获取实时数据
		@RequestMapping("/getPeripheralRealData")
		public Peripheral_entity getPeripheralRealData() {
			System.out.println("外围实时数据，传递到前端页面");
			return Peripheral_entity;
		}
		@RequestMapping("/getNewLyRealData")
		public Peripheral_qt getNewLyRealData() {
			System.out.println("外围其他实时数据，传递到前端页面");
			return Peripheral_qt;
		}
}
