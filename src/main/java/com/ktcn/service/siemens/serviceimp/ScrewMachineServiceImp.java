package com.ktcn.service.siemens.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.ScrewMachineDao;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.ScrewMachineService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月3日 上午9:29:11
* 类说明
*/
@Service
public class ScrewMachineServiceImp implements  ScrewMachineService{

	@Autowired
	ScrewMachineDao screwMachineDao;
	
	@Autowired
	ScrewMachine screwMachine;
	
	@SuppressWarnings("unchecked")
	@Override
	public void setScrewMachineData(Map<String, List> dataMap) {
		// TODO Auto-generated method stub
		final List<Byte> list = dataMap.get("ScrewMachineData");
		final List<Byte> list1 = dataMap.get("ScrewMachineData1");
		final List<Byte> list2 = dataMap.get("ScrewMachineData2");
		final List<Byte> list3 = dataMap.get("ScrewMachineData3");
		final List<Byte> list4= dataMap.get("ScrewMachineData4");
		final List<Byte> list5 = dataMap.get("ScrewMachineData5");
		final List<Byte> list6 = dataMap.get("ScrewMachineData6");
		final List<Object> list7 = dataMap.get("ScrewMachineData7");
		final List<Object> list8 = dataMap.get("ScrewMachineData8");
		
		//空压机持久化到数据库1
		screwMachine.setLGJ26(list.get(0));
		screwMachine.setLGJ26(list.get(1));
		screwMachine.setLGJ26(list.get(2));
		screwMachine.setScrewMachine_name("空压机1");
		screwMachineDao.setScrewMachineData(screwMachine);
		//空压机持久化到数据库2
		screwMachine.setLGJ26(list1.get(0));
		screwMachine.setLGJ26(list1.get(1));
		screwMachine.setLGJ26(list1.get(2));
		screwMachine.setScrewMachine_name("空压机2");
		screwMachineDao.setScrewMachineData(screwMachine);		
		//空压机持久化到数据库3
		screwMachine.setLGJ26(list2.get(0));
		screwMachine.setLGJ26(list2.get(1));
		screwMachine.setLGJ26(list2.get(2));
		screwMachine.setScrewMachine_name("空压机3");
		screwMachineDao.setScrewMachineData(screwMachine);		
		//空压机持久化到数据库4
		screwMachine.setLGJ26(list3.get(0));
		screwMachine.setLGJ26(list3.get(1));
		screwMachine.setLGJ26(list3.get(2));
		screwMachine.setScrewMachine_name("空压机4");
		screwMachineDao.setScrewMachineData(screwMachine);		
		//空压机持久化到数据库5
		screwMachine.setLGJ26(list4.get(0));
		screwMachine.setLGJ26(list4.get(1));
		screwMachine.setLGJ26(list4.get(2));
		screwMachine.setScrewMachine_name("空压机5");
		screwMachineDao.setScrewMachineData(screwMachine);	
		//空压机持久化到数据库6
		screwMachine.setLGJ26(list5.get(0));
		screwMachine.setLGJ26(list5.get(1));
		screwMachine.setLGJ26(list5.get(2));
		screwMachine.setScrewMachine_name("空压机6");
		screwMachineDao.setScrewMachineData(screwMachine);
		//空压机持久化到数据库7
		screwMachine.setLGJ26(list6.get(0));
		screwMachine.setLGJ26(list6.get(1));
		screwMachine.setLGJ26(list6.get(2));
		screwMachine.setScrewMachine_name("空压机7");
		screwMachineDao.setScrewMachineData(screwMachine);
		//烧结变频持久化到数据库1
		screwMachine.setLGJ5((Float) list7.get(0));
		screwMachine.setLGJ6((Float) list7.get(1));
		screwMachine.setLGJ25((Float) list7.get(2));
		screwMachine.setLGJ26( (Byte) list7.get(3));
		screwMachine.setLGJ27( (Byte) list7.get(4));
		screwMachine.setScrewMachine_name("烧结1变频");
		screwMachineDao.setScrewMachineData_1(screwMachine);
		//烧结变频持久化到数据库2
		screwMachine.setLGJ5((Float) list8.get(0));
		screwMachine.setLGJ6((Float) list8.get(1));
		screwMachine.setLGJ25((Float) list8.get(2));
		screwMachine.setLGJ26( (Byte) list8.get(3));
		screwMachine.setLGJ27( (Byte) list8.get(4));
		screwMachine.setScrewMachine_name("烧结2变频");
		screwMachineDao.setScrewMachineData_1(screwMachine);		
	}

}
