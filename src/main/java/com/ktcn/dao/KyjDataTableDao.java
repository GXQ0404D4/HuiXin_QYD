package com.ktcn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Switch_input_value;
import com.ktcn.entity.Switch_output_value;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/**
 *历史数据持久层
 *
 */

@Mapper
@Repository
@ComponentScan(basePackages ="com.ktcn.dao.KyjDataTableDao")
public interface KyjDataTableDao {
	
    //历史数据库添加
	@Insert("INSERT INTO kyj_data_table (Voltage,Electric_current,Host_temperature,Coolant_temperature,Sump_Pressure,Loading_pressure,Loading_time,Unloading_pressure,Alarm_number,Exhaust_pressure,Exhaust_temperature,Control_state,total_energy,Warning_sign,Running_time,Remote_switch,Active_Service_Rate,pressure,Cumulative_flow,Compensated_flow,instantaneous_power,dew_point_temperature,total_power,total_electricity,electric,power_factor,machine_name,`current_date`,`current_time`,state) VALUES"
			+ "(#{kyj_data_table.Voltage},#{kyj_data_table.Electric_current},#{kyj_data_table.Host_temperature},#{kyj_data_table.Coolant_temperature},#{kyj_data_table.Sump_Pressure},#{kyj_data_table.Loading_pressure},#{kyj_data_table.Loading_time},#{kyj_data_table.Unloading_pressure},#{kyj_data_table.Alarm_number},#{kyj_data_table.Exhaust_pressure},#{kyj_data_table.Exhaust_temperature},#{kyj_data_table.Control_state},"
			+ "#{kyj_data_table.total_energy},#{kyj_data_table.Warning_sign},#{kyj_data_table.Running_time},#{kyj_data_table.Remote_switch},#{kyj_data_table.Active_Service_Rate},#{kyj_data_table.pressure},#{kyj_data_table.Cumulative_flow},#{kyj_data_table.Compensated_flow},#{kyj_data_table.instantaneous_power},#{kyj_data_table.dew_point_temperature},#{kyj_data_table.total_power},#{kyj_data_table.total_electricity},#{kyj_data_table.electric},#{kyj_data_table.power_factor},#{kyj_data_table.machine_name},NOW(3),NOW(3),#{kyj_data_table.state})")
	public void InsertKyjDataA(@Param("kyj_data_table")Kyj_data_table kyj_data_table);
	
	//小时数据库历史表
	@Insert("INSERT INTO kyj_data_hour (Voltage,Electric_current,Host_temperature,Coolant_temperature,Sump_Pressure,Loading_pressure,Loading_time,Unloading_pressure,Alarm_number,Exhaust_pressure,Exhaust_temperature,Control_state,total_energy,Warning_sign,Running_time,Remote_switch,Active_Service_Rate,pressure,Cumulative_flow,Compensated_flow,instantaneous_power,dew_point_temperature,total_power,total_electricity,electric,power_factor,machine_name,`current_date`,`current_time`,state) VALUES"
			+ "(#{kyj_data_table.Voltage},#{kyj_data_table.Electric_current},#{kyj_data_table.Host_temperature},#{kyj_data_table.Coolant_temperature},#{kyj_data_table.Sump_Pressure},#{kyj_data_table.Loading_pressure},#{kyj_data_table.Loading_time},#{kyj_data_table.Unloading_pressure},#{kyj_data_table.Alarm_number},#{kyj_data_table.Exhaust_pressure},#{kyj_data_table.Exhaust_temperature},#{kyj_data_table.Control_state},"
			+ "#{kyj_data_table.total_energy},#{kyj_data_table.Warning_sign},#{kyj_data_table.Running_time},#{kyj_data_table.Remote_switch},#{kyj_data_table.Active_Service_Rate},#{kyj_data_table.pressure},#{kyj_data_table.Cumulative_flow},#{kyj_data_table.Compensated_flow},#{kyj_data_table.instantaneous_power},#{kyj_data_table.dew_point_temperature},#{kyj_data_table.total_power},#{kyj_data_table.total_electricity},#{kyj_data_table.electric},#{kyj_data_table.power_factor},#{kyj_data_table.machine_name},NOW(3),NOW(3),#{kyj_data_table.state})")
	public void InsertKyjHourData(@Param("kyj_data_table")Kyj_data_table kyj_data_table);

	
	
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
	
	
	/*switch_output 开关输入输入信息修改*/
	@Update("UPDATE switch_output SET switch_ouput_data = CASE  output_id "
			+ "WHEN 1 THEN #{switch1.s1} WHEN 2 THEN #{switch1.s2} WHEN 3 THEN #{switch1.s3} "
			+ "WHEN 4 THEN #{switch1.s4} WHEN 5 THEN #{switch1.s5} WHEN 6 THEN #{switch1.s6} "
			+ "WHEN 7 THEN #{switch1.s7} WHEN 8 THEN #{switch1.s8} WHEN 9 THEN #{switch1.s9} "			
			+ "WHEN 10 THEN #{switch1.s10} WHEN 11 THEN #{switch1.s11} WHEN 12 THEN #{switch1.s12} "			
			+ "WHEN 13 THEN #{switch1.s13} WHEN 14 THEN #{switch1.s14} WHEN 15 THEN #{switch1.s15} "			
			+ "END WHERE output_id IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)")
	void getswitchOutput(@Param("switch1") Switch_output_value switch1);
	
	
	/*switch_input 开关输入输入信息修改*/
	@Update("UPDATE switch_input SET switch_input_data = CASE  input_id "
			+ "WHEN 1 THEN #{switch2.i1} WHEN 2 THEN #{switch2.i2} WHEN 3 THEN #{switch2.i3} WHEN 4 THEN #{switch2.i4} WHEN 5 THEN #{switch2.i5} "
			+ "WHEN 6 THEN #{switch2.i6} WHEN 7 THEN #{switch2.i7} WHEN 8 THEN #{switch2.i8} WHEN 9 THEN #{switch2.i9} WHEN 10 THEN #{switch2.i10} "
			+ "WHEN 11 THEN #{switch2.i11} WHEN 12 THEN #{switch2.i12} WHEN 13 THEN #{switch2.i13} WHEN 14 THEN #{switch2.i14} WHEN 15 THEN #{switch2.i15} "
			+ "WHEN 16 THEN #{switch2.i16} WHEN 17 THEN #{switch2.i17} WHEN 18 THEN #{switch2.i18} WHEN 19 THEN #{switch2.i19} WHEN 20 THEN #{switch2.i20} "
			+ "WHEN 21 THEN #{switch2.i21} WHEN 22 THEN #{switch2.i22} WHEN 23 THEN #{switch2.i23} WHEN 24 THEN #{switch2.i24} WHEN 25 THEN #{switch2.i25} "
			+ "WHEN 26 THEN #{switch2.i26} WHEN 27 THEN #{switch2.i27} WHEN 28 THEN #{switch2.i28} WHEN 29 THEN #{switch2.i29} WHEN 30 THEN #{switch2.i30} "			
			+ "END WHERE input_id IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30)")
	void getswitcInput(@Param("switch2") Switch_input_value switch2);



	



	

}
