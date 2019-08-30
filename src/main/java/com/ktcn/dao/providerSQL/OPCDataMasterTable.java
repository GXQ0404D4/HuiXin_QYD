package com.ktcn.dao.providerSQL;

import org.apache.ibatis.jdbc.SQL;

import com.ktcn.entity.Data_master_table;

/**
 * 测试动态SQL
 * @author Administrator
 *
 */
public class OPCDataMasterTable {
	public String opcdatamaster(Data_master_table dd) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				INSERT_INTO ("data_master_table (dmt_id,VoltageA_1,Electric_currentA_1,Host_temperature_1,Coolant_temperature_1,Sump_Pressure_1,Loading_pressure_1,Loading_time_1,Unloading_pressure_1,Exhaust_pressure_1,Exhaust_temperature_1) VALUES (NULL,"+dd.getVoltageA_1()+","+dd.getElectric_currentA_1()+","+dd.getHost_temperature_1()+","+dd.getCoolant_temperature_1()+","+dd.getSump_Pressure_1()+","+dd.getLoading_pressure_1()+","+dd.getLoading_time_1()+","+dd.getUnloading_pressure_1()+","+dd.getExhaust_pressure_1()+","+dd.getExhaust_temperature_1()+")");
			}
		}.toString();
		return sql;
	}
}
