package com.ktcn.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.Compressor_report;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/*
 * 空压机报表业务层
 */
public interface ComReportService {

	// 查询数据总条数
	int findTotal();

	// 分页查询-查询全部
	List<Kyj_data_table> findAllByIndex(int total);

	// 时间区间查询总条数
	int findCountByTime(String current_timeA, String current_timeB);

	// 根据时间区间查询空压机报表信息
	List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total);

	// 导出Excel
	HSSFWorkbook downloadExcel(Compressor_report isEntity);
}
