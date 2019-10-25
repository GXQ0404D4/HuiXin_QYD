package com.ktcn.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@Component
@Repository
public class OpcDataKyjInsertA {
	// 空压机实体类
	@Autowired
     Kyj_data_table kyj_data_table;
	// 空压机存入DAO层
	@Autowired
     KyjDataTableDao kyjDataTableDao;

	public void setKyjDataTable(List<Object> fl) {

		kyj_data_table.setVoltage((float) fl.get(0));
		kyj_data_table.setElectric_current((float) fl.get(1));
		kyj_data_table.setHost_temperature((float) fl.get(2));
		kyj_data_table.setCoolant_temperature((float) fl.get(3));
		kyj_data_table.setSump_Pressure((float) fl.get(4));
		kyj_data_table.setLoading_pressure((float) fl.get(5));
		kyj_data_table.setLoading_time((float) fl.get(6));
		kyj_data_table.setUnloading_pressure((float) fl.get(7));
		kyj_data_table.setAlarm_number( fl.get(8));
		kyj_data_table.setExhaust_pressure((float) fl.get(9));
		kyj_data_table.setExhaust_temperature((float) fl.get(10));
		kyj_data_table.setControl_state( fl.get(11));
		kyj_data_table.setTotal_energy((float) fl.get(12));
		kyj_data_table.setWarning_sign( fl.get(13));
		kyj_data_table.setRunning_time((float) fl.get(14));
		kyj_data_table.setRemote_switch( fl.get(15));
		kyj_data_table.setActive_Service_Rate((float) fl.get(16));
		kyj_data_table.setPressure((float) fl.get(17));
		kyj_data_table.setCumulative_flow((float) fl.get(18));
		kyj_data_table.setCompensated_flow((float) fl.get(19));
		kyj_data_table.setInstantaneous_power((float) fl.get(20));
		kyj_data_table.setMachine_name("空压机A");
		kyj_data_table.setState("1");
		kyjDataTableDao.InsertKyjDataA(kyj_data_table);				
		
	}

}
