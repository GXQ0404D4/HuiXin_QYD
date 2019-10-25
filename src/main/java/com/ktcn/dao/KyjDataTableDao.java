package com.ktcn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/**
 *历史数据持久层
 *
 */

@Mapper
@Repository
@ComponentScan(basePackages ="com.ktcn.dao.KyjDataTableDao")
public interface KyjDataTableDao {
	

	@Insert("INSERT INTO kyj_data_table (Voltage,Electric_current,Host_temperature,Coolant_temperature,Sump_Pressure,Loading_pressure,Loading_time,Unloading_pressure,Alarm_number,Exhaust_pressure,Exhaust_temperature,Control_state,total_energy,Warning_sign,Running_time,Remote_switch,Active_Service_Rate,pressure,Cumulative_flow,Compensated_flow,instantaneous_power,dew_point_temperature,total_power,total_electricity,electric,power_factor,machine_name,`current_date`,`current_time`,state) VALUES"
			+ "(#{kyj_data_table.Voltage},#{kyj_data_table.Electric_current},#{kyj_data_table.Host_temperature},#{kyj_data_table.Coolant_temperature},#{kyj_data_table.Sump_Pressure},#{kyj_data_table.Loading_pressure},#{kyj_data_table.Loading_time},#{kyj_data_table.Unloading_pressure},#{kyj_data_table.Alarm_number},#{kyj_data_table.Exhaust_pressure},#{kyj_data_table.Exhaust_temperature},#{kyj_data_table.Control_state},"
			+ "#{kyj_data_table.total_energy},#{kyj_data_table.Warning_sign},#{kyj_data_table.Running_time},#{kyj_data_table.Remote_switch},#{kyj_data_table.Active_Service_Rate},#{kyj_data_table.pressure},#{kyj_data_table.Cumulative_flow},#{kyj_data_table.Compensated_flow},#{kyj_data_table.instantaneous_power},#{kyj_data_table.dew_point_temperature},#{kyj_data_table.total_power},#{kyj_data_table.total_electricity},#{kyj_data_table.electric},#{kyj_data_table.power_factor},#{kyj_data_table.machine_name},NOW(3),NOW(3),#{kyj_data_table.state})")
	public void InsertKyjDataA(@Param("kyj_data_table")Kyj_data_table kyj_data_table);

	
	
	@Update("UPDATE kyj_data_table_temp SET Voltage = CASE id WHEN 1 THEN #{kyj_data_table1.Voltage} WHEN 2 THEN #{kyj_data_table2.Voltage} WHEN 3 THEN #{kyj_data_table3.Voltage} END,"
			+ "Electric_current = CASE id WHEN 1 THEN #{kyj_data_table1.Electric_current} WHEN 2 THEN #{kyj_data_table2.Electric_current} WHEN 3 THEN #{kyj_data_table3.Electric_current} END,"
			+ "Host_temperature = CASE id WHEN 1 THEN #{kyj_data_table1.Host_temperature} WHEN 2 THEN #{kyj_data_table2.Host_temperature} WHEN 3 THEN #{kyj_data_table3.Host_temperature} END,"
			+ "Coolant_temperature = CASE id WHEN 1 THEN #{kyj_data_table1.Coolant_temperature} WHEN 2 THEN #{kyj_data_table2.Coolant_temperature} WHEN 3 THEN #{kyj_data_table3.Coolant_temperature} END,"
			+ "Sump_Pressure = CASE id WHEN 1 THEN #{kyj_data_table1.Sump_Pressure} WHEN 2 THEN #{kyj_data_table2.Sump_Pressure} WHEN 3 THEN #{kyj_data_table3.Sump_Pressure} END,"
			+ "Loading_pressure = CASE id WHEN 1 THEN #{kyj_data_table1.Loading_pressure} WHEN 2 THEN #{kyj_data_table2.Loading_pressure} WHEN 3 THEN #{kyj_data_table3.Loading_pressure} END,"
			+ "Loading_time = CASE id WHEN 1 THEN #{kyj_data_table1.Loading_time} WHEN 2 THEN #{kyj_data_table2.Loading_time} WHEN 3 THEN #{kyj_data_table3.Loading_time} END,"
			+ "Unloading_pressure = CASE id WHEN 1 THEN #{kyj_data_table1.Unloading_pressure} WHEN 2 THEN #{kyj_data_table2.Unloading_pressure} WHEN 3 THEN #{kyj_data_table3.Unloading_pressure} END,"
			+ "Alarm_number = CASE id WHEN 1 THEN #{kyj_data_table1.Alarm_number} WHEN 2 THEN #{kyj_data_table2.Alarm_number} WHEN 3 THEN #{kyj_data_table3.Alarm_number} END,"
			+ "Exhaust_pressure = CASE id WHEN 1 THEN #{kyj_data_table1.Exhaust_pressure} WHEN 2 THEN #{kyj_data_table2.Exhaust_pressure} WHEN 3 THEN #{kyj_data_table3.Exhaust_pressure} END,"
			+ "Exhaust_temperature = CASE id WHEN 1 THEN #{kyj_data_table1.Exhaust_temperature} WHEN 2 THEN #{kyj_data_table2.Exhaust_temperature} WHEN 3 THEN #{kyj_data_table3.Exhaust_temperature} END,"
			+ "Control_state = CASE id WHEN 1 THEN #{kyj_data_table1.Control_state} WHEN 2 THEN #{kyj_data_table2.Control_state} WHEN 3 THEN #{kyj_data_table3.Control_state} END,"
			+ "total_energy = CASE id WHEN 1 THEN #{kyj_data_table1.total_energy} WHEN 2 THEN #{kyj_data_table2.total_energy} WHEN 3 THEN #{kyj_data_table3.total_energy} END,"
			+ "Warning_sign = CASE id WHEN 1 THEN #{kyj_data_table1.Warning_sign} WHEN 2 THEN #{kyj_data_table2.Warning_sign} WHEN 3 THEN #{kyj_data_table3.Warning_sign} END,"
			+ "Running_time = CASE id WHEN 1 THEN #{kyj_data_table1.Running_time} WHEN 2 THEN #{kyj_data_table2.Running_time} WHEN 3 THEN #{kyj_data_table3.Running_time} END,"
			+ "Remote_switch = CASE id WHEN 1 THEN #{kyj_data_table1.Remote_switch} WHEN 2 THEN #{kyj_data_table2.Remote_switch} WHEN 3 THEN #{kyj_data_table3.Remote_switch} END,"
			+ "Active_Service_Rate = CASE id WHEN 1 THEN #{kyj_data_table1.Active_Service_Rate} WHEN 2 THEN #{kyj_data_table2.Active_Service_Rate} WHEN 3 THEN #{kyj_data_table3.Active_Service_Rate} END,"
			+ "pressure = CASE id WHEN 1 THEN #{kyj_data_table1.pressure} WHEN 2 THEN #{kyj_data_table2.pressure} WHEN 3 THEN #{kyj_data_table3.pressure} END,"
			+ "Cumulative_flow = CASE id WHEN 1 THEN #{kyj_data_table1.Cumulative_flow} WHEN 2 THEN #{kyj_data_table2.Cumulative_flow} WHEN 3 THEN #{kyj_data_table3.Cumulative_flow} END,"
			+ "Compensated_flow = CASE id WHEN 1 THEN #{kyj_data_table1.Compensated_flow} WHEN 2 THEN #{kyj_data_table2.Compensated_flow} WHEN 3 THEN #{kyj_data_table3.Compensated_flow} END,"
			+ "instantaneous_power = CASE id WHEN 1 THEN #{kyj_data_table1.instantaneous_power} WHEN 2 THEN #{kyj_data_table2.instantaneous_power} WHEN 3 THEN #{kyj_data_table3.instantaneous_power} END,"
			+ "machine_name = CASE id WHEN 1 THEN #{kyj_data_table1.machine_name} WHEN 2 THEN #{kyj_data_table2.machine_name} WHEN 3 THEN #{kyj_data_table3.machine_name} END,"
			+ "state = CASE id WHEN 1 THEN #{kyj_data_table1.state} WHEN 2 THEN #{kyj_data_table2.state} WHEN 3 THEN #{kyj_data_table1.state} END WHERE id IN (1,2,3) ")
	public void UpdateKyjTempData(@Param("kyj_data_table1") Kyj_data_table kyj_data_table1,@Param("kyj_data_table2")  Kyj_data_table kyj_data_table2,@Param("kyj_data_table3")  Kyj_data_table kyj_data_table3);



	

}
