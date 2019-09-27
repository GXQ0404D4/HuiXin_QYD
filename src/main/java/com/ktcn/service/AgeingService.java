package com.ktcn.service;

import com.ktcn.entity.Ageing;

/**
 * 系统运行时效业务层
 * @author Administrator
 *
 */
public interface AgeingService {
	// 获取最后一条时间轴信息
	Ageing getLastCode();

}
