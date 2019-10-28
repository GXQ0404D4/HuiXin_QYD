package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.ElectricSQL;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 电量报表持久化层
 */
@Mapper
@Repository
public interface ElectricMessDao {
	// 查询全部电量报表信息
	@Select("SELECT * FROM kyj_data_table ORDER BY `current_time` DESC limit 0,50")
	List<Kyj_data_table> findAll();
	// 根据时间区间查询电量报表信息
	@SelectProvider(method = "findAllByTime", type = ElectricSQL.class)
	List<Kyj_data_table> findAllByTime(@Param("current_timeA") String current_timeA, @Param("current_timeB")String current_timeB);
	
}
