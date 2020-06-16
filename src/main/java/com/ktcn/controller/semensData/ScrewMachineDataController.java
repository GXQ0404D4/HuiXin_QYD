package com.ktcn.controller.semensData;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.siemensService.ScrewMachine_service;
import com.ktcn.simens.PLCdata.ScrewMachineDatagain;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月15日 下午3:22:59
* 类说明
*/
@RestController
public class ScrewMachineDataController {
	@Autowired
	ScrewMachineDatagain ScrewMachineDatagain;
	@Autowired
	ScrewMachine_service ScrewMachine_serviceimp;
	
	Map<String, ScrewMachine> SMData;
	
	@Scheduled(cron = "0/1 * * * * ?")
	public void setScrewMachineDataBB() {
		System.out.println("我去拿空压机数据，准备存入数据库");
		Map<String, ScrewMachine> screwMachineData = ScrewMachineDatagain.getScrewMachineData();
		SMData=screwMachineData;
		// 空压机数据 存入常量SCmapdata集合里
		ScrewMachine_serviceimp.setScrewMachineData(screwMachineData);
		
	}
	//每小时执行一次
	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setRealData(){
		System.out.println("我去拿空压机实时数据，准备返回前端页面");
		Map<String, ScrewMachine> screwMachineData = ScrewMachineDatagain.getScrewMachineData();
		ScrewMachine_serviceimp.setScrewMachineDataHour(screwMachineData);
	}
	//页面刷新获取实时数据
	@RequestMapping("/screwMachineRealData")
	public Map<String, ScrewMachine> getRealDataPage(){
		System.out.println("我去拿空压机实时数据，准备返回前端页面");
		return SMData;

	}
}
