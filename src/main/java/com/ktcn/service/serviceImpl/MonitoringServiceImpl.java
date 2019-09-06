package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MonitoringDao;
import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;
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

	@Override
	public Real_time_data KYJ1GetData() {
		// TODO Auto-generated method stub
		return monitoringDao.KYJ1GetData();
	}

	@Override
	public Real_time_data KYJ2GetData() {
		// TODO Auto-generated method stub
		return monitoringDao.KYJ2GetData();
	}

	@Override
	public Real_time_data KYJ3GetData() {
		// TODO Auto-generated method stub
		return monitoringDao.KYJ3GetData();
	}
}
