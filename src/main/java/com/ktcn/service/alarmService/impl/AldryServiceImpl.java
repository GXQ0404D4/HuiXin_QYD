package com.ktcn.service.alarmService.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.alarmDao.AldryDao;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.service.alarmService.AldryService;
import com.ktcn.utils.PageReade;
/**
 * 干燥机报警记录业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class AldryServiceImpl implements AldryService {

	@Resource
	private AldryDao aldryDao;

	/*
	 * 查询方法
	 */
	@Override
	public Map<String, Object> find(String pageSize, int sizeNum, String time1, String time2) {
		// 判断如果pageSize为NULL则pageSize为0
		if (pageSize == null) {
			pageSize = "1";
		}
		if ("".equals(time1) || time1 == null) {
			time1 = "1970-01-01";
		}
		if ("".equals(time2) || time2 == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			time2 = format.format(new Date());
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
		count = aldryDao.findTotal(time1,time2);
		// 获取总页数
		countPage = PageReade.getCountPage(count, sizeNum);
		// 获取查询起始条数
		x = PageReade.getPageSize(i, count, sizeNum);
		// 获取数据
		List<DryingMachine> list = aldryDao.find(time1,time2,x,sizeNum);
		
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
}
