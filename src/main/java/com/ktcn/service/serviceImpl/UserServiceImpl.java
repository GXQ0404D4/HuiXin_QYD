package com.ktcn.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.UserDao;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.UserService;
/*
 * 用户管理业务层实现类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	// 查看现有全部用户
	@Override
	public List<Tb_user> findAllUser() {
		return userDao.findAllUser();
	}
	// 删除用户
	@Override
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
	// 条件查询用户
	@Override
	public List<Tb_user> findUserByVague(String vague) {
		return userDao.findUserByVague(vague);
	}
	// 修改用户信息
	@Override
	public void updateUserById(Tb_user user) {
		userDao.updateUserById(user);
	}
	// 用户注册功能
	@Override
	public void addUser(Tb_user user) {
		user.setCreateTime(new Date());
		System.out.println("serviceImpl");
		System.out.println(user);
		userDao.addUser(user);
	}
	
}
