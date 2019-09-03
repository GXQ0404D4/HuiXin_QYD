package com.ktcn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Electric_massage;
import com.ktcn.entity.V_chart;
import com.ktcn.service.CoulometryService;

/*
 * 电量曲线分析控制层
 */
@RestController
public class CoulometryController {
	@Resource
	private CoulometryService coulometryService;
	// 查询全部方法
//	@RequestMapping(value="ElectricityAnalysis",headers="Accept=application/json",produces="application/json;charset=UTF-8")
	@SuppressWarnings("rawtypes")
	@RequestMapping("ElectricityAnalysis")
	@SysLog(logModule = "电量曲线分析", logName = "全部查看")
	public List<List> ElectricityAnalysis() {
		// 24小时电量曲线信息
		List<V_chart> electricA = this.findByNowDate();
		// 查询本月流量曲线
		List<V_chart> electricB = this.findByNowMonth();
		// 新建一个list存储两组数据
		List<List> list = new ArrayList<List>();
		list.add(electricA);
		list.add(electricB);
		return list;
	}
	// 查询当天24小时的电量曲线信息
	public List<V_chart> findByNowDate() {
		List<V_chart> electricA = coulometryService.findByNowDate();
		return electricA;
	}
	// 查询本月流量曲线
	public List<V_chart> findByNowMonth() {
		List<V_chart> electricB = coulometryService.findByNowMonth();
		return electricB;
	}
	
	// 根据机器查询本月流量曲线
	@RequestMapping("Ect_machine")
	@SysLog(logModule = "电量曲线分析", logName = "根据机器查看")
	public List<V_chart> Ect_machine(String machine) {
		List<V_chart> electricB = coulometryService.findByMachine(machine);
		return electricB;
	}
	
	// 按照时间区间查询
	@RequestMapping("Ect_Time")
	@SysLog(logModule = "电量曲线分析", logName = "时间区间查看")
	public List<V_chart> Ect_Time(String TimeA, String TimeB) {
		List<V_chart> electricB = coulometryService.findByTime(TimeA,TimeB);
		return electricB;
	}
}
