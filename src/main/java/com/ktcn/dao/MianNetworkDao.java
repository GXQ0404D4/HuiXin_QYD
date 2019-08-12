package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.MianNetworkSQL;
import com.ktcn.entity.Mian_network;

/*
 * 总管网报表持久层
 */
@Mapper
@Repository
public interface MianNetworkDao {
	// 查询全部总管网信息
	@Select("SELECT * FROM mian_network ORDER BY `current_time` DESC")
	List<Mian_network> findAll();
	// 查询全部电量报表信息
	@SelectProvider(method = "findAllByTime", type = MianNetworkSQL.class)
	List<Mian_network> findAllByTime(String current_timeA, String current_timeB);
	
}
