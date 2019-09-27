package com.ktcn.service;

import java.util.Map;

import com.ktcn.entity.Ageing;

/**
 * 系统运行时效业务层
 * @author Administrator
 *
 */
public interface AgeingService {
	
	// 获取最后一条时间轴信息
	Ageing getLastCode();
	
	// 获取总条数, 查看系统时效时间轴是否存在初始数据
	int getCodeCount();

	// 写入初始时间轴
	void writeInitialCode();
	// 写入单次时间轴数据
	void writeOnceCode();
	
	// 用户登录调用此方法, 查看系统运行是否超时
	Map<String, String> comparisonCode();

}
