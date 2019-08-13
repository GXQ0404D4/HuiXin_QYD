package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Electric_massage;

/*
 * 电量曲线分析业务层
 */
public interface CoulometryService {
	// 查询当天24小时的电量曲线信息
	List<Electric_massage> findByNowDate();
	// 查询30天流量曲线
	List<Electric_massage> findByNowMonth();
	// 根据机器查询30天流量曲线
	List<Electric_massage> findByMachine(String machine);
	// 按照时间区间查询
	List<Electric_massage> findByTime(String timeA, String timeB);

}
