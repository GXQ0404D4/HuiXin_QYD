package com.ktcn.service.reportService.monthService;

import java.util.Map;

/**
 * 干燥机历史数据业务层
 * @author Administrator
 *
 */
public interface DryService {

	/*
	 * 干燥机数据查询方法
	 */
	Map<String, Object> find(String pageSize, String time1, String time2);

}
