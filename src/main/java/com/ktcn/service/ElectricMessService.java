package com.ktcn.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 电量报表业务接口层
 */
public interface ElectricMessService {
	
	// 获取数据总条数
	int findTotal();
	// 获取查询数据
	List<Kyj_data_table> findAllByIndex(int x);

	// 时间区间查询总条数
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询空压机报表信息
	List<Kyj_data_table> findByTime(String current_timeA, String current_timeB,int total);
	
	// 导出Excel
	HSSFWorkbook downloadExcel(Kyj_data_table isEntity);
}
