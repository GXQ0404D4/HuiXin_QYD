package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MonitoringDao;
import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;
import com.ktcn.entity.Switch_output;
import com.ktcn.service.MonitoringService;
/*
 * 监控页面业务层实现类
 */
@Service
@Transactional
public class MonitoringServiceImpl implements MonitoringService {
	@Resource
	private MonitoringDao monitoringDao;

	@Override
	public Real_time_data OPCRealTimeData() {
		
		return monitoringDao.OPCRealTimeData();
		
	}

	@Override
	public List<Boolean> OPCSwtichInputLGJ() {
		// TODO Auto-generated method stub
		return monitoringDao.OPCSwtichInputLGJ();
	}
    
	//空一页面数据
	@Override
	public Real_time_data KYJ1GetData() {
		// TODO Auto-generated method stub
		return monitoringDao.KYJ1GetData();
	}
    
	//空二页面数据
	@Override
	public Real_time_data KYJ2GetData() {
		// TODO Auto-generated method stub
		return monitoringDao.KYJ2GetData();
	}
   
	//空三页面数据
	@Override
	public Real_time_data KYJ3GetData() {
		// TODO Auto-generated method stub
		return monitoringDao.KYJ3GetData();
	}
    
	//空一按钮数据
	@Override
	public List<Switch_input> GetKYJSwtichInput() {
		// TODO Auto-generated method stub		
		return monitoringDao.GetKYJSwtichInput();
	}

	@Override
	public List<Switch_output> GetKYJSwtichOutput() {
		// TODO Auto-generated method stub
		return monitoringDao.GetKYJSwtichOutput();
	}
	
    //空二按钮数据
	@Override
	public List<Switch_input> GetKYJSwtichInput2() {
		// TODO Auto-generated method stub		
		return monitoringDao.GetKYJSwtichInput2();
	}

	@Override
	public List<Switch_output> GetKYJSwtichOutput2() {
		// TODO Auto-generated method stub
		return monitoringDao.GetKYJSwtichOutput2();
	}
	
    //空三按钮数据
	@Override
	public List<Switch_input> GetKYJSwtichInput3() {
		// TODO Auto-generated method stub
		return monitoringDao.GetKYJSwtichInput3();
	}

	@Override
	public List<Switch_output> GetKYJSwtichOutput3() {
		// TODO Auto-generated method stub
		return monitoringDao.GetKYJSwtichOutput3();
	}

}
