package com.ktcn.controller.alarmController;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.alarmService.AlairService;

/**
 * 空压机报警记录控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("alAir")
public class AlairController {

	@Resource
	private AlairService alairService;
	
	/*
	 * 查询方法
	 */
	@RequestMapping("find")
	public Map<String,Object> find(String pageSize,int sizeNum,String eqName,String time1,String time2){
		return alairService.find(pageSize,sizeNum,eqName,time1,time2);
	}
}
