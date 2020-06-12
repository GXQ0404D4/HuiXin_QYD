package com.ktcn.controller.chartsController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.chartsService.AirChartService;

/**
 * 空压机折线图控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("airChart")
public class AirChartController {

	@Resource
	private AirChartService airChartService;
	
	/*
	 * 查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String eqName){
		return airChartService.find(eqName);
	}
}
