package com.ktcn.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;

/*
 * 监控页面持久层
 */
@Mapper
@Repository
public interface MonitoringDao {

	@Select("SELECT Active_Service_Rate1,Active_Service_Rate2,Active_Service_Rate3,total_energy_1,total_energy_2,total_energy_3,"
			+ "pressure,Cumulative_flow,Compensated_flow,Host_temperature_1,Coolant_temperature_1,Loading_pressure_1,Unloading_pressure_1,"
			+ "Control_state_1,Host_temperature_2,Coolant_temperature_2,Loading_pressure_2,Unloading_pressure_2,Control_state_2,"
			+ "Host_temperature_3,Coolant_temperature_3,Loading_pressure_3,Unloading_pressure_3,Control_state_3,Exhaust_pressure_1,"
			+ "Exhaust_temperature_1,Exhaust_pressure_2,Exhaust_temperature_2,Exhaust_pressure_3,Exhaust_temperature_3 "
			+ "from real_time_data WHERE dmt_id=1")
	Real_time_data OPCRealTimeData();
    
	@Select("SELECT switch_input_data FROM switch_input  WHERE input_id IN (10,11,12,19,20,21,28,29,30)")
	List<Boolean> OPCSwtichInputLGJ();
    
	@Select("SELECT VoltageA_1,Electric_currentA_1,Host_temperature_1,Coolant_temperature_1,Sump_Pressure_1,Loading_pressure_1,"
			+ "Loading_time_1,Unloading_pressure_1,Alarm_number_1,Exhaust_pressure_1,Exhaust_temperature_1,Control_state_1,total_energy_1,"
			+ "Warning_sign_1,Running_time_1,Remote_switch_1,Active_Service_Rate1 FROM real_time_data")
	Real_time_data KYJ1GetData();
    
	@Select("SELECT VoltageA_2,Electric_currentA_2,Host_temperature_2,Coolant_temperature_2,Sump_Pressure_2,Loading_pressure_2,"
			+ "Loading_time_2,Unloading_pressure_2,Alarm_number_2,Exhaust_pressure_2,Exhaust_temperature_2,Control_state_2,total_energy_2,"
			+ "Warning_sign_2,Running_time_2,Remote_switch_2,Active_Service_Rate2 FROM real_time_data")
	Real_time_data KYJ2GetData();
    
	@Select("SELECT VoltageA_3,Electric_currentA_3,Host_temperature_3,Coolant_temperature_3,Sump_Pressure_3,Loading_pressure_3,"
			+ "Loading_time_3,Unloading_pressure_3,Alarm_number_3,Exhaust_pressure_3,Exhaust_temperature_3,Control_state_3,total_energy_3,"
			+ "Warning_sign_3,Running_time_3,Remote_switch_3,Active_Service_Rate3 FROM real_time_data")
	Real_time_data KYJ3GetData();
}
