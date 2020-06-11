package com.ktcn.service.reportService.monthService;

import java.util.Map;

/**
 * 空压机历史数据业务层
 * @author Administrator
 *
 */
public interface AirService {
	/*
	 * 空压机数据查询方法
	 */
	Map<String, Object> find(String pageSize, String eqName, String time1, String time2);

}
