package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.ComReportSQL;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 空压机报表持久层
 */
@Mapper
@Repository
public interface ComReportDao {
	// 查询全部空压机报表信息
	@Select("SELECT * FROM kyj_data_table ORDER BY `current_time` DESC limit 0,50")
	List<Kyj_data_table> findAll();
	// 根据时间区间查询空压机报表信息
	@SelectProvider(method = "findAllByTime", type = ComReportSQL.class)
	List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB);
	
}
