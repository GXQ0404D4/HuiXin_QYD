package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ComReportDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.ComReportService;
import com.ktcn.utils.Export;

/*
 * 空压机报表业务层实现类
 */
@Service
@Transactional
public class ComReportServiceImpl implements ComReportService {
	@Resource
	private ComReportDao comReportDao;

	// 查询数据总条数
	@Override
	public int findTotal() {
		return comReportDao.findTotal();
	}

	// 分页查询-查询全部
	@Override
	public List<Kyj_data_table> findAllByIndex(int total) {
		return comReportDao.findAllByIndex(total);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return comReportDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询空压机报表信息
	@Override
	public List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total) {
		return comReportDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Kyj_data_table isEntity) {
		try {
			// 从数据库查询数据
			List<Kyj_data_table> query = comReportDao.findExport();
			// 定义标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器名称");
			column.put("A2", "数据时间");
			column.put("A3", "正向有功总电能");
			column.put("A4", "运行时间");
			column.put("A5", "有功功率");
			// 写入excel每行单元格内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (Kyj_data_table vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getMachine_name());
					hashMap.put("A2", vo.getCurrent_time());
					hashMap.put("A3", vo.getTotal_energy());
					hashMap.put("A4", vo.getRunning_time());
					hashMap.put("A5", vo.getActive_Service_Rate());
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
