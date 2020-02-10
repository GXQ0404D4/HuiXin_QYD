package com.ktcn.service.serviceImpl.reportServiceImpl.yearReport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.reportDao.yearReport.MainReportyDao;
import com.ktcn.entity.siemensentity.FlowGauge;
import com.ktcn.service.reportService.yearReport.MainReportyService;
import com.ktcn.utils.Export;
/*
 * 总管网日报表业务层实现类
 */
@Service
@Transactional
public class MainReportyServiceImpl implements MainReportyService {
	
	@Resource
	private MainReportyDao mainReportyDao;

	// 获取数据总条数
	@Override
	public int findTotal() {
		return mainReportyDao.findTotal();
	}

	// 获取查询数据
	@Override
	public List<FlowGauge> findAllByIndex(int x) {
		return mainReportyDao.findAllByIndex(x);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return mainReportyDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询离心机日报表信息
	@Override
	public List<FlowGauge> findByTime(String current_timeA, String current_timeB, int total) {
		return mainReportyDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(FlowGauge isEntity) {
		try {
			// 查询数据
			List<FlowGauge> query = mainReportyDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "时间");
			column.put("A2", "系统压力");
			column.put("A3", "瞬时流量");
			column.put("A4", "累计流量");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (FlowGauge vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getLLJ_datatime());
					hashMap.put("A2", vo.getLLJ4());
					hashMap.put("A3", vo.getLLJ2());
					hashMap.put("A4", vo.getLLJ3());

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
