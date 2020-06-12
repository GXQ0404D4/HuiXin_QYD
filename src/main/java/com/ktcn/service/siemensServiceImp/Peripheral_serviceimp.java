package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.Peripheral_dao;
import com.ktcn.entity.siemensentity.Peripheral_Data;
import com.ktcn.service.siemensService.Peripheral_service;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:57:29
* 类说明
*/


@Component
@Service
public class Peripheral_serviceimp implements Peripheral_service  {
	@Autowired
	Peripheral_dao Peripheral_dao;
	
    @Autowired 
    Peripheral_Data P_Data_hour;
	
	@Override
	public void setPeripheral_data(Peripheral_Data p_da) {
		// TODO Auto-generated method stub
		Peripheral_dao.setPeripheral_data(p_da);
		P_Data_hour=p_da;
	}

	@Override
	//每小时执行一次
//	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setPeripheral_data_hour() {
		// TODO Auto-generated method stub
		if (P_Data_hour.equals("")||P_Data_hour==null) {
			try {
				setPeripheral_data_hour();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Peripheral_dao.setPeripheral_data_hour(P_Data_hour);
		}
		
	}
	

}
