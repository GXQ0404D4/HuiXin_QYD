package com.ktcn.service.alarmService;

import java.util.Map;

/**
 * 干燥机报警记录业务层
 * @author Administrator
 *
 */
public interface AldryService {

	/*
	 * 查询方法
	 */
	Map<String, Object> find(String pageSize, int sizeNum, String time1, String time2);

}
