package com.ktcn.service.reportService.hourService;

import java.util.Map;

/**
 * 干燥机报表业务层
 * @author Administrator
 *
 */
public interface DryHService {

	/*
	 * 干燥机数据查询方法
	 */
	Map<String, Object> find(String pageSize, String time1, String time2);

}
