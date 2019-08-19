package com.ktcn.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.Compressor_report;

/*
 * 空压机报表业务层
 */
public interface ComReportService {
	// 查询全部空压机报表信息
	List<Compressor_report> findAll();
	// 根据时间区间查询空压机报表信息
	List<Compressor_report> findAllByTime(String current_timeA, String current_timeB);
	// 导出Excel
	HSSFWorkbook downloadExcel(Compressor_report isEntity);
}
