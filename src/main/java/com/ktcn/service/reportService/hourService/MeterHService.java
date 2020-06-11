package com.ktcn.service.reportService.hourService;

import java.util.Map;

/**
 * 外围仪表报表业务层
 * @author Administrator
 *
 */
public interface MeterHService {

	/*
	 * 外围仪表报表查询方法
	 */
	Map<String, Object> find(String pageSize, String time1, String time2);

}
