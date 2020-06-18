package com.ktcn.service;

import java.util.Map;

/**
 * 外围仪表报警你记录业务层
 * @author Administrator
 *
 */
public interface AlmeterService {

	/*
	 * 查询方法
	 */
	Map<String, Object> find(String pageSize, int sizeNum, String eqName, String time1, String time2);

}
