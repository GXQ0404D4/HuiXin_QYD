package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.FlowAnalysisDao;
import com.ktcn.entity.Mian_network;
import com.ktcn.entity.V_chart;
import com.ktcn.service.FlowAnalysisService;
/*
 * 业务曲线分析业务层实现类
 */
@Service
@Transactional
public class FlowAnalysisServiceImpl implements FlowAnalysisService {
	@Resource
	private FlowAnalysisDao flowAnalysisDao;
	// 查询当天24小时的流量曲线信息
	@Override
	public List<V_chart> findByNowDate() {
		return flowAnalysisDao.findByNowDate();
	}
	// 查询当前月流量曲线
	@Override
	public List<V_chart> findByNowMonth() {
		return flowAnalysisDao.findByNowMonth();
	}
	// 根据机器查询本月流量曲线
	@Override
	public List<V_chart> findByMachine(String machine) {
		return flowAnalysisDao.findByMachine(machine);
	}
	// 按照时间区间查询
	@Override
	public List<V_chart> findByTime(String timeA, String timeB) {
		return flowAnalysisDao.findByTime(timeA,timeB);
	}
}
