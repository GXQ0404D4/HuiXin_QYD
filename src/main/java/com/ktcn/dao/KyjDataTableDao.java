package com.ktcn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

//	@Insert("INSERT INTO kyj_data_table (Voltage,Electric_current,Host_temperature,Coolant_temperature,Sump_Pressure,Loading_pressure,Loading_time,Unloading_pressure,Alarm_number,Exhaust_pressure,Exhaust_temperature,Control_state,total_energy,Warning_sign,Running_time,Remote_switch,Active_Service_Rate,pressure,Cumulative_flow,Compensated_flow,instantaneous_power,machine_name,`current_date`,`current_time`,state) VALUES"
//			+ "(#{kyj_data_table.Voltage},#{kyj_data_table.Electric_current},#{kyj_data_table.Host_temperature},#{kyj_data_table.Coolant_temperature},#{kyj_data_table.Sump_Pressure},#{kyj_data_table.Loading_pressure},#{kyj_data_table.Loading_time},#{kyj_data_table.Unloading_pressure},#{kyj_data_table.Alarm_number},#{kyj_data_table.Exhaust_pressure},#{kyj_data_table.Exhaust_temperature},#{kyj_data_table.Control_state},"
//			+ "#{kyj_data_table.total_energy},#{kyj_data_table.Warning_sign},#{kyj_data_table.Running_time},#{kyj_data_table.Remote_switch},#{kyj_data_table.Active_Service_Rate},#{kyj_data_table.pressure},#{kyj_data_table.Cumulative_flow},#{kyj_data_table.Compensated_flow},#{kyj_data_table.instantaneous_power},#{kyj_data_table.machine_name},NOW(),NOW(),#{kyj_data_table.state})")
//	public void InsertKyjDataB(@Param("kyj_data_table")Kyj_data_table kyj_data_table);

	

}
