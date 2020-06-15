package com.ktcn.service.reportService.hourService;

import java.util.Map;

/**
 * 空压机报表业务层
 * @author Administrator
 *
 */
public interface AirHService {

	/*
	 * 空压机报表查询方法
	 */
	Map<String, Object> find(String pageSize, int sizeNum, String eqName, String time1, String time2);

}
