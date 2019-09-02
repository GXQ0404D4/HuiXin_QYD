package com.ktcn.service;

import com.ktcn.entity.Log;

/**
 * 操作日志业务层
 * @author Administrator
 *
 */
public interface LogService {
	// 添加操作日志
	void addUserLog(Log log);

}
