package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.TestDao;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.TestService;
@Service
@Transactional
public class TestServiceImpl implements TestService {
	@Resource
	TestDao testDao;
	@Override
	public List<Tb_user> findUser() {
		return testDao.findUser();
	}

}
