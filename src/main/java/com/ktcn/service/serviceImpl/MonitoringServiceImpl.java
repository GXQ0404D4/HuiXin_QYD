package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MonitoringDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.MonitoringService;
/*
 * 监控页面业务层实现类
 */
@Service
@Transactional
public class MonitoringServiceImpl implements MonitoringService {
	@Resource
	private MonitoringDao monitoringDao;
    
	//获取监控主页面实时数据
	@Override
	public Kyj_data_table OPCRealTimeData(int i) {
		
		return monitoringDao.OPCRealTimeData(i);
		
	}
	@Override
	public Kyj_data_table OPCRealTimeData2(int i) {
		// TODO Auto-generated method stub
		return monitoringDao.OPCRealTimeData(i);
	}

	@Override
	public Kyj_data_table OPCRealTimeData3(int i) {
		// TODO Auto-generated method stub
		return monitoringDao.OPCRealTimeData(i);
	}


	@Override
	public List<Boolean> OPCSwtichInputLGJ() {
		// TODO Auto-generated method stub
		return monitoringDao.OPCSwtichInputLGJ();
	}
    
	//空压机对应页面数据
	@Override
	public Kyj_data_table KYJGetData(int i) {
		// TODO Auto-generated method stub
		return monitoringDao.KYJGetData(i);
	}
    
	
    
	//空一按钮数据
	@Override
	public List<Integer> GetKYJSwtichInput() {
		// TODO Auto-generated method stub		
		return monitoringDao.GetKYJSwtichInput();
	}

	@Override
	public List<Integer> GetKYJSwtichOutput() {
		// TODO Auto-generated method stub
		return monitoringDao.GetKYJSwtichOutput();
	}
	
   

	
}
