package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.MianNetworkSQL;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 总管网报表持久层
 */
@Mapper
@Repository
public interface MianNetworkDao {
	// 查询全部总管网信息
	@Select("SELECT * FROM kyj_data_table ORDER BY `current_time` DESC limit 0,50")
	List<Kyj_data_table> findAll();
	// 查询全部电量报表信息
	@SelectProvider(method = "findAllByTime", type = MianNetworkSQL.class)
	List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB);
	
}
