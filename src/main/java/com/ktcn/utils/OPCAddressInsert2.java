package com.ktcn.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.DataMasterTable;
import com.ktcn.entity.Data_master_table;
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
public class OPCAddressInsert2 {
	/* DAO层 */
	@Autowired
	private DataMasterTable DataMasterTable;
	// switch_output_value 对象存储类
	@Autowired
	private Switch_output_value switch_output_value;
	// switch_output_value 对象存储类
	@Autowired
	private Switch_input_value switch_input_value;

	public void GetOPCInsert(List<Boolean> fl) {

		switch_output_value.setS1((Boolean) fl.get(30));
		switch_output_value.setS2((Boolean) fl.get(31));
		switch_output_value.setS3((Boolean) fl.get(32));
		switch_output_value.setS4((Boolean) fl.get(33));
		switch_output_value.setS5((Boolean) fl.get(34));
		switch_output_value.setS6((Boolean) fl.get(35));
		switch_output_value.setS7((Boolean) fl.get(36));
		switch_output_value.setS8((Boolean) fl.get(37));
		switch_output_value.setS9((Boolean) fl.get(38));
		switch_output_value.setS10((Boolean) fl.get(39));
		switch_output_value.setS11((Boolean) fl.get(40));
		switch_output_value.setS12((Boolean) fl.get(41));
		switch_output_value.setS13((Boolean) fl.get(42));
		switch_output_value.setS14((Boolean) fl.get(43));
		switch_output_value.setS15((Boolean) fl.get(44));
		
//		int b = 1;
//		for (Object string : fl) {
//			System.out.println((b++) + "____" + string);
//		}
//
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// Switch_output 数据
		DataMasterTable.getswitchOutput(switch_output_value);

		// update zidu
		// switch_input 数据
		switch_input_value.setI1((Boolean) fl.get(0));
		switch_input_value.setI2((Boolean) fl.get(1));
		switch_input_value.setI3((Boolean) fl.get(2));
		switch_input_value.setI4((Boolean) fl.get(3));
		switch_input_value.setI5((Boolean) fl.get(4));
		switch_input_value.setI6((Boolean) fl.get(5));
		switch_input_value.setI7((Boolean) fl.get(6));
		switch_input_value.setI8((Boolean) fl.get(7));
		switch_input_value.setI9((Boolean) fl.get(8));
		switch_input_value.setI10((Boolean) fl.get(9));
		switch_input_value.setI11((Boolean) fl.get(10));
		switch_input_value.setI12((Boolean) fl.get(11));
		switch_input_value.setI13((Boolean) fl.get(12));
		switch_input_value.setI14((Boolean) fl.get(13));
		switch_input_value.setI15((Boolean) fl.get(14));
		switch_input_value.setI16((Boolean) fl.get(15));
		switch_input_value.setI17((Boolean) fl.get(16));
		switch_input_value.setI18((Boolean) fl.get(17));
		switch_input_value.setI19((Boolean) fl.get(18));
		switch_input_value.setI20((Boolean) fl.get(19));
		switch_input_value.setI21((Boolean) fl.get(20));
		switch_input_value.setI22((Boolean) fl.get(21));
		switch_input_value.setI23((Boolean) fl.get(22));
		switch_input_value.setI24((Boolean) fl.get(23));
		switch_input_value.setI25((Boolean) fl.get(24));
		switch_input_value.setI26((Boolean) fl.get(25));
		switch_input_value.setI27((Boolean) fl.get(26));
		switch_input_value.setI28((Boolean) fl.get(27));
		switch_input_value.setI29((Boolean) fl.get(28));
		switch_input_value.setI30((Boolean) fl.get(29));
		// switch_input 数据
//		System.out.println(switch_input_value);
		DataMasterTable.getswitcInput(switch_input_value);
//		int a = 1;
//		for (Object string : fl) {
//			System.out.println((a++) + "____" + string);
//		}

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
