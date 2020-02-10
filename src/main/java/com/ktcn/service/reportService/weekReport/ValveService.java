package com.ktcn.service.reportService.weekReport;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.siemensentity.ControlValue;

/*
 * 调节阀日报表业务层
 */
public interface ValveService {

	// 获取数据总条数
	int findTotal();
	// 获取查询数据
	List<ControlValue> findAllByIndex(int x);

	// 时间区间查询总条数
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询调节阀日报表信息
	List<ControlValue> findByTime(String current_timeA, String current_timeB,int total);
	
	// 导出Excel
	HSSFWorkbook downloadExcel(ControlValue isEntity);
}
