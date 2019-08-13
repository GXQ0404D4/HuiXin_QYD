package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MaintenanceDao;
import com.ktcn.service.MaintenanceService;
/*
 * 维保记录业务层实现类
 */
@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {
	@Resource
	private MaintenanceDao maintenanceDao;
}
