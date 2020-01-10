package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ControlValve;


/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:23:14
* 类说明
*/
@Mapper
@Repository
public interface ControlValveDao {
	
	//持久化到调节阀数据表
	@Insert("INSERT INTO control_valve (TJF0,TJF1,TJF2,TJF3,TJF4,TJF5,TJF6,TJF9,TJF_time,TJF_datatime,state) VALUES"
			+ "(#{cnt.TJF0},#{cnt.TJF1},#{cnt.TJF2},#{cnt.TJF3},#{cnt.TJF4},#{cnt.TJF5},#{cnt.TJF6},#{cnt.TJF9},NOW(),NOW(),1)")
	void setControlValueData(@Param("cnt") ControlValve cnt);

	
}
