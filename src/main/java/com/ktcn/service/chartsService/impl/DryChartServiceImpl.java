package com.ktcn.service.chartsService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.chartsDao.DryChartDao;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.service.chartsService.DryChartService;
/**
 * 干燥机折线图业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class DryChartServiceImpl implements DryChartService {
	
	@Resource
	private DryChartDao dryChartDao;

	/*
	 * 查询方法
	 */
	@Override
	public Map<String, Object> find() {
		// 创建返回map
		Map<String,Object> reMap = new HashMap<String,Object>();
		// 获取数据
		List<DryingMachine> list = dryChartDao.find();
		// 存入返回集合
		reMap.put("code", "1");
		reMap.put("message", "操作成功");
		reMap.put("list", list);
		
		return reMap;
	}
}
