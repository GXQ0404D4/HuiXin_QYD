package com.ktcn.controller.alarmController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.alarmService.AldryService;

/**
 * 干燥机报警记录控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("alDry")
public class AldryController {

	@Resource
	private AldryService aldrtService;
	
	/*
	 * 查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,int sizeNum,String time1,String time2){
		return aldrtService.find(pageSize,sizeNum,time1,time2);
	}
}
