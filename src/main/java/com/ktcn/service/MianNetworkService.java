package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 总管网报表业务层
 */
public interface MianNetworkService {

	// 查询数据总条数
	int findTotal();
	// 分页查询-查询全部
	List<Kyj_data_table> findAllByIndex(int total);
	
	// 时间区间查询总条数
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询空压机报表信息
	List<Kyj_data_table> findByTime(String current_timeA, String current_timeB,int total);
}
