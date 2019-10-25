package com.ktcn.utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.DataMasterTable;
import com.ktcn.entity.Compressor_report;
import com.ktcn.entity.Electric_massage;
import com.ktcn.entity.Mian_network;
import com.ktcn.entity.Real_time_data;

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
	Electric_massage electric_massage;

	@Autowired
	Mian_network mian_network;
	
	@Autowired
	Compressor_report compressor_report;

	public void GetOPCInsert(ArrayList<Object> fl) {
		
		  
		  
//		  try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
		 

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

		// 将Real_time_data实时数据实体类 直接复制给相同属性值的data_master_table历史数据实体类
//		BeanUtils.copyProperties(Real_time_data, data_master_table); 
		DataMasterTable.UpdateRealTime(Real_time_data); // 实时数据存入数据库
//		DataMasterTable.OpcDataMasterInsert(data_master_table);// 历史数据存入数据库

		// 电量表存入
		Float dl1 = (float) fl.get(1) + (float) fl.get(17) + (float) fl.get(33);
		electric_massage.setVoltageA((float) fl.get(0));
		electric_massage.setVoltageB((float) fl.get(16));
		electric_massage.setVoltageC((float) fl.get(32));
		electric_massage.setElectric_currentA((float) fl.get(1));
		electric_massage.setElectric_currentB((float) fl.get(17));
		electric_massage.setElectric_currentC((float) fl.get(33));
		electric_massage.setInstantaneous_power((float) fl.get(54));
		electric_massage.setElectric_quantity(dl1);
		//总管网存入
		mian_network.setPressureA((float) fl.get(51));
		mian_network.setPressureB((float) fl.get(51));
		mian_network.setLU_dianA((float) fl.get(17));
		mian_network.setLU_dianB((float) fl.get(33));
		mian_network.setInstantaneous_flow((float) fl.get(52));
		mian_network.setTotal_power((float) fl.get(54));
		mian_network.setTotal_electricity(dl1);
		
//		System.out.println(fl);
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//空压机数据表存入
		compressor_report.setElectric_energy_A((float) fl.get(12));
		compressor_report.setElectric_energy_B((float) fl.get(28));
		compressor_report.setElectric_energy_C((float) fl.get(44));
//		compressor_report.setRunning_time_A((Date) fl.get(15));
//		compressor_report.setRunning_time_B((Date) fl.get(31));
//		compressor_report.setRunning_time_C((Date) fl.get(47));
		compressor_report.setActive_powerA((float) fl.get(48));
		compressor_report.setActive_powerB((float) fl.get(49));
		compressor_report.setActive_powerC((float) fl.get(50));			
		
		
		DataMasterTable.DataMasterTableInsert(compressor_report);
		
		DataMasterTable.ElectricInsert(electric_massage);
		
		DataMasterTable.Mian_networkInsert(mian_network);
		
		
	}

}
