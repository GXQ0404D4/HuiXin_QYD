package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.ComReportSQL;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 总管网报表持久层
 */
@Mapper
@Repository
public interface MianNetworkDao {
	
	// 查询数据总条数
	@Select("SELECT COUNT(id) FROM kyj_data_table")
	int findTotal();
	// 分页查询-查询全部
	@Select("SELECT * FROM kyj_data_table ORDER BY `current_time` DESC limit #{total},10")
	List<Kyj_data_table> findAllByIndex(@Param("total") int total);
	
	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = ComReportSQL.class)
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询空压机报表信息
	@SelectProvider(method = "findByTime", type = ComReportSQL.class)
	List<Kyj_data_table> findByTime(String current_timeA, String current_timeB,int total);
	
	// 导出Excel
	@Select("SELECT * FROM kyj_data_table LIMIT 0,10000")
	List<Kyj_data_table> findExport();
}
