package com.ktcn.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.KyjDataTableDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/**
 * @Title: OPCAddressInsert.java
 * @Package com.ktcn.utils
 * @Description: DATA_MASTER_TABLE 抓取kepserver 数据
 * @author GXQ
 * @version V1.0
 */

@EnableScheduling
@Component
@Repository
public class OpcDataKyjInsertB {

	final static Map<String, Kyj_data_table> map = new HashMap<String, Kyj_data_table>();
	// 空压机实体类
	Kyj_data_table kyj_data_table1 = new Kyj_data_table();
	Kyj_data_table kyj_data_table2 = new Kyj_data_table();
	Kyj_data_table kyj_data_table3 = new Kyj_data_table();

	// 空压机存入DAO层
	@Autowired

	KyjDataTableDao kyjDataTableDao;

	public void setKyjDataTable(List<Object> f1, ArrayList<Object> f2, ArrayList<Object> f3) {

		kyj_data_table1.setVoltage((float) f1.get(0));
		kyj_data_table1.setElectric_current((float) f1.get(1));
		kyj_data_table1.setHost_temperature((float) f1.get(2));
		kyj_data_table1.setCoolant_temperature((float) f1.get(3));
		kyj_data_table1.setSump_Pressure((float) f1.get(4));
		kyj_data_table1.setLoading_pressure((float) f1.get(5));
		kyj_data_table1.setLoading_time((float) f1.get(6));
		kyj_data_table1.setUnloading_pressure((float) f1.get(7));
		kyj_data_table1.setAlarm_number(f1.get(8));
		kyj_data_table1.setExhaust_pressure((float) f1.get(9));
		kyj_data_table1.setExhaust_temperature((float) f1.get(10));
		kyj_data_table1.setControl_state(f1.get(11));
		kyj_data_table1.setTotal_energy((float) f1.get(12));
		kyj_data_table1.setWarning_sign(f1.get(13));
		kyj_data_table1.setRunning_time((float) f1.get(14));
		kyj_data_table1.setRemote_switch(f1.get(15));
		kyj_data_table1.setActive_Service_Rate((float) f1.get(16));
		kyj_data_table1.setPressure((float) f1.get(17));
		kyj_data_table1.setCumulative_flow((float) f1.get(18));
		kyj_data_table1.setCompensated_flow((float) f1.get(19));
		kyj_data_table1.setInstantaneous_power((float) f1.get(20));

		kyj_data_table1.setDew_point_temperature((float) f1.get(21));
		kyj_data_table1.setTotal_power((float) f1.get(22));
		kyj_data_table1.setTotal_electricity((float) f1.get(23));
		kyj_data_table1.setElectric((float) f1.get(24));
		kyj_data_table1.setPower_factor((float) f1.get(25));
		kyj_data_table1.setMachine_name("空压机A");
		kyj_data_table1.setState("1");

		kyj_data_table2.setVoltage((float) f2.get(0));
		kyj_data_table2.setElectric_current((float) f2.get(1));
		kyj_data_table2.setHost_temperature((float) f2.get(2));
		kyj_data_table2.setCoolant_temperature((float) f2.get(3));
		kyj_data_table2.setSump_Pressure((float) f2.get(4));
		kyj_data_table2.setLoading_pressure((float) f2.get(5));
		kyj_data_table2.setLoading_time((float) f2.get(6));
		kyj_data_table2.setUnloading_pressure((float) f2.get(7));
		kyj_data_table2.setAlarm_number(f2.get(8));
		kyj_data_table2.setExhaust_pressure((float) f2.get(9));
		kyj_data_table2.setExhaust_temperature((float) f2.get(10));
		kyj_data_table2.setControl_state(f2.get(11));
		kyj_data_table2.setTotal_energy((float) f2.get(12));
		kyj_data_table2.setWarning_sign(f2.get(13));
		kyj_data_table2.setRunning_time((float) f2.get(14));
		kyj_data_table2.setRemote_switch(f2.get(15));
		kyj_data_table2.setActive_Service_Rate((float) f2.get(16));
		kyj_data_table2.setPressure((float) f2.get(17));
		kyj_data_table2.setCumulative_flow((float) f2.get(18));
		kyj_data_table2.setCompensated_flow((float) f2.get(19));
		kyj_data_table2.setInstantaneous_power((float) f2.get(20));

		kyj_data_table2.setDew_point_temperature((float) f2.get(21));
		kyj_data_table2.setTotal_power((float) f2.get(22));
		kyj_data_table2.setTotal_electricity((float) f2.get(23));
		kyj_data_table2.setElectric((float) f2.get(24));
		kyj_data_table2.setPower_factor((float) f2.get(25));
		kyj_data_table2.setMachine_name("空压机B");
		kyj_data_table2.setState("1");

		kyj_data_table3.setVoltage((float) f3.get(0));
		kyj_data_table3.setElectric_current((float) f3.get(1));
		kyj_data_table3.setHost_temperature((float) f3.get(2));
		kyj_data_table3.setCoolant_temperature((float) f3.get(3));
		kyj_data_table3.setSump_Pressure((float) f3.get(4));
		kyj_data_table3.setLoading_pressure((float) f3.get(5));
		kyj_data_table3.setLoading_time((float) f3.get(6));
		kyj_data_table3.setUnloading_pressure((float) f3.get(7));
		kyj_data_table3.setAlarm_number(f3.get(8));
		kyj_data_table3.setExhaust_pressure((float) f3.get(9));
		kyj_data_table3.setExhaust_temperature((float) f3.get(10));
		kyj_data_table3.setControl_state(f3.get(11));
		kyj_data_table3.setTotal_energy((float) f3.get(12));
		kyj_data_table3.setWarning_sign(f3.get(13));
		kyj_data_table3.setRunning_time((float) f3.get(14));
		kyj_data_table3.setRemote_switch(f3.get(15));
		kyj_data_table3.setActive_Service_Rate((float) f3.get(16));
		kyj_data_table3.setPressure((float) f3.get(17));
		kyj_data_table3.setCumulative_flow((float) f3.get(18));
		kyj_data_table3.setCompensated_flow((float) f3.get(19));
		kyj_data_table3.setInstantaneous_power((float) f3.get(20));

		kyj_data_table3.setDew_point_temperature((float) f3.get(21));
		kyj_data_table3.setTotal_power((float) f3.get(22));
		kyj_data_table3.setTotal_electricity((float) f3.get(23));
		kyj_data_table3.setElectric((float) f3.get(24));
		kyj_data_table3.setPower_factor((float) f3.get(25));
		kyj_data_table3.setMachine_name("空压机C");
		kyj_data_table3.setState("1");
		// 实时数据表存储
		kyjDataTableDao.UpdateKyjTempData(kyj_data_table1, kyj_data_table2, kyj_data_table3);
		// 实时数据存入map集合 以便 历史数据表使用
		map.put("kyj_data_table1", kyj_data_table1);
		map.put("kyj_data_table2", kyj_data_table2);
		map.put("kyj_data_table3", kyj_data_table3);

	}

	// 5秒存储一次历史数据
	@Scheduled(cron = "0/5 * * * * ?")
	public void SetUtgardSecondData() {
		// 历史数据表5秒定时存储
		kyjDataTableDao.InsertKyjDataA(map.get("kyj_data_table1"));
		kyjDataTableDao.InsertKyjDataA(map.get("kyj_data_table2"));
		kyjDataTableDao.InsertKyjDataA(map.get("kyj_data_table3"));
	}

	// 一小时存储一次历史数据
	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0 0/1 * * * ?")
	public void SetUtgardHourData() {
		// 历史数据表5秒定时存储
		kyjDataTableDao.InsertKyjHourData(map.get("kyj_data_table1"));
		kyjDataTableDao.InsertKyjHourData(map.get("kyj_data_table2"));
		kyjDataTableDao.InsertKyjHourData(map.get("kyj_data_table3"));
	}

}
