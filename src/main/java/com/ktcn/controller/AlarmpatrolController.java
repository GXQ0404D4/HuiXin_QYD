package com.ktcn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Alarmpatrol;
import com.ktcn.service.AlarmpatrolService;

/**
 * 报警巡查控制层
 * @author Administrator
 *
 */
@RestController
public class AlarmpatrolController {
	@Resource
	private AlarmpatrolService alarmpatrolService;
	
	// 查询全部报警巡查信息
	@RequestMapping("apFindAll")
	public Map<String,Object> apFindAll(){
		// 创建一个map集合用来保存返回信息
		Map<String,Object> map = new HashMap<String,Object>();
		// 获取全部报警巡查信息
		List<Alarmpatrol> list = alarmpatrolService.apFindAll();
		// 写入返回信息
		map.put("code", "0000");
		map.put("message",list);
		
		return map;
	}
	
	// 按照时间区间查询报警巡查信息
	@RequestMapping("apFindByTime")
	public Map<String,Object> apFindByTime(String TimeA, String TimeB){
		// 创建一个map集合用来保存返回信息
		Map<String,Object> map = new HashMap<String,Object>();
		// 获取全部报警巡查信息
		List<Alarmpatrol> list = alarmpatrolService.apFindByTime(TimeA,TimeB);
		// 写入返回信息
		map.put("code", "0000");
		map.put("message",list);
		
		return map;
	}
	
}
