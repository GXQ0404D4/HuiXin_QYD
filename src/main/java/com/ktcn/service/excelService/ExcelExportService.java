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

}
