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
import com.ktcn.entity.Peripheral_Alarm;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.siemensentity.Peripheral_entity;
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
	public HSSFWorkbook downloadExcelAir(String eqName, String time1, String time2) {
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
	public HSSFWorkbook downloadExcelDry(String time1, String time2) {
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

	/*
	 * 外围仪表历史数据导出
	 */
	@Override
	public HSSFWorkbook downloadExcelMeter(String time1, String time2) {
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
			List<Peripheral_entity> query = excelExportDao.downloadExcelMeter(time1,time2);
			
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "外供二冷压缩空气主管流量");
			column.put("A3", "外供二冷压缩空气主管压力");
			column.put("A4", "外供净化压缩空气主管压力");
			column.put("A5", "外供净化压缩空气主管流量");
			column.put("A6", "外供普通压缩空气主管压力");
			column.put("A7", "外供普通压缩空气主管流量");
			column.put("A8", "综合水处理器进出口压差");
			column.put("A9", "干燥机排气压力");
			column.put("A10", "干燥机进气压力");
			column.put("A11", "干燥机进气温度");
			column.put("A12", "干燥机排气温度");
			column.put("A13", "冷却水供水流量");
			column.put("A14", "冷却水供水温度");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {
				for (Peripheral_entity vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getPddatetime());
					hashMap.put("A2", vo.getWw27());
					hashMap.put("A3", vo.getWw44());
					hashMap.put("A4", vo.getWw30());
					hashMap.put("A5", vo.getWw21());
					hashMap.put("A6", vo.getWw37());
					hashMap.put("A7", vo.getWw24());
					hashMap.put("A8", vo.getWw51());
					hashMap.put("A9", vo.getWw65());
					hashMap.put("A10", vo.getWw58());
					hashMap.put("A11", vo.getWw72());
					hashMap.put("A12", vo.getWw79());
					hashMap.put("A13", vo.getWw0());
					hashMap.put("A14", vo.getWw14());

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

	// ----------------------- 分割线, 上面是历史数据模块, 下面是报表模块 ---------------------------------
	
	/*
	 * 空压机报表导出
	 */
	@Override
	public HSSFWorkbook downloadExcelAirh(String eqName, String time1, String time2) {
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
			List<ScrewMachine> query = excelExportDao.downloadExcelAirh(eqName,time1,time2);
			
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
	 * 干燥机报表导出
	 */
	@Override
	public HSSFWorkbook downloadExcelDryh(String time1, String time2) {
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
			List<DryingMachine> query = excelExportDao.downloadExcelDryh(time1,time2);
			
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

	/*
	 * 外围仪表报表导出
	 */
	@Override
	public HSSFWorkbook downloadExcelMeterh(String time1, String time2) {
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
			List<Peripheral_entity> query = excelExportDao.downloadExcelMeterh(time1,time2);
			
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "外供二冷压缩空气主管流量");
			column.put("A3", "外供二冷压缩空气主管压力");
			column.put("A4", "外供净化压缩空气主管压力");
			column.put("A5", "外供净化压缩空气主管流量");
			column.put("A6", "外供普通压缩空气主管压力");
			column.put("A7", "外供普通压缩空气主管流量");
			column.put("A8", "综合水处理器进出口压差");
			column.put("A9", "干燥机排气压力");
			column.put("A10", "干燥机进气压力");
			column.put("A11", "干燥机进气温度");
			column.put("A12", "干燥机排气温度");
			column.put("A13", "冷却水供水流量");
			column.put("A14", "冷却水供水温度");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {
				for (Peripheral_entity vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getPddatetime());
					hashMap.put("A2", vo.getWw27());
					hashMap.put("A3", vo.getWw44());
					hashMap.put("A4", vo.getWw30());
					hashMap.put("A5", vo.getWw21());
					hashMap.put("A6", vo.getWw37());
					hashMap.put("A7", vo.getWw24());
					hashMap.put("A8", vo.getWw51());
					hashMap.put("A9", vo.getWw65());
					hashMap.put("A10", vo.getWw58());
					hashMap.put("A11", vo.getWw72());
					hashMap.put("A12", vo.getWw79());
					hashMap.put("A13", vo.getWw0());
					hashMap.put("A14", vo.getWw14());

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

	// ----------------------- 分割线, 上面是报表模块, 下面是报警记录 ---------------------------------

	/*
	 * 空压机报警记录数据导出
	 */
	@Override
	public HSSFWorkbook downloadExcelAlAir(String eqName, String time1, String time2) {
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
			List<ScrewMachine> query = excelExportDao.downloadExcelAlAir(eqName,time1,time2);
			
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
			column.put("A10", "停机故障");
			column.put("A11", "停机报警");
			column.put("A12", "维护报警");
			column.put("A13", "综合报警");
			column.put("A14", "加卸载");
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
					hashMap.put("A10", ("0".equals(vo.getLGJ13().toString())?"正常":"报警"));
					hashMap.put("A11", ("0".equals(vo.getLGJ14().toString())?"正常":"报警"));
					hashMap.put("A12", ("0".equals(vo.getLGJ15().toString())?"正常":"报警"));
					hashMap.put("A13", ("0".equals(vo.getLGJ16().toString())?"正常":"报警"));
					hashMap.put("A14", ("0".equals(vo.getLGJ17().toString())?"加载":"卸载"));

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
	 * 干燥机报警记录数据导出
	 */
	@Override
	public HSSFWorkbook downloadExcelAlDry(String time1, String time2) {
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
			List<DryingMachine> query = excelExportDao.downloadExcelAlDry(time1,time2);
			
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "容器A压力");
			column.put("A3", "容器B压力");
			column.put("A4", "容器A底端温度");
			column.put("A5", "容器B底端温度");
			column.put("A6", "加热器出口温度");
			column.put("A7", "干燥器压力露点");
			column.put("A8", "运行状态");
			column.put("A9", "报警");
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
					hashMap.put("A8", ("0".equals(vo.getGZJ10().toString())?"运行":"停止"));
					hashMap.put("A9", ("0".equals(vo.getGZJ11().toString())?"正常":"报警"));

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
	 * 外围仪表报警记录数据导出
	 */
	@Override
	public HSSFWorkbook downloadExcelAlMeter(String eqName, String time1, String time2) {
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
			List<Peripheral_Alarm> query = excelExportDao.downloadExcelAlMeter(eqName,time1,time2);
			
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "名称");
			column.put("A3", "AI");
			column.put("A4", "DOWN");
			column.put("A5", "UP");
			column.put("A6", "LAMARM");
			column.put("A7", "HAMARM");
			column.put("A8", "L");
			column.put("A9", "H");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {
				for (Peripheral_Alarm vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getPdjdatetime());
					hashMap.put("A2", vo.getPdjname());
					hashMap.put("A3", vo.getPbj0());
					hashMap.put("A4", vo.getPbj1());
					hashMap.put("A5", vo.getPbj2());
					hashMap.put("A6", vo.getPbj3());
					hashMap.put("A7", vo.getPbj4());
					hashMap.put("A8", ("0".equals(vo.getPbj5().toString())?"正常":"报警"));
					hashMap.put("A9", ("0".equals(vo.getPbj6().toString())?"正常":"报警"));

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
