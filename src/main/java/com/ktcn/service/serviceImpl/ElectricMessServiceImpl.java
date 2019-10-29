package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ElectricMessDao;
import com.ktcn.entity.Electric_massage;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.ElectricMessService;
import com.ktcn.utils.Export;

/*
 * 电量报表业务实现层
 */
@Service
@Transactional
public class ElectricMessServiceImpl implements ElectricMessService {

	@Resource
	private ElectricMessDao electricMessDao;

	// 获取数据总条数
	@Override
	public int findTotal() {
		return electricMessDao.findTotal();
	}

	// 获取查询数据
	@Override
	public List<Kyj_data_table> findAllByIndex(int x) {
		return electricMessDao.findAllByIndex(x);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return electricMessDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询空压机报表信息
	@Override
	public List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total) {
		return electricMessDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Kyj_data_table isEntity) {
		try {
			// 查询数据
			List<Kyj_data_table> query = electricMessDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器");
			column.put("A2", "数据时间");
			column.put("A3", "电压");
			column.put("A4", "电流");
			column.put("A5", "瞬时功率");
			column.put("A6", "电量");
			column.put("A7", "功率因数");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (Kyj_data_table vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getMachine_name());
					hashMap.put("A2", vo.getCurrent_time());
					hashMap.put("A3", vo.getVoltage());
					hashMap.put("A4", vo.getElectric_current());
					hashMap.put("A5", vo.getInstantaneous_power());
					hashMap.put("A6", vo.getElectric());
					hashMap.put("A7", vo.getPower_factor());

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
