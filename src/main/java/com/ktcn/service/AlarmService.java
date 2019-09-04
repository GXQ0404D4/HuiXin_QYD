package com.ktcn.service;

import java.util.List;
import java.util.Map;

import com.ktcn.entity.Alarmseteings;

/*
 * 报警设置业务层
 */
public interface AlarmService {
	// 查看报警设置
	List<Alarmseteings> findAll();
	// 修改报警设置
	void updateAlarm(Map<String, String> map);


}
