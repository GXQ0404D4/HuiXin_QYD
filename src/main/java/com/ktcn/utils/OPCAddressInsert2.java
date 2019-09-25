package com.ktcn.utils;

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
	/*DAO层*/
	@Autowired
    private DataMasterTable DataMasterTable;
	//switch_output_value 对象存储类
	@Autowired
	private Switch_output_value switch_output_value;
	//switch_output_value 对象存储类
	@Autowired
	private Switch_input_value switch_input_value;
	
public void GetOPCInsert(Map<String, Boolean> map2){
		System.out.println(map2);
	     		
     	/*switch_output_value.setS1(map2.get("DO-1#KYJQD"));
		switch_output_value.setS2(map2.get("DO-1#KYJTZ"));
		switch_output_value.setS3(map2.get("DO-1#LGJQD"));
		switch_output_value.setS4(map2.get("DO-1#LGJTZ"));
		switch_output_value.setS5(map2.get("DO-2#KYJQD"));
		switch_output_value.setS6(map2.get("DO-2#KYJTZ"));
		switch_output_value.setS7(map2.get("DO-2#LGJQD"));
		switch_output_value.setS8(map2.get("DO-2#LGJTZ"));
		switch_output_value.setS9(map2.get("DO-3#KYJQD"));
		switch_output_value.setS10(map2.get("DO-3#KYJTZ"));
		switch_output_value.setS11(map2.get("DO-3#LGJQD"));
		switch_output_value.setS12(map2.get("DO-3#LGJTZ"));		
		switch_output_value.setS13(map2.get("DO-1#KYJZD/SD"));		
		switch_output_value.setS14(map2.get("DO-2#KYJZD/SD"));		
		switch_output_value.setS15(map2.get("DO-3#KYJZD/SD"));		
		//Switch_output 数据
		DataMasterTable.getswitchOutput(switch_output_value);
		
		
		//update zidu
		//switch_input 数据
		switch_input_value.setI1(map2.get("2#KYJJZ/XZ"));
		switch_input_value.setI2(map2.get("3#KYJJZ/XZ"));
		switch_input_value.setI3(map2.get("DI-1#FKDJ/LJ"));
		switch_input_value.setI4(map2.get("DI-1#KYJBD/YC"));
		switch_input_value.setI5(map2.get("DI-1#KYJBJGZ"));
		switch_input_value.setI6(map2.get("DI-1#KYJJX"));
		switch_input_value.setI7(map2.get("DI-1#KYJJZ/XZ"));
		switch_input_value.setI8(map2.get("DI-1#KYJTJGZ"));
		switch_input_value.setI9(map2.get("DI-1#KYJYX"));
		switch_input_value.setI10(map2.get("DI-1#LGJGDYBJ"));
		switch_input_value.setI11(map2.get("DI-1#LGJGZ"));
		switch_input_value.setI12(map2.get("DI-1#LGJYX"));
		switch_input_value.setI13(map2.get("DI-2#FKDJ/LJ"));
		switch_input_value.setI14(map2.get("DI-2#KYJBD/YC"));
		switch_input_value.setI15(map2.get("DI-2#KYJBJGZ"));
		switch_input_value.setI16(map2.get("DI-2#KYJJX"));
		switch_input_value.setI17(map2.get("DI-2#KYJTJGZ"));
		switch_input_value.setI18(map2.get("DI-2#KYJYX"));
		switch_input_value.setI19(map2.get("DI-2#LGJGDYBJ"));
		switch_input_value.setI20(map2.get("DI-2#LGJGZ"));
		switch_input_value.setI21(map2.get("DI-2#LGJYX"));
		switch_input_value.setI22(map2.get("DI-3#FKDJ/LJ"));
		switch_input_value.setI23(map2.get("DI-3#KYJBD/YC"));
		switch_input_value.setI24(map2.get("DI-3#KYJBJGZ"));
		switch_input_value.setI25(map2.get("DI-3#KYJJX"));
		switch_input_value.setI26(map2.get("DI-3#KYJTJGZ"));
		switch_input_value.setI27(map2.get("DI-3#KYJYX"));
		switch_input_value.setI28(map2.get("DI-3#LGJGDYBJ"));
		switch_input_value.setI29(map2.get("DI-3#LGJGZ"));
		switch_input_value.setI30(map2.get("DI-3#LGJYX"));
		switch_input_value.setI31(map2.get("DI-2#KYJJZ/XZ"));
		switch_input_value.setI32(map2.get("DI-3#KYJJZ/XZ"));
		//switch_input 数据
		System.out.println(switch_input_value);
		DataMasterTable.getswitcInput(switch_input_value);*/
		
	
	}

	
	

}
