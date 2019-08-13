package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.FlowAnalysisDao;
import com.ktcn.service.FlowAnalysisService;
/*
 * 业务曲线分析业务层实现类
 */
@Service
@Transactional
public class FlowAnalysisServiceImpl implements FlowAnalysisService {
	@Resource
	private FlowAnalysisDao flowAnalysisDao;
}
