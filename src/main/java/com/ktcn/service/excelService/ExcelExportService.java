package com.ktcn.service.excelService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.siemensentity.ScrewMachine;

/**
 * 导出Excel业务层
 * @author Administrator
 *
 */
public interface ExcelExportService {

	/*
	 *  空压机历史数据导出
	 */
	HSSFWorkbook downloadExcelAir(ScrewMachine isEntity, String eqName, String time1, String time2);

	/*
	 * 干燥机历史数据导出
	 */
	HSSFWorkbook downloadExcelDry(ScrewMachine isEntity, String time1, String time2);

}
