package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 总管网报表业务层
 */
public interface MianNetworkService {
	// 查询全部总管网信息
	List<Kyj_data_table> findAll();
	// 查询全部电量报表信息
	List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB);

}
