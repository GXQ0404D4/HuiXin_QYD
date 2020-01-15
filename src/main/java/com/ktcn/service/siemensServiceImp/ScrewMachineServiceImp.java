package com.ktcn.service.siemensServiceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.ScrewMachineDao;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.siemensService.ScrewMachineService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月3日 上午9:29:11
* 类说明 ScrewMachine 螺杆机数据获取
*/
@Service
public class ScrewMachineServiceImp implements  ScrewMachineService{

	@Autowired
	ScrewMachineDao screwMachineDao;
	
	@Autowired
	ScrewMachine screwMachine;
	
	Map<String, List> listMap;
	
	@SuppressWarnings("unchecked")
	@Override
	public void setScrewMachineData(Map<String, List> dataMap) {
		// TODO Auto-generated method stub
		listMap=dataMap;
		
		final List<Boolean> list = dataMap.get("ScrewMachineData");
		final List<Boolean> list1 = dataMap.get("ScrewMachineData1");
		final List<Boolean> list2 = dataMap.get("ScrewMachineData2");
		final List<Boolean> list3 = dataMap.get("ScrewMachineData3");
		final List<Boolean> list4= dataMap.get("ScrewMachineData4");
		final List<Boolean> list5 = dataMap.get("ScrewMachineData5");
		final List<Boolean> list6 = dataMap.get("ScrewMachineData6");
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
		screwMachine.setLGJ26( (Boolean) list7.get(3));
		screwMachine.setLGJ27( (Boolean) list7.get(4));
		screwMachine.setScrewMachine_name("烧结1变频");
		screwMachineDao.setScrewMachineData_1(screwMachine);
		//烧结变频持久化到数据库2
		screwMachine.setLGJ5((Float) list8.get(0));
		screwMachine.setLGJ6((Float) list8.get(1));
		screwMachine.setLGJ25((Float) list8.get(2));
		screwMachine.setLGJ26( (Boolean) list8.get(3));
		screwMachine.setLGJ27( (Boolean) list8.get(4));
		screwMachine.setScrewMachine_name("烧结2变频");
		screwMachineDao.setScrewMachineData_1(screwMachine);		
	}
	
//	@Scheduled(cron = "0/1 * * * * ?")
	@Scheduled(cron = "0 0 * * * ?")
	public void setScrewMachineDataHour() {
		// TODO Auto-generated method stub
		final List<Boolean> list = listMap.get("ScrewMachineData");
		final List<Boolean> list1 = listMap.get("ScrewMachineData1");
		final List<Boolean> list2 = listMap.get("ScrewMachineData2");
		final List<Boolean> list3 = listMap.get("ScrewMachineData3");
		final List<Boolean> list4= listMap.get("ScrewMachineData4");
		final List<Boolean> list5 = listMap.get("ScrewMachineData5");
		final List<Boolean> list6 = listMap.get("ScrewMachineData6");
		final List<Object> list7 = listMap.get("ScrewMachineData7");
		final List<Object> list8 = listMap.get("ScrewMachineData8");
		
		//空压机持久化到数据库1
		screwMachine.setLGJ26(list.get(0));
		screwMachine.setLGJ26(list.get(1));
		screwMachine.setLGJ26(list.get(2));
		screwMachine.setScrewMachine_name("空压机1");
		screwMachineDao.setScrewMachineDataHour(screwMachine);
		//空压机持久化到数据库2
		screwMachine.setLGJ26(list1.get(0));
		screwMachine.setLGJ26(list1.get(1));
		screwMachine.setLGJ26(list1.get(2));
		screwMachine.setScrewMachine_name("空压机2");
		screwMachineDao.setScrewMachineDataHour(screwMachine);		
		//空压机持久化到数据库3
		screwMachine.setLGJ26(list2.get(0));
		screwMachine.setLGJ26(list2.get(1));
		screwMachine.setLGJ26(list2.get(2));
		screwMachine.setScrewMachine_name("空压机3");
		screwMachineDao.setScrewMachineDataHour(screwMachine);		
		//空压机持久化到数据库4
		screwMachine.setLGJ26(list3.get(0));
		screwMachine.setLGJ26(list3.get(1));
		screwMachine.setLGJ26(list3.get(2));
		screwMachine.setScrewMachine_name("空压机4");
		screwMachineDao.setScrewMachineDataHour(screwMachine);		
		//空压机持久化到数据库5
		screwMachine.setLGJ26(list4.get(0));
		screwMachine.setLGJ26(list4.get(1));
		screwMachine.setLGJ26(list4.get(2));
		screwMachine.setScrewMachine_name("空压机5");
		screwMachineDao.setScrewMachineDataHour(screwMachine);	
		//空压机持久化到数据库6
		screwMachine.setLGJ26(list5.get(0));
		screwMachine.setLGJ26(list5.get(1));
		screwMachine.setLGJ26(list5.get(2));
		screwMachine.setScrewMachine_name("空压机6");
		screwMachineDao.setScrewMachineDataHour(screwMachine);
		//空压机持久化到数据库7
		screwMachine.setLGJ26(list6.get(0));
		screwMachine.setLGJ26(list6.get(1));
		screwMachine.setLGJ26(list6.get(2));
		screwMachine.setScrewMachine_name("空压机7");
		screwMachineDao.setScrewMachineDataHour(screwMachine);
		//烧结变频持久化到数据库1
		screwMachine.setLGJ5((Float) list7.get(0));
		screwMachine.setLGJ6((Float) list7.get(1));
		screwMachine.setLGJ25((Float) list7.get(2));
		screwMachine.setLGJ26( (Boolean) list7.get(3));
		screwMachine.setLGJ27( (Boolean) list7.get(4));
		screwMachine.setScrewMachine_name("烧结1变频");
		screwMachineDao.setScrewMachineDataHour_1(screwMachine);
		//烧结变频持久化到数据库2
		screwMachine.setLGJ5((Float) list8.get(0));
		screwMachine.setLGJ6((Float) list8.get(1));
		screwMachine.setLGJ25((Float) list8.get(2));
		screwMachine.setLGJ26( (Boolean) list8.get(3));
		screwMachine.setLGJ27( (Boolean) list8.get(4));
		screwMachine.setScrewMachine_name("烧结2变频");
		screwMachineDao.setScrewMachineDataHour_1(screwMachine);		
	}

}
