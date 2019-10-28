package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.ElectricMessService;

/*
 * 电量报表控制层
 */
@RestController
public class ElectricMessController {
	@Resource
	private ElectricMessService electricMessService;
	// 查询请求
	@RequestMapping("ElectricityReport")
	@SysLog(logModule = "电量报表", logName = "查看")
	public List<Kyj_data_table> ElectricityReportt() {
		// 查询全部电量报表信息
		List<Kyj_data_table> AClist = electricMessService.findAll();
		return AClist;
	}
	// 按照时间区间查询电量报表信息
	@RequestMapping("ElectricityReport_time")
	@SysLog(logModule = "电量报表", logName = "时间区间查看")
	public List<Kyj_data_table> ElectricityReport_time(String current_timeA, String current_timeB) {
		// 查询全部电量报表信息
		List<Kyj_data_table> AClist = electricMessService.findAllByTime(current_timeA,current_timeB);
		return AClist;
	}
	
}
