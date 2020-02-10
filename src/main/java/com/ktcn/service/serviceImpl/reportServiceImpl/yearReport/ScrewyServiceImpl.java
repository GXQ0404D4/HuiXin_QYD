package com.ktcn.service.serviceImpl.reportServiceImpl.yearReport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.reportDao.yearReport.ScrewyDao;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.reportService.yearReport.ScrewyService;
import com.ktcn.utils.Export;
/*
 * 螺杆机日报表业务层实现类
 */
@Service
@Transactional
public class ScrewyServiceImpl implements ScrewyService {
	
	@Resource
	private ScrewyDao screwyDao;

	// 获取数据总条数
	@Override
	public int findTotal() {
		return screwyDao.findTotal();
	}

	// 获取查询数据
	@Override
	public List<ScrewMachine> findAllByIndex(int x) {
		return screwyDao.findAllByIndex(x);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return screwyDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询离心机日报表信息
	@Override
	public List<ScrewMachine> findByTime(String current_timeA, String current_timeB, int total) {
		return screwyDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(ScrewMachine isEntity) {
		try {
			// 查询数据
			List<ScrewMachine> query = screwyDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器名");
			column.put("A2", "时间");
			column.put("A3", "运行状态");
			column.put("A4", "排气温度");
			column.put("A5", "排气压力");
			column.put("A6", "运行频率");
			column.put("A7", "运行时间");
			column.put("A8", "加载时间");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (ScrewMachine vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getScrewMachine_name());
					hashMap.put("A2", vo.getLGJ_datatime());
					hashMap.put("A3", vo.getLGJ1());
					hashMap.put("A4", vo.getLGJ4());
					hashMap.put("A5", vo.getLGJ3());
					hashMap.put("A6", vo.getLGJ25());
					hashMap.put("A7", vo.getLGJ14());
					hashMap.put("A8", vo.getLGJ15());

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
