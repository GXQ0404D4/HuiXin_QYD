package com.ktcn.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.KyjDataTableDao;
import com.ktcn.entity.Switch_input_value;
import com.ktcn.entity.Switch_output_value;
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
public class OpcDataKyjSwitch {
	// 空压机存入DAO层
	@Autowired
	KyjDataTableDao kyjDataTableDao;

	@Autowired
	Switch_output_value switch_output_value;
	// switch_output_value 对象存储类
	@Autowired
	Switch_input_value switch_input_value;

	public void setKyjDataSwtich(List<Boolean> f1, List<Boolean> f2) {

		switch_output_value.setS1((Boolean) f2.get(0));
		switch_output_value.setS2((Boolean) f2.get(1));
		switch_output_value.setS3((Boolean) f2.get(2));
		switch_output_value.setS4((Boolean) f2.get(3));
		switch_output_value.setS5((Boolean) f2.get(4));
		switch_output_value.setS6((Boolean) f2.get(5));
		switch_output_value.setS7((Boolean) f2.get(6));
		switch_output_value.setS8((Boolean) f2.get(7));
		switch_output_value.setS9((Boolean) f2.get(8));
		switch_output_value.setS10((Boolean) f2.get(9));
		switch_output_value.setS11((Boolean) f2.get(10));
		switch_output_value.setS12((Boolean) f2.get(11));
		switch_output_value.setS13((Boolean) f2.get(12));
		switch_output_value.setS14((Boolean) f2.get(13));
		switch_output_value.setS15((Boolean) f2.get(14));
		// switch_input 数据
		switch_input_value.setI1((Boolean) f1.get(0));
		switch_input_value.setI2((Boolean) f1.get(1));
		switch_input_value.setI3((Boolean) f1.get(2));
		switch_input_value.setI4((Boolean) f1.get(3));
		switch_input_value.setI5((Boolean) f1.get(4));
		switch_input_value.setI6((Boolean) f1.get(5));
		switch_input_value.setI7((Boolean) f1.get(6));
		switch_input_value.setI8((Boolean) f1.get(7));
		switch_input_value.setI9((Boolean) f1.get(8));
		switch_input_value.setI10((Boolean) f1.get(9));
		switch_input_value.setI11((Boolean) f1.get(10));
		switch_input_value.setI12((Boolean) f1.get(11));
		switch_input_value.setI13((Boolean) f1.get(12));
		switch_input_value.setI14((Boolean) f1.get(13));
		switch_input_value.setI15((Boolean) f1.get(14));
		switch_input_value.setI16((Boolean) f1.get(15));
		switch_input_value.setI17((Boolean) f1.get(16));
		switch_input_value.setI18((Boolean) f1.get(17));
		switch_input_value.setI19((Boolean) f1.get(18));
		switch_input_value.setI20((Boolean) f1.get(19));
		switch_input_value.setI21((Boolean) f1.get(20));
		switch_input_value.setI22((Boolean) f1.get(21));
		switch_input_value.setI23((Boolean) f1.get(22));
		switch_input_value.setI24((Boolean) f1.get(23));
		switch_input_value.setI25((Boolean) f1.get(24));
		switch_input_value.setI26((Boolean) f1.get(25));
		switch_input_value.setI27((Boolean) f1.get(26));
		switch_input_value.setI28((Boolean) f1.get(27));
		switch_input_value.setI29((Boolean) f1.get(28));
		switch_input_value.setI30((Boolean) f1.get(29));

		// Switch_output 数据
		kyjDataTableDao.getswitchOutput(switch_output_value);

		// switch_input 数据
		kyjDataTableDao.getswitcInput(switch_input_value);

	}

}
