package com.ktcn.service.siemensServiceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.ScrewMachine_dao;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.siemensService.ScrewMachine_service;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月10日 上午10:58:28 
 * 类说明   空压机数据持久化 serviceimp层
 */
@Component
@Service
public class ScrewMachine_serviceimp implements ScrewMachine_service {
	@Autowired
	ScrewMachine_dao ScrewMachine_dao;

	@Override
	//空压机实时数据持久化到数据库
	public void setScrewMachineData(Map<String, ScrewMachine> dataMap) {
		// TODO Auto-generated method stub
		ScrewMachine sMC1 = dataMap.get("ScrewMachine1");
		ScrewMachine sMC2 = dataMap.get("ScrewMachine2");
		ScrewMachine sMC3 = dataMap.get("ScrewMachine3");
		ScrewMachine sMC4 = dataMap.get("ScrewMachine4");
		ScrewMachine sMC5 = dataMap.get("ScrewMachine5");
		ScrewMachine_dao.setScrewMachineData(sMC1);
		ScrewMachine_dao.setScrewMachineData(sMC2);
		ScrewMachine_dao.setScrewMachineData(sMC3);
		ScrewMachine_dao.setScrewMachineData(sMC4);
		ScrewMachine_dao.setScrewMachineData(sMC5);
	}

	@Override
  //每小时执行一次
	public void setScrewMachineDataHour(Map<String, ScrewMachine> dataMap) {
		ScrewMachine sMC1 = dataMap.get("ScrewMachine1");
		ScrewMachine sMC2 = dataMap.get("ScrewMachine2");
		ScrewMachine sMC3 = dataMap.get("ScrewMachine3");
		ScrewMachine sMC4 = dataMap.get("ScrewMachine4");
		ScrewMachine sMC5 = dataMap.get("ScrewMachine5");
		ScrewMachine_dao.setScrewMachineDataHour(sMC1);
		ScrewMachine_dao.setScrewMachineDataHour(sMC2);
		ScrewMachine_dao.setScrewMachineDataHour(sMC3);
		ScrewMachine_dao.setScrewMachineDataHour(sMC4);
		ScrewMachine_dao.setScrewMachineDataHour(sMC5);

	}

	@Override
	//报警信息持久化到数据库
	public void setBJScrewMachineData(ScrewMachine dataMap) {
		// TODO Auto-generated method stub
		ScrewMachine_dao.setBJScrewMachineData(dataMap);
	}

	//删除当前一个月时间之前的实时数据
	@Override
	public void deleteScrewMachineReamlData() {
		// TODO Auto-generated method stub
		ScrewMachine_dao.deleteScrewMachineReamlData();
	}

}
