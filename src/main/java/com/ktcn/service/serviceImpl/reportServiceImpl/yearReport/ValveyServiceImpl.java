package com.ktcn.service.serviceImpl.reportServiceImpl.yearReport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.reportDao.yearReport.ValveyDao;
import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.service.reportService.yearReport.ValveyService;
import com.ktcn.utils.Export;
/*
 * 螺杆机日报表业务层实现类
 */
@Service
@Transactional
public class ValveyServiceImpl implements ValveyService {
	
	@Resource
	private ValveyDao valveyDao;

	// 获取数据总条数
	@Override
	public int findTotal() {
		return valveyDao.findTotal();
	}

	// 获取查询数据
	@Override
	public List<ControlValue> findAllByIndex(int x) {
		return valveyDao.findAllByIndex(x);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return valveyDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询离心机日报表信息
	@Override
	public List<ControlValue> findByTime(String current_timeA, String current_timeB, int total) {
		return valveyDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(ControlValue isEntity) {
		try {
			// 查询数据
			List<ControlValue> query = valveyDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
//			column.put("A1", "机器");
			column.put("A2", "时间");
			column.put("A3", "上游压力");
			column.put("A4", "下游压力");
			column.put("A5", "累计流量");
			column.put("A6", "位置反馈");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (ControlValue vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
//					hashMap.put("A1", vo.getScrewMachine_name());
					hashMap.put("A2", vo.getTJF_datatime());
					hashMap.put("A3", vo.getTJF5());
					hashMap.put("A4", vo.getTJF6());
					hashMap.put("A5", vo.getTJF8());
					hashMap.put("A6", vo.getTJF9());

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
