package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.DryingMachine;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:49:49
* 类说明  干燥机DAO层操作
*/
@Mapper
@Repository
public interface DryingMachine_dao {

	@Insert("INSERT INTO drying_machine VALUES(null,'',#{dMac.GZJ0},#{dMac.GZJ1},#{dMac.GZJ2},#{dMac.GZJ3},#{dMac.GZJ4},#{dMac.GZJ5},#{dMac.GZJ6},#{dMac.GZJ7},#{dMac.GZJ8},#{dMac.GZJ9},#{dMac.GZJ10},#{dMac.GZJ11},NOW(),NOW())")
	void setDryingMachineData(@Param("dMac") DryingMachine dMac);

	@Insert("INSERT INTO drying_machine_hour VALUES(null,'',#{dMac.GZJ0},#{dMac.GZJ1},#{dMac.GZJ2},#{dMac.GZJ3},#{dMac.GZJ4},#{dMac.GZJ5},#{dMac.GZJ6},#{dMac.GZJ7},#{dMac.GZJ8},#{dMac.GZJ9},#{dMac.GZJ10},#{dMac.GZJ11},NOW(),NOW())")
	void setDryingMachineDataHour(@Param("dMac") DryingMachine dMac);

}
