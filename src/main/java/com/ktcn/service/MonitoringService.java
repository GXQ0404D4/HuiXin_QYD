package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;

/*
 * 监控页面业务层
 */
public interface MonitoringService {
	
	Real_time_data OPCRealTimeData();

	List<Boolean> OPCSwtichInputLGJ();

	Real_time_data KYJ1GetData();

	Real_time_data KYJ2GetData();

	Real_time_data KYJ3GetData();

}
