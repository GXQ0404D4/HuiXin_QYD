package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 监控页面业务层
 */
public interface MonitoringService {
	
	//实时数据
	Kyj_data_table OPCRealTimeData(int i);
	
	Kyj_data_table OPCRealTimeData2(int i);

	Kyj_data_table OPCRealTimeData3(int i);
	
    //实时数据
	List<Boolean> OPCSwtichInputLGJ();
	
	//空压机对应数据
	Kyj_data_table KYJGetData(int i);
		
	//空压机操作按钮
	List<Integer> GetKYJSwtichInput();

	List<Integer> GetKYJSwtichOutput();
	
	


}
