package com.ktcn.controller.reportController.hourController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.reportService.hourService.AirHService;

/**
 * 空压机报表控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("hourAir")
public class AirHController {

	@Resource
	private AirHService airHService;
	
	/*
	 * 空压机报表查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,String eqName,String time1,String time2){
		return airHService.find(pageSize,eqName,time1,time2);
	}
}
