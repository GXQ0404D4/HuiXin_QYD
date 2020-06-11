package com.ktcn.service.excelService.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.excelExportDao.ExcelExportDao;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.excelService.ExcelExportService;
import com.ktcn.utils.Export;
/**
 * 导出Excel业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class ExcelExportServiceImpl implements ExcelExportService {
	
	@Resource
	private ExcelExportDao excelExportDao;

	/*
	 *  空压机历史数据导出
	 */
	@Override
	public HSSFWorkbook downloadExcelAir(ScrewMachine isEntity, String eqName, String time1, String time2) {
		// 初始化数据
		if ("".equals(time1) || time1 == null) {
			time1 = "1970-01-01";
		}
		if ("".equals(time2) || time2 == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			time2 = format.format(new Date());
		}
		try {
			// 获取数据
			List<ScrewMachine> query = excelExportDao.downloadExcelAir(eqName,time1,time2);
			
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "设备名称");
			column.put("A3", "主机1出口温度");
			column.put("A4", "空压机出口温度");
			column.put("A5", "主机1喷油压力");
			column.put("A6", "冷却水出口温度");
			column.put("A7", "压缩机出口压力");
			column.put("A8", "油分离器1压差");
			column.put("A9", "空气过滤器差");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {
				for (ScrewMachine vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getLGJ_datatime());
					hashMap.put("A2", vo.getScrewMachine_name());
					hashMap.put("A3", vo.getLGJ5());
					hashMap.put("A4", vo.getLGJ4());
					hashMap.put("A5", vo.getLGJ2());
					hashMap.put("A6", vo.getLGJ6());
					hashMap.put("A7", vo.getLGJ0());
					hashMap.put("A8", vo.getLGJ3());
					hashMap.put("A9", vo.getLGJ1());

					listResult.add(hashMap);
				}
			}

			// 去调用工具类的方法
			HSSFWorkbook wb = Export.getHSSFWorkbook(listResult, column);
			return wb;
		} catch (Exception e) {
			// TODO处理异常
		}
		return null;
	}

	/*
	 * 干燥机历史数据导出
	 */
	@Override
	public HSSFWorkbook downloadExcelDry(ScrewMachine isEntity, String time1, String time2) {
		// 初始化数据
		if ("".equals(time1) || time1 == null) {
			time1 = "1970-01-01";
		}
		if ("".equals(time2) || time2 == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			time2 = format.format(new Date());
		}
		try {
			// 获取数据
			List<DryingMachine> query = excelExportDao.downloadExcelDry(time1,time2);
			
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "容器A压力");
			column.put("A3", "容器B压力");
			column.put("A4", "容器A底端温度");
			column.put("A5", "容器B底端温度");
			column.put("A6", "加热器出口温度");
			column.put("A7", "干燥器压力露点");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {
				for (DryingMachine vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getGZ_datatime());
					hashMap.put("A2", vo.getGZJ0());
					hashMap.put("A3", vo.getGZJ1());
					hashMap.put("A4", vo.getGZJ3());
					hashMap.put("A5", vo.getGZJ4());
					hashMap.put("A6", vo.getGZJ2());
					hashMap.put("A7", vo.getGZJ5());

					listResult.add(hashMap);
				}
			}

			// 去调用工具类的方法
			HSSFWorkbook wb = Export.getHSSFWorkbook(listResult, column);
			return wb;
		} catch (Exception e) {
			// TODO处理异常
		}
		return null;
	}

}
