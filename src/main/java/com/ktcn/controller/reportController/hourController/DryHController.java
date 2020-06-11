package com.ktcn.controller.reportController.hourController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.reportService.hourService.DryHService;

/**
 * 干燥机报表控制类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("hourDry")
public class DryHController {

	@Resource
	private DryHService dryHService;
	
	/*
	 * 干燥机数据查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,String time1,String time2){
		return dryHService.find(pageSize,time1,time2);
	}
}
