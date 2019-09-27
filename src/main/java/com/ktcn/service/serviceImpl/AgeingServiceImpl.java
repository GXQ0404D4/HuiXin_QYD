package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.AgeingDao;
import com.ktcn.entity.Ageing;
import com.ktcn.service.AgeingService;
/**
 * 系统运行时效业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class AgeingServiceImpl implements AgeingService {
	
	@Resource
	private AgeingDao ageingDao;
	// 获取最后一条时间轴信息
	@Override
	public Ageing getLastCode() {
		return ageingDao.getLastCode();
	}
	
}
