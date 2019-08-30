package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Electric_massage;
import com.ktcn.entity.V_chart;

/*
 * 电量曲线分析业务层
 */
public interface CoulometryService {
	// 查询当天24小时的电量曲线信息
	List<V_chart> findByNowDate();
	// 查询本月流量曲线
	List<V_chart> findByNowMonth();
	// 根据机器查询本月流量曲线
	List<V_chart> findByMachine(String machine);
	// 按照时间区间查询
	List<V_chart> findByTime(String timeA, String timeB);

}
