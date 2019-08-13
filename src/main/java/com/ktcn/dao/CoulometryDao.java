package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.CoulometrySQL;
import com.ktcn.entity.Electric_massage;

/*
 * 电量权限分析持久层
 */
@Mapper
@Repository
public interface CoulometryDao {
	// 查询当天24小时的电量曲线信息
	@Select("SELECT * FROM `electric_massage` WHERE date(`electric_massage`.`current_time`) = curdate();")
	List<Electric_massage> findByNowDate();
	// 查询30天流量曲线
	@Select("SELECT * FROM `electric_massage` WHERE date_sub(curdate(), interval 30 day) <= date(`current_time`)")
	List<Electric_massage> findByNowMonth();
	// 根据机器查询30天流量曲线
	@Select("SELECT * FROM `electric_massage` WHERE date_sub(curdate(), interval 30 day) <= date(`current_time`) AND machine = #{machine}")
	List<Electric_massage> findByMachine(@Param("machine") String machine);
	// 按照时间区间查询
	@SelectProvider(method = "findByTime",type =CoulometrySQL.class)
	List<Electric_massage> findByTime(@Param("timeA") String timeA, @Param("timeB") String timeB);
	
}