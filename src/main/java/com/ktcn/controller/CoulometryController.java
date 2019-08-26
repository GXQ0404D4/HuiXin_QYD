package com.ktcn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Electric_massage;
import com.ktcn.service.CoulometryService;

/*
 * 电量曲线分析控制层
 */
@RestController
public class CoulometryController {
	@Resource
	private CoulometryService coulometryService;
	/* MySQL获取当天每个小时数据语句
	 * SELECT HOUR(e.t_time) as Hour,sum(e.num) as Sum
	FROM test_time e
	WHERE e.t_date = (SELECT date_format(now(),'%Y-%m-%d'))
	GROUP BY HOUR(e.t_time) ORDER BY Hour(e.t_time);
	 */
	/* MySQL获取当月每个小时数据语句
	 * SELECT HOUR(e.t_time) as Hour,sum(e.num) as Sum
	FROM test_time e
	WHERE date_format( e.t_date, '%Y%m' ) = date_format(curdate( ) , '%Y%m' )
	GROUP BY HOUR(e.t_time) ORDER BY Hour(e.t_time);
	 */
	/* MySQL根据时间区间获取每小时数据语句
	 * SELECT t_date,HOUR(e.t_time) as Hour,sum(e.num) as Sum
	FROM test_time e
	WHERE
	t_date BETWEEN '1970-01-01' AND '2020-01-01' 
	GROUP BY HOUR(e.t_time) ORDER BY Hour(e.t_time);
	 */
	
	// 查询全部方法
//	@RequestMapping(value="ElectricityAnalysis",headers="Accept=application/json",produces="application/json;charset=UTF-8")
	@SuppressWarnings("rawtypes")
	@RequestMapping("ElectricityAnalysis")
	public List<List> ElectricityAnalysis() {
		// 24小时电量曲线信息
		List<Electric_massage> electricA = this.findByNowDate();
		// 查询本月流量曲线
		List<Electric_massage> electricB = this.findByNowMonth();
		// 新建一个list存储两组数据
		List<List> list = new ArrayList<List>();
		list.add(electricA);
		list.add(electricB);
		return list;
	}
	// 查询当天24小时的电量曲线信息
	public List<Electric_massage> findByNowDate() {
		List<Electric_massage> electricA = coulometryService.findByNowDate();
		for (Electric_massage e : electricA) {
			System.out.println("当天信息"+e);
		}
		return electricA;
	}
	// 查询本月流量曲线
	public List<Electric_massage> findByNowMonth() {
		List<Electric_massage> electricB = coulometryService.findByNowMonth();
		for (Electric_massage e : electricB) {
			System.out.println("近本月信息"+e);
		}
		return electricB;
	}
	
	// 根据机器查询本月流量曲线
	@RequestMapping("Ect_machine")
	public List<Electric_massage> Ect_machine(String machine) {
		List<Electric_massage> electricB = coulometryService.findByMachine(machine);
		for (Electric_massage e : electricB) {
			System.out.println("按照机器名称查询近本月信息"+e);
		}
		return electricB;
	}
	
	// 按照时间区间查询
	@RequestMapping("Ect_Time")
	public List<Electric_massage> Ect_Time(String TimeA, String TimeB) {
		List<Electric_massage> electricB = coulometryService.findByTime(TimeA,TimeB);
		for (Electric_massage e : electricB) {
			System.out.println("按照时间区间获取: "+e);
		}
		return electricB;
	}
}
