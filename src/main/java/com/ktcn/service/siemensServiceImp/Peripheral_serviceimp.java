package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.Peripheral_dao;
import com.ktcn.entity.Peripheral_Alarm;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.service.siemensService.Peripheral_service;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:57:29
* 类说明   外围数据serviceimp层
*/


@Service
public class Peripheral_serviceimp implements Peripheral_service  {
	@Autowired
	Peripheral_dao Peripheral_dao;
	
	@Override
	public void setPeripheral_data(Peripheral_entity p_da) {
		// TODO Auto-generated method stub
		Peripheral_dao.setPeripheral_data(p_da);
	}

	@Override
	//每小时执行一次
	public void setPeripheral_data_hour(Peripheral_entity p_da) {
			Peripheral_dao.setPeripheral_data_hour(p_da);
		
	}

	@Override
	//外围数据报警信息持久化到数据库
	public void setBJPeripheral_data(Peripheral_Alarm pp_Alarm) {
		// TODO Auto-generated method stub
		Peripheral_dao.setBJPeripheral_data(pp_Alarm);
	}
	

}
