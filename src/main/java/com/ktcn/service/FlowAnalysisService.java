package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.V_chart;

/*
 * 流量曲线分析业务层
 */
public interface FlowAnalysisService {
	// 查询当天24小时的流量曲线信息
	List<V_chart> findByNowDate();
	// 查询当前月流量曲线
	List<V_chart> findByNowMonth();
	// 根据机器查询本月流量曲线
	List<V_chart> findByMachine(String machine);
	// 按照时间区间查询
	List<V_chart> findByTime(String timeA, String timeB);

}
