package com.ktcn.service.siemensServiceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.DryingMachineDao;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.service.siemensService.DryingMachineService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月3日 上午11:42:38
* 类说明 干燥机PLC 获取数据类
*/
@Service
public class DryingMachineServiceImp implements DryingMachineService{
	@Autowired
	DryingMachineDao dryingMachineDao;

	@Autowired
	DryingMachine dryingMachine;
	
	@Override
	public void setDryingMachineData(Map<String, List> mapData) {
		// TODO Auto-generated method stub
		//制氧干燥机数据持久化到数据库
		final List  listdata0 = mapData.get("DryingMachineData0");
		final List  listdata1 = mapData.get("DryingMachineData1");
		final List  listdata2 = mapData.get("DryingMachineData2");
		final List  listdata3 = mapData.get("DryingMachineData3");
		final List  listdata4 = mapData.get("DryingMachineData4");
		final List  listdata5 = mapData.get("DryingMachineData5");
		final List  listdata6 = mapData.get("DryingMachineData6");
		final List  listdata7 = mapData.get("DryingMachineData7");
		final List  listdata8 = mapData.get("DryingMachineData8");
		
		dryingMachine.setGZJ0(listdata0.get(0));
		dryingMachine.setGZJ1(listdata0.get(1));
		dryingMachine.setGZJ2(listdata0.get(2));
		dryingMachine.setGZJ3(listdata0.get(3));
		dryingMachine.setGZJ4(listdata0.get(4));
		dryingMachine.setGZJ5(listdata0.get(5));
		dryingMachine.setGZJ12(listdata0.get(6));
		dryingMachine.setGZJ15(listdata0.get(7));
		dryingMachine.setGZJ16(listdata0.get(8));
		dryingMachine.setGZJ19(listdata0.get(9));
		dryingMachine.setGZJ20(listdata0.get(10));
		dryingMachine.setGZJ21(listdata0.get(11));
		dryingMachine.setGZJ22(listdata0.get(12));
		dryingMachine.setGZJ23(listdata0.get(13));
		dryingMachine.setGZJ24(listdata0.get(14));
		dryingMachine.setGZJ25(listdata0.get(15));
		dryingMachine.setGZJ26(listdata0.get(16));
		dryingMachine.setGZJ27(listdata0.get(17));
		dryingMachine.setGZJ28(listdata0.get(18));
		dryingMachine.setGZJ29(listdata0.get(19));
		dryingMachine.setGZJ30(listdata0.get(20));
		dryingMachine.setGZJ31(listdata0.get(21));
		dryingMachine.setGZJ32(listdata0.get(22));
		dryingMachine.setGZJ33(listdata0.get(23));
		dryingMachine.setGZJ34(listdata0.get(24));
		dryingMachine.setGZJ35(listdata0.get(25));
		dryingMachine.setGZJ36(listdata0.get(26));
		dryingMachine.setGZJ37(listdata0.get(27));
		dryingMachine.setDryingMachine_name("制氧干燥机");
		
		dryingMachineDao.setDryingMachineData(dryingMachine);
		
		//烧结干燥机数据持久化到数据库
		dryingMachine.setGZJ0(listdata1.get(0));
		dryingMachine.setGZJ1(listdata1.get(1));
		dryingMachine.setGZJ2(listdata1.get(2));
		dryingMachine.setGZJ3(listdata1.get(3));
		dryingMachine.setGZJ4(listdata1.get(4));
		dryingMachine.setGZJ5(listdata1.get(5));
		dryingMachine.setGZJ6(listdata1.get(6));
		dryingMachine.setGZJ10(listdata1.get(7));
		dryingMachine.setGZJ11(listdata1.get(8));
		dryingMachine.setGZJ12(listdata1.get(9));
		dryingMachine.setGZJ13(listdata1.get(10));
		dryingMachine.setGZJ14(listdata1.get(11));
		dryingMachine.setGZJ15(listdata1.get(12));
		dryingMachine.setGZJ16(listdata1.get(13));
		dryingMachine.setGZJ19(listdata1.get(14));
		dryingMachine.setGZJ20(listdata1.get(15));
		dryingMachine.setGZJ21(listdata1.get(16));
		dryingMachine.setGZJ22(listdata1.get(17));
		dryingMachine.setGZJ23(listdata1.get(18));
		dryingMachine.setGZJ24(listdata1.get(19));
		dryingMachine.setGZJ25(listdata1.get(20));
		dryingMachine.setGZJ26(listdata1.get(21));
		dryingMachine.setGZJ27(listdata1.get(22));
		dryingMachine.setGZJ28(listdata1.get(23));
		dryingMachine.setGZJ29(listdata1.get(24));
		dryingMachine.setGZJ30(listdata1.get(25));
		dryingMachine.setGZJ31(listdata1.get(26));
		dryingMachine.setDryingMachine_name("烧结干燥机");
		
		dryingMachineDao.setDryingMachineData1(dryingMachine);
		
		//干燥机数据持久化到数据库1
		dryingMachine.setGZJ9(listdata2.get(1));
		dryingMachine.setGZJ10(listdata2.get(1));
		dryingMachine.setGZJ18(listdata2.get(1));
		dryingMachine.setGZJ19(listdata2.get(1));
		dryingMachine.setDryingMachine_name("空压机1");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
		//干燥机数据持久化到数据库2
		dryingMachine.setGZJ9(listdata3.get(1));
		dryingMachine.setGZJ10(listdata3.get(1));
		dryingMachine.setGZJ18(listdata3.get(1));
		dryingMachine.setGZJ19(listdata3.get(1));
		dryingMachine.setDryingMachine_name("空压机2");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
		//干燥机数据持久化到数据库3
		dryingMachine.setGZJ9(listdata4.get(1));
		dryingMachine.setGZJ10(listdata4.get(1));
		dryingMachine.setGZJ18(listdata4.get(1));
		dryingMachine.setGZJ19(listdata4.get(1));
		dryingMachine.setDryingMachine_name("空压机3");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
		//干燥机数据持久化到数据库4
		dryingMachine.setGZJ9(listdata5.get(1));
		dryingMachine.setGZJ10(listdata5.get(1));
		dryingMachine.setGZJ18(listdata5.get(1));
		dryingMachine.setGZJ19(listdata5.get(1));
		dryingMachine.setDryingMachine_name("空压机4");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
		//干燥机数据持久化到数据库5
		dryingMachine.setGZJ9(listdata6.get(1));
		dryingMachine.setGZJ10(listdata6.get(1));
		dryingMachine.setGZJ18(listdata6.get(1));
		dryingMachine.setGZJ19(listdata6.get(1));
		dryingMachine.setDryingMachine_name("空压机5");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
		//干燥机数据持久化到数据库6
		dryingMachine.setGZJ9(listdata7.get(1));
		dryingMachine.setGZJ10(listdata7.get(1));
		dryingMachine.setGZJ18(listdata7.get(1));
		dryingMachine.setGZJ19(listdata7.get(1));
		dryingMachine.setDryingMachine_name("空压机6");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
		//干燥机数据持久化到数据库7
		dryingMachine.setGZJ9(listdata8.get(1));
		dryingMachine.setGZJ10(listdata8.get(1));
		dryingMachine.setGZJ18(listdata8.get(1));
		dryingMachine.setGZJ19(listdata8.get(1));
		dryingMachine.setDryingMachine_name("空压机7");
		
		dryingMachineDao.setDryingMachineData2(dryingMachine);
		
	}

}
