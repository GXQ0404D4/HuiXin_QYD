package com.ktcn.service.reportService.yearReport;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.siemensentity.Ammeter;

/*
 * 电量日报表业务层
 */
public interface ElectricReportyService {

	// 获取数据总条数
	int findTotal();
	// 获取查询数据
	List<Ammeter> findAllByIndex(int x);

	// 时间区间查询总条数
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询电量日报表信息
	List<Ammeter> findByTime(String current_timeA, String current_timeB,int total);
	
	// 导出Excel
	HSSFWorkbook downloadExcel(Ammeter isEntity);
}
