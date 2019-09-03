package com.ktcn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Mian_network;
import com.ktcn.entity.V_chart;
import com.ktcn.service.FlowAnalysisService;

/*
 * 流量曲线分析控制层
 */
@RestController
public class FlowAnalysisController {
	@Resource
	private FlowAnalysisService flowAnalysisService;
	// 查询全部方法
	@SuppressWarnings("rawtypes")
	@RequestMapping("FlowAnalysis")
	@SysLog(logModule = "流量曲线分析", logName = "全部查看")
	public List<List> FlowAnalysis() {
		// 24小时流量曲线信息
		List<V_chart> m_network = this.findByNowDate();
		// 查询30天流量曲线
		List<V_chart> z_network = this.findByNowMonth();
		// 新建一个list存储两组数据
		List<List> list = new ArrayList<List>();
		list.add(m_network);
		list.add(z_network);
		return list;
	}
	// 查询当天24小时的流量曲线信息
	public List<V_chart> findByNowDate() {
		List<V_chart> m_network = flowAnalysisService.findByNowDate();
		return m_network;
	}
	// 查询当前月流量曲线
	public List<V_chart> findByNowMonth() {
		List<V_chart> z_network = flowAnalysisService.findByNowMonth();
		return z_network;
	}
	
	// 根据机器查询本月流量曲线
	@RequestMapping("FlowAnalysis_machine")
	@SysLog(logModule = "流量曲线分析", logName = "机器名称查看")
	public List<V_chart> FlowAnalysis_machine(String machine) {
		List<V_chart> z_network = flowAnalysisService.findByMachine(machine);
		return z_network;
	}
	
	// 按照时间区间查询
	@RequestMapping("FlowAnalysis_Time")
	@SysLog(logModule = "流量曲线分析", logName = "时间区间查看")
	public List<V_chart> FlowAnalysis_Time(String TimeA, String TimeB) {
		System.out.println("双时间方法"+TimeA+TimeB);
		List<V_chart> z_network = flowAnalysisService.findByTime(TimeA,TimeB);
		return z_network;
	}
	
}
