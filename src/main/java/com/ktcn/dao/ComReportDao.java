package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.ComReportSQL;
import com.ktcn.entity.Compressor_report;

/*
 * 空压机报表持久层
 */
@Mapper
@Repository
public interface ComReportDao {
	// 查询全部空压机报表信息
	@Select("SELECT * FROM compressor_report ORDER BY Air_current_time DESC limit 0,50")
	List<Compressor_report> findAll();
	// 根据时间区间查询空压机报表信息
	@SelectProvider(method = "findAllByTime", type = ComReportSQL.class)
	List<Compressor_report> findAllByTime(String current_timeA, String current_timeB);
	
}
