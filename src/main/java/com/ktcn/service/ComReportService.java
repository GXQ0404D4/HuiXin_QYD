package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 空压机报表业务层
 */
public interface ComReportService {
	// 查询全部空压机报表信息
	List<Kyj_data_table> findAll();
	// 根据时间区间查询空压机报表信息
	List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB);
}
