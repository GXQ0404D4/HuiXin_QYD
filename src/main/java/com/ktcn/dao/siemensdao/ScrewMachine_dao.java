package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ScrewMachine;

import lombok.EqualsAndHashCode.Include;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:50:26
* 类说明  空压机DAO层操作
*/

@Mapper
@Repository
public interface ScrewMachine_dao {

	
	@Insert("INSERT INTO screw_machine VALUES(null,#{sMC.ScrewMachine_name},#{sMC.LGJ0},#{sMC.LGJ1},#{sMC.LGJ2},#{sMC.LGJ3},#{sMC.LGJ4},#{sMC.LGJ5}"
			+ ",#{sMC.LGJ6},#{sMC.LGJ7},#{sMC.LGJ8},#{sMC.LGJ9},#{sMC.LGJ10},#{sMC.LGJ11},#{sMC.LGJ12},#{sMC.LGJ13},#{sMC.LGJ14},#{sMC.LGJ15}"
			+ ",#{sMC.LGJ16},#{sMC.LGJ17},#{sMC.LGJ18},#{sMC.LGJ19},#{sMC.LGJ20},#{sMC.LGJ21},NOW(),NOW(),#{sMC.state})")
	void setScrewMachineData(@Param("sMC") ScrewMachine sMC);
	
	@Insert("INSERT INTO screw_machine_hour VALUES(null,#{sMC.ScrewMachine_name},#{sMC.LGJ0},#{sMC.LGJ1},#{sMC.LGJ2},#{sMC.LGJ3},#{sMC.LGJ4},#{sMC.LGJ5}"
			+ ",#{sMC.LGJ6},#{sMC.LGJ7},#{sMC.LGJ8},#{sMC.LGJ9},#{sMC.LGJ10},#{sMC.LGJ11},#{sMC.LGJ12},#{sMC.LGJ13},#{sMC.LGJ14},#{sMC.LGJ15}"
			+ ",#{sMC.LGJ16},#{sMC.LGJ17},#{sMC.LGJ18},#{sMC.LGJ19},#{sMC.LGJ20},#{sMC.LGJ21},NOW(),NOW(),#{sMC.state})")
	void setScrewMachineDataHour(@Param("sMC") ScrewMachine sMC);

}
