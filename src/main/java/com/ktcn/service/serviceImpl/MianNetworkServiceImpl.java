package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MianNetworkDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.MianNetworkService;
import com.ktcn.utils.Export;

/*
 * 总管网报表业务层实现类
 */
@Service
@Transactional
public class MianNetworkServiceImpl implements MianNetworkService {
	@Resource
	private MianNetworkDao mianNetworkDao;

	// 查询数据总条数
	@Override
	public int findTotal() {
		return mianNetworkDao.findTotal();
	}

	// 分页查询-查询全部
	@Override
	public List<Kyj_data_table> findAllByIndex(int total) {
		return mianNetworkDao.findAllByIndex(total);
	}

	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return mianNetworkDao.findCountByTime(current_timeA, current_timeB);
	}

	// 根据时间区间查询空压机报表信息
	@Override
	public List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total) {
		return mianNetworkDao.findByTime(current_timeA, current_timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Kyj_data_table isEntity) {
		try {
			// 查询数据
			List<Kyj_data_table> query = mianNetworkDao.findExport();
			// 标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器");
			column.put("A2", "压力");
			column.put("A3", "露点");
			column.put("A4", "瞬时流量");
			column.put("A5", "累计流量");
			column.put("A6", "总功率");
			column.put("A7", "总电量");
			// excel内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {
				for (Kyj_data_table vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getMachine_name());
					hashMap.put("A2", vo.getPressure());
					hashMap.put("A3", vo.getDew_point_temperature());
					hashMap.put("A4", vo.getCompensated_flow());
					hashMap.put("A5", vo.getCumulative_flow());
					hashMap.put("A6", vo.getTotal_power());
					hashMap.put("A7", vo.getTotal_electricity());
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
