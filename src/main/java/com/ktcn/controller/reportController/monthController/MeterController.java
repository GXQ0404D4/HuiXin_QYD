package com.ktcn.controller.reportController.monthController;
/**
 * 外围仪表历史数据控制层
 * @author Administrator
 *
 */

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.reportService.monthService.MeterService;

@RestController
@RequestMapping("monthMeter")
public class MeterController {
	
	@Resource
	private MeterService meterService;
	
	/*
	 * 外围仪表数据查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,String time1,String time2){
		return meterService.find(pageSize,time1,time2);
	}
	
}
