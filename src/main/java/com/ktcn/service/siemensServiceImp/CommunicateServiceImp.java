package com.ktcn.service.siemensServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public void setCommunicateData(List<Boolean> communicationData) {
		// TODO Auto-generated method stub
		communicateState.setTX0(communicationData.get(0));
		communicateState.setTX1(communicationData.get(0));
		communicateState.setTX2(communicationData.get(0));
		communicateState.setTX3(communicationData.get(0));
		communicateState.setTX4(communicationData.get(0));
		communicateState.setTX5(communicationData.get(0));
		communicateState.setTX6(communicationData.get(0));
		communicateState.setTX7(communicationData.get(0));
		communicateState.setTX8(communicationData.get(0));
		communicateState.setTX9(communicationData.get(0));
		communicateState.setTX10(communicationData.get(0));
		communicateState.setTX11(communicationData.get(0));
		communicateDao.setCommunicateStateData(communicateState);
	}

}
