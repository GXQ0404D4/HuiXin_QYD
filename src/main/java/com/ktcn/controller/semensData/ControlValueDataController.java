package com.ktcn.controller.semensData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.service.siemensService.ControlValue_service;
import com.ktcn.simens.PLCdata.ControlValueDatagain;
import com.ktcn.simens.utils.EmptyUtil;

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
	
	@Autowired
	EmptyUtil emptyUtil;

// 定时任务调用点位数据存入数据库中
//	@Async
	@Scheduled(cron = "0/15 * * * * ?")
//	方法执行完成后50毫秒再启动
//	@Scheduled(fixedDelay = 500)
	public void setControlValueDataBB() {
//		System.out.println("___"+"调节阀实时数据1");
		ControlValue controlValue = ControlValueDatagain.getControlValueData();
		if (emptyUtil.isNotEmpty(controlValue)) {
			ControlValue_serviceimp.setControlValueData(controlValue);
		}
		
	}

//	@RequestMapping("/getControlVlueRealData")
//  @Scheduled(cron = "0 0/15 * * * ?")   //每15分钟触发一次
//  每小时执行一次
	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setControlValueRealData() {
		ControlValue controlValueData = ControlValueDatagain.getControlValueData();
		ControlValue_serviceimp.setControlValueDataHour(controlValueData);
	}
	
//  定时删除周报表数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteControlValueReamlData() {
		ControlValue_serviceimp.deleteControlValueReamlData();
	}
	
	@RequestMapping("/getControlVlueRealData")
	public ControlValue getControlValueRealDataPage() {
		return ControlValueDatagain.getControlValueData();
	}

}
