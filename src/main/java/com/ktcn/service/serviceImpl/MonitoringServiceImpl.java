package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MonitoringDao;
import com.ktcn.service.MonitoringService;
/*
 * 监控页面业务层实现类
 */
@Service
@Transactional
public class MonitoringServiceImpl implements MonitoringService {
	@Resource
	private MonitoringDao monitoringDao;
}
