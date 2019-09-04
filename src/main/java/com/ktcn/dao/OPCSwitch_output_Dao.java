package com.ktcn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Switch_output;
import com.ktcn.entity.Switch_output_value;

/**
* @Title: OPCSwitch_output_Dao.java
* @Package com.ktcn.dao
* @Description: TODO OPCSwitch_output_Dao
* @author GXQ
* @date 2019年9月2日
* @version V1.0
*/
@Mapper
@Repository
public interface OPCSwitch_output_Dao {
 
	//void OPCswitch_output_update(Map<String, Boolean> map2);
    
	//@Select("SELECT * FROM switch_output where output_id in(#{l1},#{l2},#{l3})")
	//List<Switch_output> getswitch(@Param("l1") long l1,@Param("l2") long l2,@Param("l3") long l3);
    
	@Update("UPDATE switch_output SET switch_ouput_data = CASE  output_id "
			+ "WHEN 1 THEN #{switch1.s1} WHEN 2 THEN #{switch1.s2} WHEN 3 THEN #{switch1.s3} "
			+ "WHEN 4 THEN #{switch1.s4} WHEN 5 THEN #{switch1.s5} WHEN 6 THEN #{switch1.s6} "
			+ "WHEN 7 THEN #{switch1.s7} WHEN 8 THEN #{switch1.s8} WHEN 9 THEN #{switch1.s9} "			
			+ "WHEN 10 THEN #{switch1.s10} WHEN 11 THEN #{switch1.s11} WHEN 12 THEN #{switch1.s12} "			
			+ "END WHERE output_id IN (1,2,3,4,5,6,7,8,9,10,11,12)")
	void getswitch(@Param("switch1") Switch_output_value switch1);

}
