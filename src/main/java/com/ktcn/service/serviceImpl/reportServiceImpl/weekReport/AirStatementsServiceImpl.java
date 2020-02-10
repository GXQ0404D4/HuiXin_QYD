package com.ktcn.service.serviceImpl.reportServiceImpl.weekReport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.reportDao.weekReport.AirStatementsDao;
import com.ktcn.entity.siemensentity.CentriFuge;
import com.ktcn.service.reportService.weekReport.AirStatementsService;
import com.ktcn.utils.Export;
/*
 * 离心机日报表业务层实现类
 */
@Service
@Transactional
public class AirStatementsServiceImpl implements AirStatementsService {
	
	@Resource
	private AirStatementsDao airStatementsDao;

	// 获取数据总条数
	@Override
	public int findTotal() {
		return airStatementsDao.findTotal();
	}

	// 获取查询数据
	@Override
	public List<CentriFuge> findAllByIndex(int x) {
		return airStatementsDao.findAllByIndex(x);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return airStatementsDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询离心机日报表信息
	@Override
	public List<CentriFuge> findByTime(String current_timeA, String current_timeB, int total) {
		return airStatementsDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(CentriFuge isEntity) {
		try {
			// 查询数据
			List<CentriFuge> query = airStatementsDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器名称");
			column.put("A2", "时间");
			column.put("A3", "排气温度");
			column.put("A4", "排气压力");
			column.put("A5", "运行状态");
			column.put("A6", "IGV开度");
			column.put("A7", "BOV开度");
			column.put("A8", "轴承温度");
			column.put("A9", "润滑油油温");
			column.put("A10", "一级振动");
			column.put("A11", "二级振动");
			column.put("A12", "三级振动");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (CentriFuge vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getCentrifuge_name());
					hashMap.put("A2", vo.getLXJ_datatime());
					hashMap.put("A3", vo.getLXJ4());
					hashMap.put("A4", vo.getLXJ3());
					hashMap.put("A5", vo.getState());
					hashMap.put("A6", vo.getLXJ8());
					hashMap.put("A7", vo.getLXJ9());
					hashMap.put("A8", vo.getLXJ12());
					hashMap.put("A9", vo.getLXJ16());
					hashMap.put("A10", vo.getLXJ17());
					hashMap.put("A11", vo.getLXJ18());
					hashMap.put("A12", vo.getLXJ19());

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
