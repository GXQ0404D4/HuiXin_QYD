package com.ktcn.controller.reportController.monthController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.reportService.monthService.DryService;

/**
 * 干燥机历史数据控制类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("monthDry")
public class DryController {

	@Resource
	private DryService dryService;
	
	/*
	 * 干燥机数据查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,String time1,String time2){
		return dryService.find(pageSize,time1,time2);
	}
}
