package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.CoulometryDao;
import com.ktcn.service.CoulometryService;
/*
 * 电量曲线分析业务层实现类
 */
@Service
@Transactional
public class CoulometryServiceImpl implements CoulometryService {
	@Resource
	private CoulometryDao coulometryDao;
}
