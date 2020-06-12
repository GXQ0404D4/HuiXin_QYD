package com.ktcn.service.chartsService;

import java.util.Map;

/**
 * 空压机折线图业务层
 * @author Administrator
 *
 */
public interface AirChartService {

	/*
	 * 查询方法
	 */
	Map<String, Object> find(String eqName);

}
