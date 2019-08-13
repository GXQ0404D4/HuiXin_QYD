package com.ktcn.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.UserDao;
import com.ktcn.service.UserService;
/*
 * 用户管理业务层实现类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
}
