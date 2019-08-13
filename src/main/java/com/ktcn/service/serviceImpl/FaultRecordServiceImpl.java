package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.FaultRecordDao;
import com.ktcn.service.FaultRecordService;
/*
 * 故障记录业务层实现类
 */
@Service
@Transactional
public class FaultRecordServiceImpl implements FaultRecordService {
	@Resource
	private FaultRecordDao faultRecordDao;
}
