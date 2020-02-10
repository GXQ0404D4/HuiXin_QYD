package com.ktcn.service.serviceImpl.reportServiceImpl.yearReport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.reportDao.yearReport.ElectricReportyDao;
import com.ktcn.entity.siemensentity.Ammeter;
import com.ktcn.service.reportService.yearReport.ElectricReportyService;
import com.ktcn.utils.Export;
/*
 * 电量日报表业务层实现类
 */
@Service
@Transactional
public class ElectricReportyServiceImpl implements ElectricReportyService {
	
	@Resource
	private ElectricReportyDao electricReportyDao;

	// 获取数据总条数
	@Override
	public int findTotal() {
		return electricReportyDao.findTotal();
	}

	// 获取查询数据
	@Override
	public List<Ammeter> findAllByIndex(int x) {
		return electricReportyDao.findAllByIndex(x);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return electricReportyDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询离心机日报表信息
	@Override
	public List<Ammeter> findByTime(String current_timeA, String current_timeB, int total) {
		return electricReportyDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Ammeter isEntity) {
		try {
			// 查询数据
			List<Ammeter> query = electricReportyDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器");
			column.put("A2", "时间");
			column.put("A3", "正向有功功率");
			column.put("A4", "正向电能");
			column.put("A5", "A向电流");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (Ammeter vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getAmmeter_name());
					hashMap.put("A2", vo.getDB_datatime());
					hashMap.put("A3", vo.getDB6());
					hashMap.put("A4", vo.getDB9());
					hashMap.put("A5", vo.getDB3());

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
