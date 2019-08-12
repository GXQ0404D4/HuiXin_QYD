package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ComReportDao;
import com.ktcn.service.ComReportService;
/*
 * 空压机报表业务层实现类
 */
@Service
@Transactional
public class ComReportServiceImpl implements ComReportService {
	@Resource
	private ComReportDao comReportDao;
}
