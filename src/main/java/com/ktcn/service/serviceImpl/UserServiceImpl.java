package com.ktcn.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.UserDao;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.UserService;
import com.ktcn.utils.MD5Util;
/*
 * 用户管理业务层实现类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	// 用户登录验证
	@Override
	public Tb_user login(Tb_user user) {
		// 密码加密
		user.setPassword(MD5Util.encodeByMd5_32(user.getPassword()));
		// 调用登录方法
		return userDao.login(user);
	}
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
		// 获取当前时间
		user.setCreateTime(new Date());
		// 对用户密码进行MD5加密
		user.setPassword(MD5Util.encodeByMd5_32(user.getPassword()));
		userDao.addUser(user);
	}
	// 修改用户密码
	@Override
	public String ChangePassword(String password, String newpassword1, String newpassword2, HttpServletRequest request) {
		if (newpassword1.equals(newpassword2)) {
			if (request.getSession().getAttribute("nowuser").toString().equals(MD5Util.encodeByMd5_32(password))) {
				Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
				user.setPassword(MD5Util.encodeByMd5_32(password));
				userDao.ChangePassword(user);
			}
		} else {
			return "error";
		}
		return null;
	}
	
}
