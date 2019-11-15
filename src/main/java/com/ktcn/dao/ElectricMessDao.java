package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
	
	// 获取数据总条数
	@Select("SELECT COUNT(id) FROM kyj_data_hour")
	int findTotal();
	// 获取查询数据
	@Select("SELECT * FROM kyj_data_hour ORDER BY `current_time` DESC limit #{total},10")
	List<Kyj_data_table> findAllByIndex(int x);
	
	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = ElectricSQL.class)
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询空压机报表信息
	@SelectProvider(method = "findByTime", type = ElectricSQL.class)
	List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total);
	
	// 导出Excel
	@Select("SELECT * FROM kyj_data_hour LIMIT 0,10000")
	List<Kyj_data_table> findExport();
}
