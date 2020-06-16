package com.ktcn.controller.semensData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.service.siemensService.ControlValue_service;
import com.ktcn.simens.PLCdata.ControlValueDatagain;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月15日 下午3:17:21 类说明
 */
@RestController
public class ControlValueDataController {
	@Autowired
	ControlValueDatagain ControlValueDatagain;

	@Autowired
	ControlValue_service ControlValue_serviceimp;
	
	@Autowired
	ControlValue controlValue;

	// 定时任务调用点位数据存入数据库中
	@Scheduled(cron = "0/1 * * * * ?")
	public void setControlValueDataBB() {
		System.out.println("我去拿调节阀实时数据，准备存入数据库");
		ControlValue controlValue = ControlValueDatagain.getControlValueData();
		ControlValue_serviceimp.setControlValueData(controlValue);
	}

//	@RequestMapping("/getControlVlueRealData")
//  @Scheduled(cron = "0 0/15 * * * ?")   //每15分钟触发一次
//  每小时执行一次
	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setControlValueRealData() {
		System.out.println("我去拿调节阀实时数据，准备返回前端页面");
		ControlValue controlValueData = ControlValueDatagain.getControlValueData();
		ControlValue_serviceimp.setControlValueDataHour(controlValueData);
	}
	
	@RequestMapping("/getControlVlueRealData")
	public ControlValue getControlValueRealDataPage() {
		System.out.println("我去拿调节阀实时数据，准备返回前端页面");
		return controlValue;
	}

}
