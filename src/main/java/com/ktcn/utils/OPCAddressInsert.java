package com.ktcn.utils;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.dao.DataMasterTable;
import com.ktcn.entity.Data_master_table;
@Component
public class OPCAddressInsert {
	
    @Autowired
    DataMasterTable DataMasterTable;
    @Autowired
    Data_master_table data_master_table;
    
    @RequestMapping("/opcinsert")
	public void GetOPCInsert(Map<String, Float> map1, Map<String, Boolean> map2){
    	
		System.out.println("######################################################################################################################+++++ 进入到MAP 集合传递层"+map1.get("1#排气温度"));
		System.out.println(map1.toString());		
			          
		System.out.println("data master table "+map1.get("1#排气温度"));
		
		   Float float1 = map1.get("AI-1#有功功率");
	        Float float2 = map1.get("AI-2#有功功率");
	        Float float3 = map1.get("AI-3#有功功率");
	        Float float4 = map1.get("压力");
	        Float float5 = map1.get("累积流量");
	        System.out.println(float1);
	        System.out.println(float2);
	        System.out.println(float3);
	        System.out.println(float4);
	        System.out.println(float5);
		
		data_master_table.setVoltageA_1(map1.get("1#A相电压"));
        data_master_table.setElectric_currentA_1(map1.get("1#A相电流"));
        data_master_table.setHost_temperature_1(map1.get("1#主机温度"));
        data_master_table.setCoolant_temperature_1(map1.get("1#冷却剂温度"));     
        data_master_table.setSump_Pressure_1(map1.get("1#分离前压力"));
        //data_master_table.setLoading_time_1(map1.get("1#加载时间"));
        data_master_table.setLoading_pressure_1(map1.get("1#加载压力"));
        //data_master_table.setAlarm_number_1(map1.get("1#报警号"));
        data_master_table.setUnloading_pressure_1(map1.get("1#卸载压力"));
        data_master_table.setExhaust_pressure_1(map1.get("1#排气压力"));
        data_master_table.setExhaust_temperature_1(map1.get("1#排气温度"));
        data_master_table.setTotal_energy_1(map1.get("1#正向有功总电能"));
        //data_master_table.setControl_state_1(map1.get("1#控制状态字"));
        //data_master_table.setWarning_sign_1(map1.get("1#警告号"));
        //data_master_table.setRunning_time_1(map1.get("1#运行时间"));
        //data_master_table.setRemote_switch_1(map1.get("1#远程功能开关"));
       
        
        
        data_master_table.setVoltageA_2(map1.get("2#A相电压"));
        data_master_table.setElectric_currentA_2(map1.get("2#A相电流"));
        data_master_table.setHost_temperature_2(map1.get("2#主机温度"));
        data_master_table.setCoolant_temperature_2(map1.get("2#冷却剂温度"));
        data_master_table.setSump_Pressure_2(map1.get("2#分离前压力"));
        //data_master_table.setLoading_time_2(map1.get("2#加载时间"));
        data_master_table.setLoading_pressure_2(map1.get("2#加载压力"));
        //data_master_table.setAlarm_number_2(map1.get("2#报警号"));
        data_master_table.setUnloading_pressure_2(map1.get("2#卸载压力"));
        data_master_table.setExhaust_pressure_2(map1.get("2#排气压力"));
        data_master_table.setExhaust_temperature_2(map1.get("2#排气温度"));
        data_master_table.setTotal_energy_2(map1.get("2#正向有功总电能"));
        //data_master_table.setControl_state_2(map1.get("2#控制状态字"));
        //data_master_table.setWarning_sign_2(map1.get("2#警告号"));
        //data_master_table.setRunning_time_2(map1.get("2#运行时间"));
        //data_master_table.setRemote_switch_2(map1.get("2#远程功能开关"));
        
        
        
        data_master_table.setVoltageA_3(map1.get("3#A相电压"));
        data_master_table.setElectric_currentA_3(map1.get("3#A相电流"));
        data_master_table.setHost_temperature_3(map1.get("3#主机温度"));
        data_master_table.setCoolant_temperature_3( map1.get("3#冷却剂温度"));
        data_master_table.setSump_Pressure_3(map1.get("3#分离前压力"));
        //data_master_table.setLoading_time_3(map1.get("3#加载时间"));
        data_master_table.setLoading_pressure_3(map1.get("3#加载压力"));
        //data_master_table.setAlarm_number_3(map1.get("3#报警号"));
        data_master_table.setUnloading_pressure_3(map1.get("3#卸载压力"));
        data_master_table.setExhaust_pressure_3(map1.get("3#排气压力"));
        data_master_table.setExhaust_temperature_3(map1.get("3#排气温度"));
        data_master_table.setTotal_energy_3(map1.get("3#正向有功总电能"));
        //data_master_table.setControl_state_3(map1.get("3#控制状态字"));
        //data_master_table.setWarning_sign_3(map1.get("3#警告号"));
        //data_master_table.setRunning_time_3(map1.get("3#运行时间"));
        //data_master_table.setRemote_switch_3(map1.get("3#远程功能开关"));
                   
        data_master_table.setActive_Service_Rate1(map1.get("AI-1#有功功率"));
        data_master_table.setActive_Service_Rate2(map1.get("AI-2#有功功率"));      
        data_master_table.setActive_Service_Rate3(map1.get("AI-3#有功功率"));      
        data_master_table.setPressure(map1.get("压力"));
        data_master_table.setCumulative_flow(map1.get("累积流量"));
					
      	
     		DataMasterTable.OpcDataMasterInsert(data_master_table);
	
	}
	
	

}
