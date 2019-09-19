package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Alarmpatrol;

/**
 * 报警巡查实时监控业务层
 * @author Administrator
 *
 */
public interface ApMonitoringService {
	// 获取实时监控表内容, 获取报警设置表内容, 进行对比, 对符合报警条件的属性生成实例对象存入list中
	List<Alarmpatrol> alarmpatrolMethod();
	// 报警信息写入数据库方法
	void writeAlarmpatrol();
}
