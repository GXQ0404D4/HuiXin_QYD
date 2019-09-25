package com.ktcn.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.DataMasterTable;
import com.ktcn.entity.Data_master_table;
import com.ktcn.entity.Switch_input_value;
import com.ktcn.entity.Switch_output_value;

/**
* @Title: OPCAddressInsert.java
* @Package com.ktcn.utils
* @Description: DATA_MASTER_TABLE 抓取kepserver 数据
* @author GXQ
* @version V1.0
*/
@Component
@Repository
public class OPCAddressInsert {
	/*DAO层*/
	@Autowired
    private DataMasterTable DataMasterTable;
	/*data_master_table 数据主表实体类*/
	@Autowired
	private Data_master_table data_master_table;
	//switch_output_value 对象存储类
	@Autowired
	private Switch_output_value switch_output_value;
	//switch_output_value 对象存储类
	@Autowired
	private Switch_input_value switch_input_value;
	
public void GetOPCInsert(Map<String, Float> map1, Map<String, Boolean> map2, Map<String, Long> map3){
		System.out.println(map1);
		System.out.println(map2);
		System.out.println(map3);
		
		data_master_table.setVoltageA_1(map1.get("1#A相电流"));
		data_master_table.setElectric_currentA_1(map1.get("1#A相电压"));
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
        data_master_table.setVoltageA_2(map1.get("2#A相电流"));
        data_master_table.setElectric_currentA_2(map1.get("2#A相电压"));
        data_master_table.setHost_temperature_2(map1.get("2#主机温度"));
        data_master_table.setCoolant_temperature_2(map1.get("2#冷却剂温度"));
        data_master_table.setSump_Pressure_2(map1.get("2#分离前压力"));
        data_master_table.setLoading_time_2(map1.get("2#加载时间"));
        data_master_table.setLoading_pressure_2(map1.get("2#加载压力"));
        data_master_table.setAlarm_number_2(map3.get("2#报警号"));
        data_master_table.setUnloading_pressure_2(map1.get("2#卸载压力"));
        data_master_table.setExhaust_pressure_2(map1.get("2#排气压力"));
        data_master_table.setExhaust_temperature_2(map1.get("2#排气温度"));
        data_master_table.setTotal_energy_2(map1.get("2#正向有功总电能"));
        data_master_table.setControl_state_2(map3.get("2#控制状态字"));
        data_master_table.setWarning_sign_2(map3.get("2#警告号"));
        data_master_table.setRunning_time_2(map1.get("2#运行时间"));
        data_master_table.setRemote_switch_2(map3.get("2#远程功能开关"));                
        data_master_table.setVoltageA_3(map1.get("3#A相电流"));
        data_master_table.setElectric_currentA_3(map1.get("3#A相电压"));
        data_master_table.setHost_temperature_3(map1.get("3#主机温度"));
        data_master_table.setCoolant_temperature_3( map1.get("3#冷却剂温度"));
        data_master_table.setSump_Pressure_3(map1.get("3#分离前压力"));
        data_master_table.setLoading_time_3(map1.get("3#加载时间"));
        data_master_table.setLoading_pressure_3(map1.get("3#加载压力"));
        data_master_table.setUnloading_pressure_3(map1.get("3#卸载压力"));
        data_master_table.setExhaust_pressure_3(map1.get("3#排气压力"));
        data_master_table.setTotal_energy_3(map1.get("3#正向有功总电能"));
        data_master_table.setRunning_time_3(map1.get("3#运行时间"));
        data_master_table.setRemote_switch_3(map3.get("3#远程功能开关"));
        data_master_table.setAlarm_number_3(map3.get("3#报警号"));
        data_master_table.setWarning_sign_3(map3.get("3#警告号"));
        data_master_table.setExhaust_temperature_3(map1.get("3#排气温度"));
        data_master_table.setControl_state_3(map3.get("3#控制状态字"));
        data_master_table.setActive_Service_Rate1(map1.get("AI-1#有功功率"));
        data_master_table.setActive_Service_Rate2(map1.get("AI-2#有功功率"));      
        data_master_table.setActive_Service_Rate3(map1.get("AI-3#有功功率"));
        data_master_table.setPressure(map1.get("压力"));
        data_master_table.setCumulative_flow(map1.get("累积流量"));
        data_master_table.setCompensated_flow(map1.get("补偿后流量"));
        
        System.out.println(data_master_table);
        DataMasterTable.UpdateRealTime(data_master_table);
        System.out.println(data_master_table+"###############################");
		
		data_master_table.setVoltageA_1(map1.get("1#A相电流"));
		data_master_table.setElectric_currentA_1(map1.get("1#A相电压"));
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
        data_master_table.setVoltageA_2(map1.get("2#A相电流"));
        data_master_table.setElectric_currentA_2(map1.get("2#A相电压"));
        data_master_table.setHost_temperature_2(map1.get("2#主机温度"));
        data_master_table.setCoolant_temperature_2(map1.get("2#冷却剂温度"));
        data_master_table.setSump_Pressure_2(map1.get("2#分离前压力"));
        data_master_table.setLoading_time_2(map1.get("2#加载时间"));
        data_master_table.setLoading_pressure_2(map1.get("2#加载压力"));
        data_master_table.setAlarm_number_2(map3.get("2#报警号"));
        data_master_table.setUnloading_pressure_2(map1.get("2#卸载压力"));
        data_master_table.setExhaust_pressure_2(map1.get("2#排气压力"));
        data_master_table.setExhaust_temperature_2(map1.get("2#排气温度"));
        data_master_table.setTotal_energy_2(map1.get("2#正向有功总电能"));
        data_master_table.setControl_state_2(map3.get("2#控制状态字"));
        data_master_table.setWarning_sign_2(map3.get("2#警告号"));
        data_master_table.setRunning_time_2(map1.get("2#运行时间"));
        data_master_table.setRemote_switch_2(map3.get("2#远程功能开关"));                
        data_master_table.setVoltageA_3(map1.get("3#A相电流"));
        data_master_table.setElectric_currentA_3(map1.get("3#A相电压"));
        data_master_table.setHost_temperature_3(map1.get("3#主机温度"));
        data_master_table.setCoolant_temperature_3( map1.get("3#冷却剂温度"));
        data_master_table.setSump_Pressure_3(map1.get("3#分离前压力"));
        data_master_table.setLoading_time_3(map1.get("3#加载时间"));
        data_master_table.setLoading_pressure_3(map1.get("3#加载压力"));
        data_master_table.setUnloading_pressure_3(map1.get("3#卸载压力"));
        data_master_table.setExhaust_pressure_3(map1.get("3#排气压力"));
        data_master_table.setTotal_energy_3(map1.get("3#正向有功总电能"));
        data_master_table.setRunning_time_3(map1.get("3#运行时间"));
        data_master_table.setRemote_switch_3(map3.get("3#远程功能开关"));
        data_master_table.setAlarm_number_3(map3.get("3#报警号"));
        data_master_table.setWarning_sign_3(map3.get("3#警告号"));
        data_master_table.setExhaust_temperature_3(map1.get("3#排气温度"));
        data_master_table.setControl_state_3(map3.get("3#控制状态字"));
        data_master_table.setActive_Service_Rate1(map1.get("AI-1#有功功率"));
        data_master_table.setActive_Service_Rate2(map1.get("AI-2#有功功率"));      
        data_master_table.setActive_Service_Rate3(map1.get("AI-3#有功功率"));
        data_master_table.setPressure(map1.get("压力"));
        data_master_table.setCumulative_flow(map1.get("累积流量"));
        data_master_table.setCompensated_flow(map1.get("补偿后流量"));
        
        System.out.println(data_master_table);
     	DataMasterTable.OpcDataMasterInsert(data_master_table);
     	System.out.println(data_master_table+"data_master_table");
     		
     	
     	switch_output_value.setS1(map2.get("DO-1#KYJQD"));
		switch_output_value.setS2(map2.get("DO-1#KYJTZ"));
		switch_output_value.setS3(map2.get("DO-1#LGJQD"));
		switch_output_value.setS4(map2.get("DO-1#LGJTZ"));
		switch_output_value.setS5(map2.get("DO-2#KYJQD"));
		switch_output_value.setS6(map2.get("DO-2#KYJTZ"));
		switch_output_value.setS7(map2.get("DO-2#LGJQD"));
		switch_output_value.setS8(map2.get("DO-2#LGJTZ"));
		switch_output_value.setS9(map2.get("DO-3#KYJQD"));
		switch_output_value.setS10(map2.get("DO-3#KYJTZ"));
		switch_output_value.setS11(map2.get("DO-3#LGJQD"));
		switch_output_value.setS12(map2.get("DO-3#LGJTZ"));		
		switch_output_value.setS13(map2.get("DO-1#KYJZD/SD"));		
		switch_output_value.setS14(map2.get("DO-2#KYJZD/SD"));		
		switch_output_value.setS15(map2.get("DO-3#KYJZD/SD"));		
		//Switch_output 数据
		System.out.println(switch_output_value);
		DataMasterTable.getswitchOutput(switch_output_value);
		
		//update zidu
		//switch_input 数据
		switch_input_value.setI1(map2.get("2#KYJJZ/XZ"));
		switch_input_value.setI2(map2.get("3#KYJJZ/XZ"));
		switch_input_value.setI3(map2.get("DI-1#FKDJ/LJ"));
		switch_input_value.setI4(map2.get("DI-1#KYJBD/YC"));
		switch_input_value.setI5(map2.get("DI-1#KYJBJGZ"));
		switch_input_value.setI6(map2.get("DI-1#KYJJX"));
		switch_input_value.setI7(map2.get("DI-1#KYJJZ/XZ"));
		switch_input_value.setI8(map2.get("DI-1#KYJTJGZ"));
		switch_input_value.setI9(map2.get("DI-1#KYJYX"));
		switch_input_value.setI10(map2.get("DI-1#LGJGDYBJ"));
		switch_input_value.setI11(map2.get("DI-1#LGJGZ"));
		switch_input_value.setI12(map2.get("DI-1#LGJYX"));
		switch_input_value.setI13(map2.get("DI-2#FKDJ/LJ"));
		switch_input_value.setI14(map2.get("DI-2#KYJBD/YC"));
		switch_input_value.setI15(map2.get("DI-2#KYJBJGZ"));
		switch_input_value.setI16(map2.get("DI-2#KYJJX"));
		switch_input_value.setI17(map2.get("DI-2#KYJTJGZ"));
		switch_input_value.setI18(map2.get("DI-2#KYJYX"));
		switch_input_value.setI19(map2.get("DI-2#LGJGDYBJ"));
		switch_input_value.setI20(map2.get("DI-2#LGJGZ"));
		switch_input_value.setI21(map2.get("DI-2#LGJYX"));
		switch_input_value.setI22(map2.get("DI-3#FKDJ/LJ"));
		switch_input_value.setI23(map2.get("DI-3#KYJBD/YC"));
		switch_input_value.setI24(map2.get("DI-3#KYJBJGZ"));
		switch_input_value.setI25(map2.get("DI-3#KYJJX"));
		switch_input_value.setI26(map2.get("DI-3#KYJTJGZ"));
		switch_input_value.setI27(map2.get("DI-3#KYJYX"));
		switch_input_value.setI28(map2.get("DI-3#LGJGDYBJ"));
		switch_input_value.setI29(map2.get("DI-3#LGJGZ"));
		switch_input_value.setI30(map2.get("DI-3#LGJYX"));
		switch_input_value.setI31(map2.get("DI-2#KYJJZ/XZ"));
		switch_input_value.setI32(map2.get("DI-3#KYJJZ/XZ"));
		//switch_input 数据
		System.out.println(switch_input_value);
		DataMasterTable.getswitcInput(switch_input_value);
		
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		
	
	}
	
}	