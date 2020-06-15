package com.ktcn.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.FaultRecordDao;
import com.ktcn.entity.Error_recording;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.FaultRecordService;
import com.ktcn.utils.PageReade;
/*
 * 故障记录业务层实现类
 */
@Service
@Transactional
public class FaultRecordServiceImpl implements FaultRecordService {
	@Resource
	private FaultRecordDao faultRecordDao;
	
	// 查看方法
	@Override
	public Map<String, Object> find(String pageSize, int sizeNum, String falut_summary, String timeA, String timeB) {
		// 判断如果pageSize为NULL则pageSize为0
		if (pageSize == null) {
			pageSize = "1";
		}
		if ("".equals(timeA) || timeA == null) {
			timeA = "1970-01-01";
		}
		if ("".equals(timeB) || timeB == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			timeB = format.format(new Date());
		}
		// 转换页数参数类型
		int i = Integer.parseInt(pageSize);
		// 获取查询起始条数
		int x = 0;
		// 查询数据总条数
		int count = 0;
		// 获取总页数
		int countPage = 0;
		
		// 查询数据总条数
		count = faultRecordDao.findTotal(falut_summary,timeA,timeB);
		// 获取总页数
		countPage = PageReade.getCountPage(count, sizeNum);
		// 获取查询起始条数
		x = PageReade.getPageSize(i, count, sizeNum);
		// 获取数据
		List<Error_recording> list = faultRecordDao.find(falut_summary,timeA,timeB,x,sizeNum);
		
		// 新建一个map集合承接返回数据
		Map<String,Object> reMap = new HashMap<String,Object>();
		reMap.put("code", "1");
		reMap.put("message", "操作成功");
		reMap.put("totalpage", countPage); // 总页数
		reMap.put("totalmess", count); // 总条数
		reMap.put("pageSize", PageReade.getPageNum(i, count, sizeNum)); // 当前页数
		reMap.put("data", list);
		
		return reMap;
	}

	// 新增故障记录
	@Override
	public void addFaultRecord(Map<String, String> map, Tb_user user) {
		map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		faultRecordDao.addFaultRecord(map,user);
	}
	// 删除故障记录
	@Override
	public void deleteFaultRecord(int id) {
		faultRecordDao.deleteFaultRecord(id);
	}
	// 修改故障记录
	@Override
	public void updateFaultRecord(Map<String, String> map, Tb_user user) {
		map.put("Repair_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		faultRecordDao.updateFaultRecord(map,user);
	}
}
