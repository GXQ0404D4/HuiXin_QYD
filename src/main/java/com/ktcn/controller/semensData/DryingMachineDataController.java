package com.ktcn.controller.semensData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.service.siemensService.DryingMachine_service;
import com.ktcn.simens.PLCdata.DryingMachineDatagain;
import com.ktcn.simens.utils.EmptyUtil;

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
	
	@Autowired
	EmptyUtil emptyUtil;

//	@Async
	@Scheduled(cron = "0/15 * * * * ?")
//	方法执行完成后50毫秒再启动
//	@Scheduled(fixedDelay = 500)
	public void setDryingMachineDataBB() {
//		System.out.println("___"+"干燥机实时数据2");
		DryingMachine DryingMachine = DryingMachineDatagain.getDryingMachineData();
		if (emptyUtil.isNotEmpty(DryingMachine)) {
			DryingMachine_serviceimp.setDryingMachineData(DryingMachine);
			//报警信息判断存储
			if ( (Boolean)DryingMachine.getGZJ11()==true && emptyUtil.isNotEmpty((Boolean)DryingMachine.getGZJ11())) {
				DryingMachine.setDryingMachine_name("干燥机");
				DryingMachine_serviceimp.setBJDryingMachineData(DryingMachine);
			}
		}
		
	}

	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setDryingMachineRealData() {
//		DryingMachine DryingMachine = DryingMachineDatagain.getDryingMachineData();
		DryingMachine_serviceimp.setDryingMachineDataHour(DryingMachineDatagain.getDryingMachineData());
	}
//  定时删除周报表数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteReamlData() {
		DryingMachine_serviceimp.deleteReamlData();
	}
	
	//页面刷新获取实时数据
	@RequestMapping("/getDryingMachineRealData")
	public DryingMachine getDryingMachineRealDataPage() {
		return DryingMachineDatagain.getDryingMachineData();

	}
}
