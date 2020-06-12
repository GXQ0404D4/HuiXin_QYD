package com.ktcn.controller.chartsController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.chartsService.DryChartService;

/**
 * 干燥机折线图控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("dryChart")
public class DryChartController {

	@Resource
	private DryChartService dryChartService;
	
	/*
	 * 查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(){
		return dryChartService.find();
	}
}
