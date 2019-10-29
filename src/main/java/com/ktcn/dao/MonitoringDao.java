package com.ktcn.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;
import com.ktcn.entity.Switch_output;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 监控页面持久层
 */
@Mapper
@Repository
public interface MonitoringDao {
    //监控界面主页面数据   实时数据
	@Select("SELECT * FROM kyj_data_table_temp WHERE id IN (#{i})")
	Kyj_data_table OPCRealTimeData(int i);
	
	//监控界面主页面数据   冷干机状态
	@Select("SELECT switch_input_data FROM switch_input  WHERE input_id IN (10,11,12,19,20,21,28,29,30)")
	List<Boolean> OPCSwtichInputLGJ();
	
	
    //获取对应空压机数据
	@Select("SELECT * FROM kyj_data_table_temp WHERE id IN (#{i})")
	Kyj_data_table KYJGetData(int i);
    
	
	
	
	
	@Select("SELECT switch_input_data FROM switch_input")
	List<Integer> GetKYJSwtichInput();

	@Select("SELECT switch_ouput_data FROM switch_output")
	List<Integer> GetKYJSwtichOutput();
			
    
	
    
	
}
