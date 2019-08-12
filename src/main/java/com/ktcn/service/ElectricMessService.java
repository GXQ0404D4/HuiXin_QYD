package com.ktcn.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.Electric_massage;

/*
 * 电量报表业务接口层
 */
public interface ElectricMessService {

	// 查询全部电量报表信息
	List<Electric_massage> findAll();
	// 根据时间区间查询电量报表信息
	List<Electric_massage> findAllByTime(String current_timeA, String current_timeB);
	// 导出Excel
	HSSFWorkbook downloadExcel(Electric_massage isEntity);

}
