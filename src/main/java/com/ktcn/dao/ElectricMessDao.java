package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.ElectricSQL;
import com.ktcn.entity.Electric_massage;

/*
 * 电量报表持久化层
 */
@Mapper
@Repository
public interface ElectricMessDao {
	// 查询全部电量报表信息
	@Select("SELECT * FROM electric_massage ORDER BY `current_time` DESC")
	List<Electric_massage> findAll();
	// 根据时间区间查询电量报表信息
//	@Select("SELECT * FROM electric_massage WHERE `current_time` BETWEEN '${current_timeA}' AND '${current_timeB}'")
	@SelectProvider(method = "findAllByTime", type = ElectricSQL.class)
	List<Electric_massage> findAllByTime(@Param("current_timeA") String current_timeA, @Param("current_timeB")String current_timeB);
	
}
