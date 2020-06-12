package com.ktcn.service.chartsService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.chartsDao.MeterChartDao;
import com.ktcn.entity.siemensentity.Peripheral_Data;
import com.ktcn.service.chartsService.MeterChartService;
/**
 * 外围仪表折线图业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class MeterChartServiceImpl implements MeterChartService {

	@Resource
	private MeterChartDao meterChartDao;

	/*
	 * 查询方法
	 */
	@Override
	public Map<String, Object> find() {
		// 创建返回map
		Map<String,Object> reMap = new HashMap<String,Object>();
		// 获取数据
		List<Peripheral_Data> list = meterChartDao.find();
		// 存入返回集合
		reMap.put("code", "1");
		reMap.put("message", "操作成功");
		reMap.put("list", list);
		
		return reMap;
	}
}
