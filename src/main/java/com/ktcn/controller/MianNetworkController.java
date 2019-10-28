package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.MianNetworkService;

/*
 * 总管网报表控制层
 */
@RestController
public class MianNetworkController {
	@Resource
	private MianNetworkService mianNetworkService;
	// 查询全部总管网信息
	@RequestMapping("TotalReport")
	@SysLog(logModule = "总管网报表", logName = "查看全部")
	public List<Kyj_data_table> TotalReport() {
		// 查询全部总管网信息
		List<Kyj_data_table> AClist = mianNetworkService.findAll();
		return AClist;
	}
	// 按照时间区间查询电量报表信息
	@RequestMapping("TotalReport_time")
	@SysLog(logModule = "总管网报表", logName = "时间区间查询")
	public List<Kyj_data_table> TotalReport_time(String current_timeA, String current_timeB) {
		// 查询全部电量报表信息
		List<Kyj_data_table> AClist = mianNetworkService.findAllByTime(current_timeA,current_timeB);
		return AClist;
	}
	
}
