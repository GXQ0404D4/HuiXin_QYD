package com.ktcn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Data_master_table;
import com.ktcn.entity.Switch_input_value;
import com.ktcn.entity.Switch_output_value;

/**
 *历史数据持久层
 *
 */

@Mapper
@Repository
@ComponentScan(basePackages ="com.ktcn.dao.DataMasterTable")
public interface DataMasterTable {
    /*data_master_table 数据主表信息存入 */
	void OpcDataMasterInsert(Data_master_table data_master_table);
	
	/*realtimedata 实时数据库修改*/
	//@Update(" UPDATE real_time_data  SET VoltageA_1 = #{data_master_table.VoltageA_1} WHERE dmt_id=1")
	void UpdateRealTime(Data_master_table data_master_table);
	
	
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
	/*@Update("UPDATE switch_input SET switch_input_data = CASE  input_id "
			+ "WHEN 1 THEN #{switch2.i1} WHEN 2 THEN #{switch2.i2} WHEN 3 THEN #{switch2.i3}  WHEN 4 THEN #{switch2.i4}"
			+ "WHEN 5 THEN #{switch2.i5} WHEN 6 THEN #{switch2.i6} WHEN 7 THEN #{switch2.i7} WHEN 8 THEN #{switch2.i8}"
			+ "WHEN 9 THEN #{switch2.i9} WHEN 10 THEN #{switch2.i10} WHEN 11 THEN #{switch2.i11} WHEN 12 THEN #{switch2.i12}"
			+ "WHEN 13 THEN #{switch2.i13} WHEN 14 THEN #{switch2.i14} WHEN 15 THEN #{switch2.i15} WHEN 16 THEN #{switch2.i16}"
			+ "WHEN 17 THEN #{switch2.i17} WHEN 18 THEN #{switch2.i18} WHEN 19 THEN #{switch2.i19} WHEN 20 THEN #{switch2.i20}"
			+ "WHEN 21 THEN #{switch2.i21} WHEN 22 THEN #{switch2.i22} WHEN 23 THEN #{switch2.i23} WHEN 24 THEN #{switch2.i24}"
			+ "WHEN 25 THEN #{switch2.i25} WHEN 26 THEN #{switch2.i26} WHEN 27 THEN #{switch2.i27} WHEN 28 THEN #{switch2.i28}"
			+ "WHEN 29 THEN #{switch2.i29} WHEN 30 THEN #{switch2.i30}"
			+ "WHEN 31 THEN #{switch2.i31} WHEN 32 THEN #{switch2.i32}"
			+ "END WHERE input_id IN (1,2,3,4)")*/
	@Update("UPDATE switch_input SET switch_input_data = CASE  input_id "
			+ "WHEN 1 THEN #{switch2.i1} WHEN 2 THEN #{switch2.i2} WHEN 3 THEN #{switch2.i3} WHEN 4 THEN #{switch2.i4} WHEN 5 THEN #{switch2.i5} "
			+ "WHEN 6 THEN #{switch2.i6} WHEN 7 THEN #{switch2.i7} WHEN 8 THEN #{switch2.i8} WHEN 9 THEN #{switch2.i9} WHEN 10 THEN #{switch2.i10} "
			+ "WHEN 11 THEN #{switch2.i11} WHEN 12 THEN #{switch2.i12} WHEN 13 THEN #{switch2.i13} WHEN 14 THEN #{switch2.i14} WHEN 15 THEN #{switch2.i15} "
			+ "WHEN 16 THEN #{switch2.i16} WHEN 17 THEN #{switch2.i17} WHEN 18 THEN #{switch2.i18} WHEN 19 THEN #{switch2.i19} WHEN 20 THEN #{switch2.i20} "
			+ "WHEN 21 THEN #{switch2.i21} WHEN 22 THEN #{switch2.i22} WHEN 23 THEN #{switch2.i23} WHEN 24 THEN #{switch2.i24} WHEN 25 THEN #{switch2.i25} "
			+ "WHEN 26 THEN #{switch2.i26} WHEN 27 THEN #{switch2.i27} WHEN 28 THEN #{switch2.i28} WHEN 29 THEN #{switch2.i29} WHEN 30 THEN #{switch2.i30} "
			+ "WHEN 31 THEN #{switch2.i31} WHEN 32 THEN #{switch2.i32} WHEN 33 THEN #{switch2.i33} "
			+ "END WHERE input_id IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33)")
	void getswitcInput(@Param("switch2") Switch_input_value switch2);



	
	

}
