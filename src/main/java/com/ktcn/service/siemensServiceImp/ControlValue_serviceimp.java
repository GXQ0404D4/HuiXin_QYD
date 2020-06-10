package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.dao.siemensdao.ControlValue_dao;
import com.ktcn.service.siemensService.ControlValue_service;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:55:43
* 类说明
*/
@Component
@Service
public class ControlValue_serviceimp implements ControlValue_service{
	
	@Autowired
	ControlValue_dao ControlValue_dao;
	@Autowired
	ControlValue ControlValuehour;

	@Override
	public void setControlValueData(ControlValue CValue) {
		// TODO Auto-generated method stub
		ControlValue_dao.setControlValueData(CValue);
		ControlValuehour=CValue;
	}
	
	

//@Scheduled(cron = "0 0/15 * * * ?")   //每15分钟触发一次
//每小时执行一次
//	@Scheduled(cron = "0 0 * * * ?")
	@Scheduled(cron = "0/1 * * * * ?")
	public void setControlValueDataHour() {
		// TODO Auto-generated method stub
		if (ControlValuehour==null && ControlValuehour.equals("")) {
			try {
				setControlValueDataHour();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			ControlValue_dao.setControlValueDataHour(ControlValuehour);
		}
		
	}

}
