package com.ktcn.service.alarmService;

import java.util.Map;

/**
 * 空压机报警记录业务层
 * @author Administrator
 *
 */
public interface AlairService {

	/*
	 * 查询方法
	 */
	Map<String, Object> find(String pageSize,int sizeNum,String eqName,String time1,String time2);

}
