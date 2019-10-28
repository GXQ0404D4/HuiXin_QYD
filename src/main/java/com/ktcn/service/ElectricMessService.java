package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 电量报表业务接口层
 */
public interface ElectricMessService {

	// 查询全部电量报表信息
	List<Kyj_data_table> findAll();
	// 根据时间区间查询电量报表信息
	List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB);

}
