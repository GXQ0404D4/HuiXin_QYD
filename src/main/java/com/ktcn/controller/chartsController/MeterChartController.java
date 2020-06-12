package com.ktcn.controller.chartsController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.chartsService.MeterChartService;

/**
 * 外围仪表折线图控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("meterChart")
public class MeterChartController {

	@Resource
	private MeterChartService meterChartService;
	
	/*
	 * 查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(){
		return meterChartService.find();
	}
}
