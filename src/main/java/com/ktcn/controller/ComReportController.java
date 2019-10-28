package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.ComReportService;

/*
 * 空压机报表控制类
 */
@CrossOrigin
@RestController
public class ComReportController {
	@Resource
	private ComReportService comReportService;
	
	// 查询全部空压机报表数据
	@RequestMapping("CompressorReport")
	@SysLog(logModule = "空压机报表", logName = "查看全部")
	public List<Kyj_data_table> CompressorReport(HttpServletRequest request) {
		// 查询全部空压机报表信息
		List<Kyj_data_table> AClist = comReportService.findAll();
		return AClist;
	}
	
	// 按照时间区间查询空压机报表数据
	@RequestMapping("compressor_time")
	@SysLog(logModule = "空压机报表", logName = "时间区间查看")
	public List<Kyj_data_table> compressor_time(String current_timeA, String current_timeB){
		System.out.println("时间1: " + current_timeA);
		System.out.println("时间2: " + current_timeB);
		// 根据时间区间查询空压机报表信息
		List<Kyj_data_table> AClist = comReportService.findAllByTime(current_timeA,current_timeB);
		return AClist;
	}
	
	
}
