package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Mian_network;

/*
 * 流量曲线分析业务层
 */
public interface FlowAnalysisService {
	// 查询当天24小时的电量曲线信息
	List<Mian_network> findByNowDate();
	// 查询当前月流量曲线
	List<Mian_network> findByNowMonth();
	// 根据机器查询本月流量曲线
	List<Mian_network> findByMachine(String machine);
	// 按照时间区间查询
	List<Mian_network> findByTime(String timeA, String timeB);

}
