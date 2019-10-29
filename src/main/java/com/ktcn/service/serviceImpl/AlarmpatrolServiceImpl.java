package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.AlarmpatrolDao;
import com.ktcn.entity.Alarmpatrol;
import com.ktcn.service.AlarmpatrolService;
import com.ktcn.utils.Export;

/**
 * 报警巡查业务层实现类
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class AlarmpatrolServiceImpl implements AlarmpatrolService {
	@Resource
	private AlarmpatrolDao alarmpatrolDao;

	// 查询数据总条数
	public int findTotal() {
		return alarmpatrolDao.findTotal();
	}

	// 分页查询-查询全部
	public List<Alarmpatrol> findAllByIndex(int total) {
		return alarmpatrolDao.findAllByIndex(total);
	}

	// 时间区间查询总条数
	public int findCountByTime(String timeA, String timeB) {
		return alarmpatrolDao.findCountByTime(timeA, timeB);
	}

	// 根据时间区间查询空压机报表信息
	public List<Alarmpatrol> findByTime(String timeA, String timeB, int total) {
		return alarmpatrolDao.findByTime(timeA, timeB, total);
	}

	/**
	 * 导出excel
	 * 
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Alarmpatrol isEntity) {
		try {
			// 从数据库查询数据
			List<Alarmpatrol> query = alarmpatrolDao.findExport();
			// 定义标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1", "机器名称");
			column.put("A2", "点位名");
			column.put("A3", "点位描述");
			column.put("A4", "实测值");
			column.put("A5", "上限差值");
			column.put("A6", "下限差值");
			column.put("A7", "报警时间");
			// 写入excel每行单元格内容
			List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
			if (query != null && !query.isEmpty()) {

				for (Alarmpatrol vo : query) {
					Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
					hashMap.put("A1", vo.getMachine_name());
					hashMap.put("A2", vo.getAp_name());
					hashMap.put("A3", vo.getDescribe());
					hashMap.put("A4", vo.getMeasured_value());
					hashMap.put("A5", vo.getUpDiff());
					hashMap.put("A6", vo.getLowDiff());
					hashMap.put("A7", vo.getAp_time());
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
