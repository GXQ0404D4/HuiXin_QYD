package com.ktcn.service.excelService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 导出Excel业务层
 * @author Administrator
 *
 */
public interface ExcelExportService {

	/*
	 *  空压机历史数据导出
	 */
	HSSFWorkbook downloadExcelAir(String eqName, String time1, String time2);

	/*
	 * 干燥机历史数据导出
	 */
	HSSFWorkbook downloadExcelDry(String time1, String time2);

	/*
	 * 外围仪表历史数据导出
	 */
	HSSFWorkbook downloadExcelMeter(String time1, String time2);

	// ----------------------- 分割线, 上面是历史数据模块, 下面是报表模块 ---------------------------------

	/*
	 * 空压机报表导出
	 */
	HSSFWorkbook downloadExcelAirh(String eqName, String time1, String time2);
	
	/*
	 * 干燥机报表导出
	 */
	HSSFWorkbook downloadExcelDryh(String time1, String time2);

	/*
	 * 外围仪表报表导出
	 */
	HSSFWorkbook downloadExcelMeterh(String time1, String time2);

}
