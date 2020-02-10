package com.ktcn.service.reportService.yearReport;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.siemensentity.FlowGauge;

/*
 * 总管网日报表业务层
 */
public interface MainReportyService {

	// 获取数据总条数
	int findTotal();
	// 获取查询数据
	List<FlowGauge> findAllByIndex(int x);

	// 时间区间查询总条数
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询总管网日报表信息
	List<FlowGauge> findByTime(String current_timeA, String current_timeB,int total);
	
	// 导出Excel
	HSSFWorkbook downloadExcel(FlowGauge isEntity);
}
