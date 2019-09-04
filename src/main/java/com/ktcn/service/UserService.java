package com.ktcn.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ktcn.entity.Tb_user;

/*
 * 用户管理业务层
 */
public interface UserService {
	// 用户登录验证
	Tb_user login(Map<String, String> map);
	// 查看现有全部用户
	List<Tb_user> findAllUser();
	// 删除用户
	void deleteUserById(int id);
	// 条件查询用户
	List<Tb_user> findUserByVague(String vague);
	// 修改用户信息
	void updateUserById(Map<String, String> map);
	// 用户注册功能
	void addUser(Map<String, String> map);
	// 修改用户密码
	String ChangePassword(String password, String newpassword1, String newpassword2, HttpServletRequest request);

}
