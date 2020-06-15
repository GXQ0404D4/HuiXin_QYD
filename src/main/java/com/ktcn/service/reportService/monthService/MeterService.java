package com.ktcn.service.reportService.monthService;

import java.util.Map;

/**
 * 外围仪表历史数据业务层
 * @author Administrator
 *
 */
public interface MeterService {

	/*
	 * 外围仪表数据查询方法
	 */
	Map<String, Object> find(String pageSize, int sizeNum, String time1, String time2);

}
