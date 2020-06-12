package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.DryingMachine_dao;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.service.siemensService.DryingMachine_service;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:56:24
* 类说明
*/
@Component
@Service
public class DryingMachine_serviceimp implements DryingMachine_service{

	@Autowired
	DryingMachine_dao DryingMachine_dao;
	@Autowired
	DryingMachine dMHour;
	@Override
	public void setDryingMachineData(DryingMachine dMac) {
		// TODO Auto-generated method stub
		DryingMachine_dao.setDryingMachineData(dMac);
		dMHour=dMac;
	}

	@Override
	//每小时执行一次
//	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setDryingMachineDataHour() {
		// TODO Auto-generated method stub
		if (dMHour==null || dMHour.equals("")) {
			try {
				setDryingMachineDataHour();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			DryingMachine_dao.setDryingMachineDataHour(dMHour);
		}
		
	}
}
