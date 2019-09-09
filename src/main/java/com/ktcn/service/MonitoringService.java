package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;
import com.ktcn.entity.Switch_output;

/*
 * 监控页面业务层
 */
public interface MonitoringService {
	
	//实时数据
	Real_time_data OPCRealTimeData();
	
    //实时数据
	List<Boolean> OPCSwtichInputLGJ();
	
	//空压机1数据
	Real_time_data KYJ1GetData();
	
	//空压机2数据
	Real_time_data KYJ2GetData();
	
	//空压机3数据 
	Real_time_data KYJ3GetData();
	
	//空压机1操作按钮
	List<Switch_input> GetKYJSwtichInput();

	List<Switch_output> GetKYJSwtichOutput();
	
	//空压机2操作按钮
	List<Switch_input> GetKYJSwtichInput2();

	List<Switch_output> GetKYJSwtichOutput2();
	
    //空压机3操作按钮
	List<Switch_input> GetKYJSwtichInput3();

	List<Switch_output> GetKYJSwtichOutput3();


}
