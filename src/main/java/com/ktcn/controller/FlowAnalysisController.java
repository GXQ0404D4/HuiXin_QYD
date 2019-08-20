package com.ktcn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Mian_network;
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
	public List<List> FlowAnalysis() {
		// 24小时电量曲线信息
		List<Mian_network> m_network = this.findByNowDate();
		// 查询30天流量曲线
		List<Mian_network> z_network = this.findByNowMonth();
		// 新建一个list存储两组数据
		List<List> list = new ArrayList<List>();
		list.add(m_network);
		list.add(z_network);
		return list;
	}
	// 查询当天24小时的电量曲线信息
	public List<Mian_network> findByNowDate() {
		List<Mian_network> m_network = flowAnalysisService.findByNowDate();
		for (Mian_network e :  m_network) {
			System.out.println("当天信息"+e);
		}
		return m_network;
	}
	// 查询当前月流量曲线
	public List<Mian_network> findByNowMonth() {
		List<Mian_network> z_network = flowAnalysisService.findByNowMonth();
		for (Mian_network e : z_network) {
			System.out.println("近当前月信息"+e);
		}
		return z_network;
	}
	
	// 根据机器查询本月流量曲线
	@RequestMapping("FlowAnalysis_machine")
	public List<Mian_network> FlowAnalysis_machine(String machine) {
		System.out.println(machine);
		List<Mian_network> z_network = flowAnalysisService.findByMachine(machine);
		for (Mian_network e : z_network) {
			System.out.println("按照机器名称查询近本月信息"+e);
		}
		return z_network;
	}
	
	// 按照时间区间查询
	@RequestMapping("FlowAnalysis_Time")
	public List<Mian_network> FlowAnalysis_Time(String TimeA, String TimeB) {
		List<Mian_network> z_network = flowAnalysisService.findByTime(TimeA,TimeB);
		for (Mian_network e : z_network) {
			System.out.println("按照时间区间获取: "+e);
		}
		return z_network;
	}
	
}
