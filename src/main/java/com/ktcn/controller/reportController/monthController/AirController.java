package com.ktcn.controller.reportController.monthController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.reportService.monthService.AirService;

/**
 * 空压机历史数据控制类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("monthAir")
public class AirController {

	@Resource
	private AirService airService;
	
	/*
	 * 空压机数据查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,int sizeNum,String eqName,String time1,String time2){
		return airService.find(pageSize,sizeNum,eqName,time1,time2);
	}
	
}
