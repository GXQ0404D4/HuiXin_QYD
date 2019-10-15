package com.ktcn.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.DataMasterTable;
import com.ktcn.entity.Data_master_table;
import com.ktcn.entity.Real_time_data;
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
	/* DAO层 */
	@Autowired
	private DataMasterTable DataMasterTable;
	/* data_master_table 数据主表实体类 */

	@Autowired
	private Real_time_data Real_time_data;

	@Autowired
	private Data_master_table data_master_table;


	public void GetOPCInsert(ArrayList<Object> fl) {
		System.out.println(fl);

		Real_time_data.setVoltageA_1((float) fl.get(0));
		Real_time_data.setElectric_currentA_1((float) fl.get(1));
		Real_time_data.setHost_temperature_1((float) fl.get(2));
		Real_time_data.setCoolant_temperature_1((float) fl.get(3));
		Real_time_data.setSump_Pressure_1((float) fl.get(4));
		Real_time_data.setLoading_pressure_1((float) fl.get(5));
		Real_time_data.setLoading_time_1((float) fl.get(6));
		Real_time_data.setUnloading_pressure_1((float) fl.get(7));
		Real_time_data.setAlarm_number_1(fl.get(8));
		Real_time_data.setExhaust_pressure_1((float) fl.get(9));
		Real_time_data.setExhaust_temperature_1((float) fl.get(10));
		Real_time_data.setControl_state_1(fl.get(11));
		Real_time_data.setTotal_energy_1((float) fl.get(12));
		Real_time_data.setWarning_sign_1(fl.get(13));
		Real_time_data.setRunning_time_1((float) fl.get(14));
		Real_time_data.setRemote_switch_1(fl.get(15));

		Real_time_data.setVoltageA_2((float) fl.get(16));
		Real_time_data.setElectric_currentA_2((float) fl.get(17));
		Real_time_data.setHost_temperature_2((float) fl.get(18));
		Real_time_data.setCoolant_temperature_2((float) fl.get(19));
		Real_time_data.setSump_Pressure_2((float) fl.get(20));
		Real_time_data.setLoading_pressure_2((float) fl.get(21));
		Real_time_data.setLoading_time_2((float) fl.get(22));
		Real_time_data.setUnloading_pressure_2((float) fl.get(23));
		Real_time_data.setAlarm_number_2(fl.get(24));
		Real_time_data.setExhaust_pressure_2((float) fl.get(25));
		Real_time_data.setExhaust_temperature_2((float) fl.get(26));
		Real_time_data.setControl_state_2(fl.get(27));
		Real_time_data.setTotal_energy_2((float) fl.get(28));
		Real_time_data.setWarning_sign_2(fl.get(29));
		Real_time_data.setRunning_time_2((float) fl.get(30));
		Real_time_data.setRemote_switch_2(fl.get(31));

		Real_time_data.setVoltageA_3((float) fl.get(32));
		Real_time_data.setElectric_currentA_3((float) fl.get(33));
		Real_time_data.setHost_temperature_3((float) fl.get(34));
		Real_time_data.setCoolant_temperature_3((float) fl.get(35));
		Real_time_data.setSump_Pressure_3((float) fl.get(36));
		Real_time_data.setLoading_pressure_3((float) fl.get(37));
		Real_time_data.setLoading_time_3((float) fl.get(38));
		Real_time_data.setUnloading_pressure_3((float) fl.get(39));
		Real_time_data.setAlarm_number_3(fl.get(40));
		Real_time_data.setExhaust_pressure_3((float) fl.get(41));
		Real_time_data.setExhaust_temperature_3((float) fl.get(42));
		Real_time_data.setControl_state_3(fl.get(43));
		Real_time_data.setTotal_energy_3((float) fl.get(44));
		Real_time_data.setWarning_sign_3(fl.get(45));
		Real_time_data.setRunning_time_3((float) fl.get(46));
		Real_time_data.setRemote_switch_3(fl.get(47));
		Real_time_data.setActive_Service_Rate1((float) fl.get(48));
		Real_time_data.setActive_Service_Rate2((float) fl.get(49));
		Real_time_data.setActive_Service_Rate3((float) fl.get(50));
		Real_time_data.setPressure((float) fl.get(51));
		Real_time_data.setCumulative_flow((float) fl.get(52));
		Real_time_data.setCompensated_flow((float) fl.get(53));
		
		int b = 1;
		for (Object string : fl) {
			System.out.println((b++) + "____" + string);
		}

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// System.out.println(Real_time_data);
		DataMasterTable.UpdateRealTime(Real_time_data);
		// System.out.println(Real_time_data + "###############################");

		data_master_table.setVoltageA_1((float) fl.get(0));
		data_master_table.setElectric_currentA_1((float) fl.get(1));
		data_master_table.setHost_temperature_1((float) fl.get(2));
		data_master_table.setCoolant_temperature_1((float) fl.get(3));
		data_master_table.setSump_Pressure_1((float) fl.get(4));
		data_master_table.setLoading_pressure_1((float) fl.get(5));
		data_master_table.setLoading_time_1((float) fl.get(6));
		data_master_table.setUnloading_pressure_1((float) fl.get(7));
		data_master_table.setAlarm_number_1(fl.get(8));
		data_master_table.setExhaust_pressure_1((float) fl.get(9));
		data_master_table.setExhaust_temperature_1((float) fl.get(10));
		data_master_table.setControl_state_1(fl.get(11));
		data_master_table.setTotal_energy_1((float) fl.get(12));
		data_master_table.setWarning_sign_1(fl.get(13));
		data_master_table.setRunning_time_1((float) fl.get(14));
		data_master_table.setRemote_switch_1(fl.get(15));

		data_master_table.setVoltageA_2((float) fl.get(16));
		data_master_table.setElectric_currentA_2((float) fl.get(17));
		data_master_table.setHost_temperature_2((float) fl.get(18));
		data_master_table.setCoolant_temperature_2((float) fl.get(19));
		data_master_table.setSump_Pressure_2((float) fl.get(20));
		data_master_table.setLoading_pressure_2((float) fl.get(21));
		data_master_table.setLoading_time_2((float) fl.get(22));
		data_master_table.setUnloading_pressure_2((float) fl.get(23));
		data_master_table.setAlarm_number_2(fl.get(24));
		data_master_table.setExhaust_pressure_2((float) fl.get(25));
		data_master_table.setExhaust_temperature_2((float) fl.get(26));
		data_master_table.setControl_state_2(fl.get(27));
		data_master_table.setTotal_energy_2((float) fl.get(28));
		data_master_table.setWarning_sign_2(fl.get(29));
		data_master_table.setRunning_time_2((float) fl.get(30));
		data_master_table.setRemote_switch_2(fl.get(31));

		data_master_table.setVoltageA_3((float) fl.get(32));
		data_master_table.setElectric_currentA_3((float) fl.get(33));
		data_master_table.setHost_temperature_3((float) fl.get(34));
		data_master_table.setCoolant_temperature_3((float) fl.get(35));
		data_master_table.setSump_Pressure_3((float) fl.get(36));
		data_master_table.setLoading_pressure_3((float) fl.get(37));
		data_master_table.setLoading_time_3((float) fl.get(38));
		data_master_table.setUnloading_pressure_3((float) fl.get(39));
		data_master_table.setAlarm_number_3(fl.get(40));
		data_master_table.setExhaust_pressure_3((float) fl.get(41));
		data_master_table.setExhaust_temperature_3((float) fl.get(42));
		data_master_table.setControl_state_3(fl.get(43));
		data_master_table.setTotal_energy_3((float) fl.get(44));
		data_master_table.setWarning_sign_3(fl.get(45));
		data_master_table.setRunning_time_3((float) fl.get(46));
		data_master_table.setRemote_switch_3(fl.get(47));
		data_master_table.setActive_Service_Rate1((float) fl.get(48));
		data_master_table.setActive_Service_Rate2((float) fl.get(49));
		data_master_table.setActive_Service_Rate3((float) fl.get(50));
		data_master_table.setPressure((float) fl.get(51));
		data_master_table.setCumulative_flow((float) fl.get(52));
		data_master_table.setCompensated_flow((float) fl.get(53));

//		System.out.println(data_master_table);
		DataMasterTable.OpcDataMasterInsert(data_master_table);
//		System.out.println(data_master_table + "data_master_table");

		int a = 1;
		for (Object string : fl) {
			System.out.println((a++) + "____" + string);
		}

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
