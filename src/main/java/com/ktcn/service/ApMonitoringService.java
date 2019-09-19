package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Alarmpatrol;

/**
 * 报警巡查实时监控业务层
 * @author Administrator
 *
 */
public interface ApMonitoringService {
	List<Alarmpatrol> alarmpatrolMethod();
	// 报警信息写入数据库方法
	void writeAlarmpatrol();
}
