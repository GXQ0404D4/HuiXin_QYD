package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.TestDao;
import com.ktcn.entity.Log;
import com.ktcn.service.TestSercice;
@Service
@Transactional
public class TestSerciceImpl implements TestSercice {
	@Resource
	private TestDao testDao;

	@Override
	public List<Log> findByPage(int total, int pageSize) {
		return testDao.findByPage(total,pageSize);
	}
	
}
