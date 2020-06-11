package com.ktcn.controller.reportController.hourController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.reportService.hourService.MeterHService;

/**
 * 外围仪表报表控制类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("hourMeter")
public class MeterHController {

	@Resource
	private MeterHService meterHService;
	
	/*
	 * 外围仪表报表查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,String time1,String time2){
		return meterHService.find(pageSize,time1,time2);
	}
}
