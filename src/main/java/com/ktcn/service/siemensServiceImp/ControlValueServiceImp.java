package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.ControlValveDao;
import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.service.siemensService.ControlValueService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:24:11
* 类说明 调节阀PLC 数据获取
*/
@Service
public class ControlValueServiceImp implements ControlValueService{

	@Autowired
	ControlValveDao controlValveDao;
    @Autowired
	ControlValue ControlValuedata;
	
	@Override
	public void setControlValueData(ControlValue controlValve) {
		ControlValuedata=controlValve;
		//持久化到调节阀数据表
		controlValveDao.setControlValueData(controlValve);
		
	}
	
//	@Scheduled(cron = "0/1 * * * * ?")
	@Scheduled(cron = "0 0 * * * ?")
	public void setControlValueDataHour() {
		//持久化到调节阀数据表
		try {
			controlValveDao.setControlValueDataHour(ControlValuedata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//定时删除周报表数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteControlValueData() {
		controlValveDao.deleteControlValueData();
	}
}
