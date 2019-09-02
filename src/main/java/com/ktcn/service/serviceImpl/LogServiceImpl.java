package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.LogDao;
import com.ktcn.entity.Log;
import com.ktcn.service.LogService;
/**
 * 操作日志业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {
	@Resource
	private LogDao logDao;
	// 添加操作日志
	@Override
	public void addUserLog(Log log) {
		logDao.addUserLog(log);
	}
	
}
