package com.ktcn.service.siemensServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.CommunicateDao;
import com.ktcn.entity.siemensentity.CommunicateState;
import com.ktcn.service.siemensService.CommunicateService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:03:27
* 类说明  通信状态获取PLC 数据类
*/
@Service
public class CommunicateServiceImp implements CommunicateService {
	
	@Autowired
	CommunicateDao communicateDao;

	@Autowired
	CommunicateState communicateState;
	
	List<Boolean> listdata;
	@Override
	public void setCommunicateData(List<Boolean> communicationData) {
		// TODO Auto-generated method stub
		listdata=communicationData;
		//通信状态持久化到数据库
		communicateState.setTX0(communicationData.get(0));
		communicateState.setTX1(communicationData.get(1));
		communicateState.setTX2(communicationData.get(2));
		communicateState.setTX3(communicationData.get(3));
		communicateState.setTX4(communicationData.get(4));
		communicateState.setTX5(communicationData.get(5));
		communicateState.setTX6(communicationData.get(6));
		communicateState.setTX7(communicationData.get(7));
		communicateState.setTX8(communicationData.get(8));
		communicateState.setTX9(communicationData.get(9));
		communicateState.setTX10(communicationData.get(10));
		communicateState.setTX11(communicationData.get(11));
		communicateDao.setCommunicateStateData(communicateState);
	}
	
//	@Scheduled(cron = "0/1 * * * * ?")
	@Scheduled(cron = "0 0 * * * ?")
	public void setCommunicateDataHour() {

		try {
			communicateState.setTX0(listdata.get(0));
			communicateState.setTX1(listdata.get(1));
			communicateState.setTX2(listdata.get(2));
			communicateState.setTX3(listdata.get(3));
			communicateState.setTX4(listdata.get(4));
			communicateState.setTX5(listdata.get(5));
			communicateState.setTX6(listdata.get(6));
			communicateState.setTX7(listdata.get(7));
			communicateState.setTX8(listdata.get(8));
			communicateState.setTX9(listdata.get(9));
			communicateState.setTX10(listdata.get(10));
			communicateState.setTX11(listdata.get(11));
			communicateDao.setCommunicateStateDataHour(communicateState);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//删除当前7天前的数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteCommunicateData() {
		communicateDao.deleteCommunicateData();
	}
}
