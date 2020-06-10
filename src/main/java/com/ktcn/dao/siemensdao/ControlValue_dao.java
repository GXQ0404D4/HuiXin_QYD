package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ControlValue;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:50:10
* 类说明   调节阀 DAO层操作
*/

@Mapper
@Repository
public interface ControlValue_dao {

	@Insert("insert INTO control_valve VALUES (null,#{cValue.TJF0},#{cValue.TJF1},#{cValue.TJF2},#{cValue.TJF3},#{cValue.TJF4},#{cValue.TJF5},#{cValue.TJF6},#{cValue.TJF7},NOW(),NOW(),1)")
	void setControlValueData(@Param("cValue")ControlValue cValue);
    @Insert("insert INTO control_valve_hour VALUES (null,#{cValue.TJF0},#{cValue.TJF1},#{cValue.TJF2},#{cValue.TJF3},#{cValue.TJF4},#{cValue.TJF5},#{cValue.TJF6},#{cValue.TJF7},NOW(),NOW(),1)")
	void setControlValueDataHour(@Param("cValue") ControlValue cValue);

}
