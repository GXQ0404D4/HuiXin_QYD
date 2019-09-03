package com.ktcn.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktcn.dao.DataMasterTable;
import com.ktcn.entity.Data_master_table;

/**
* @Title: OPCAddressInsert.java
* @Package com.ktcn.utils
* @Description: DATA_MASTER_TABLE 抓取kepserver 数据
* @author GXQ
* @version V1.0
*/
@Component
public class OPCAddressInsert {
	
    @Autowired
    private DataMasterTable DataMasterTable;
	
	@Autowired 
	private Data_master_table data_master_table;
	 
   // @Autowired
   //OPCSwitch_output_Service opcswitch_output_service;
    
	public void GetOPCInsert(Map<String, Float> map1, Map<String, Boolean> map2, Map<String, Long> map3){
    	
		/*Switch_output 数据*/
		//opcswitch_output_service.OPCswitch_output_update(map2);
		/*data_master_table 数据*/
		
		data_master_table.setVoltageA_1(map1.get("1#A相电压"));
		data_master_table.setElectric_currentA_1(map1.get("1#A相电流"));
		data_master_table.setHost_temperature_1(map1.get("1#主机温度"));
        data_master_table.setCoolant_temperature_1(map1.get("1#冷却剂温度"));     
        data_master_table.setSump_Pressure_1(map1.get("1#分离前压力"));
        data_master_table.setLoading_time_1(map1.get("1#加载时间"));
        data_master_table.setLoading_pressure_1(map1.get("1#加载压力"));
        data_master_table.setAlarm_number_1(map3.get("1#报警号"));
        data_master_table.setUnloading_pressure_1(map1.get("1#卸载压力"));
        data_master_table.setExhaust_pressure_1(map1.get("1#排气压力"));
        data_master_table.setExhaust_temperature_1(map1.get("1#排气温度"));
        data_master_table.setTotal_energy_1(map1.get("1#正向有功总电能"));
        data_master_table.setControl_state_1(map3.get("1#控制状态字"));
        data_master_table.setWarning_sign_1(map3.get("1#警告号"));
        data_master_table.setRunning_time_1(map1.get("1#运行时间"));
        data_master_table.setRemote_switch_1(map3.get("1#远程功能开关"));              
        
        data_master_table.setVoltageA_2(map1.get("2#A相电压"));
        data_master_table.setElectric_currentA_2(map1.get("2#A相电流"));
        data_master_table.setHost_temperature_2(map1.get("2#主机温度"));
        data_master_table.setCoolant_temperature_2(map1.get("2#冷却剂温度"));
        data_master_table.setSump_Pressure_2(map1.get("2#分离前压力"));
        data_master_table.setLoading_time_2(map1.get("2#加载时间"));
        data_master_table.setLoading_pressure_2(map1.get("2#加载压力"));
        // data_master_table.setAlarm_number_2(map3.get("2#报警号"));
        data_master_table.setUnloading_pressure_2(map1.get("2#卸载压力"));
        data_master_table.setExhaust_pressure_2(map1.get("2#排气压力"));
        data_master_table.setExhaust_temperature_2(map1.get("2#排气温度"));
        data_master_table.setTotal_energy_2(map1.get("2#正向有功总电能"));
        data_master_table.setControl_state_2(map3.get("2#控制状态字"));
        data_master_table.setWarning_sign_2(map3.get("2#警告号"));
        data_master_table.setRunning_time_2(map1.get("2#运行时间"));
        data_master_table.setRemote_switch_2(map3.get("2#远程功能开关"));                
        
        data_master_table.setVoltageA_3(map1.get("3#A相电压"));
        data_master_table.setElectric_currentA_3(map1.get("3#A相电流"));
        data_master_table.setHost_temperature_3(map1.get("3#主机温度"));
        data_master_table.setCoolant_temperature_3( map1.get("3#冷却剂温度"));
        data_master_table.setSump_Pressure_3(map1.get("3#分离前压力"));
        data_master_table.setLoading_time_3(map1.get("3#加载时间"));
        data_master_table.setLoading_pressure_3(map1.get("3#加载压力"));
        //data_master_table.setAlarm_number_3(map3.get("3#报警号"));
        data_master_table.setUnloading_pressure_3(map1.get("3#卸载压力"));
        data_master_table.setExhaust_pressure_3(map1.get("3#排气压力"));
        data_master_table.setExhaust_temperature_3(map1.get("3#排气温度"));
        data_master_table.setTotal_energy_3(map1.get("3#正向有功总电能"));
        data_master_table.setControl_state_3(map3.get("3#控制状态字"));
        //data_master_table.setWarning_sign_3(map3.get("3#警告号"));
        data_master_table.setRunning_time_3(map1.get("3#运行时间"));
        data_master_table.setRemote_switch_3(map3.get("3#远程功能开关"));
         
        data_master_table.setActive_Service_Rate1(map1.get("AI-1#有功功率"));
        data_master_table.setActive_Service_Rate2(map1.get("AI-2#有功功率"));      
        data_master_table.setActive_Service_Rate3(map1.get("AI-3#有功功率"));      
        data_master_table.setPressure(map1.get("压力"));
        data_master_table.setCumulative_flow(map1.get("累积流量"));
        
			     	
     	DataMasterTable.OpcDataMasterInsert(data_master_table);
	
	}

	
	

}
