package com.ktcn.controller.semensData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.service.siemensService.DryingMachine_service;
import com.ktcn.simens.PLCdata.DryingMachineDatagain;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月15日 下午3:07:15 类说明
 */
@RestController
public class DryingMachineDataController {

	@Autowired
	DryingMachineDatagain DryingMachineDatagain;

	@Autowired
	DryingMachine_service DryingMachine_serviceimp;

	@Autowired
	DryingMachine DryingMachine;

	@Scheduled(cron = "0/1 * * * * ?")
	public void setDryingMachineDataBB() {
		DryingMachine DryingMachine = DryingMachineDatagain.getDryingMachineData();
		//报警信息判断存储
		if ((boolean) DryingMachine.getGZJ11()==true) {
			DryingMachine.setDryingMachine_name("干燥机");
			DryingMachine_serviceimp.setBJDryingMachineData(DryingMachine);
		}
		DryingMachine_serviceimp.setDryingMachineData(DryingMachine);
	}

//	@RequestMapping("/getDryingMachineRealData")
	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setDryingMachineRealData() {
		DryingMachine DryingMachine = DryingMachineDatagain.getDryingMachineData();
		DryingMachine_serviceimp.setDryingMachineDataHour(DryingMachine);
	}
	
	//页面刷新获取实时数据
	@RequestMapping("/getDryingMachineRealData")
	public DryingMachine getDryingMachineRealDataPage() {
		return DryingMachine;

	}
}
