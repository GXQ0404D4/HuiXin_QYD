package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Alarmpatrol;

/**
 * 报警巡查业务层
 * @author Administrator
 *
 */
public interface AlarmpatrolService {
	// 查询全部报警巡查信息
	List<Alarmpatrol> apFindAll();
	// 按照时间区间查询报警巡查信息
	List<Alarmpatrol> apFindByTime(String timeA, String timeB);

}
