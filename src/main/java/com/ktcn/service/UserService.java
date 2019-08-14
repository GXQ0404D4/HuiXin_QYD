package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Tb_user;

/*
 * 用户管理业务层
 */
public interface UserService {
	// 查看现有全部用户
	List<Tb_user> findAllUser();
	// 删除用户
	void deleteUserById(int id);
	// 条件查询用户
	List<Tb_user> findUserByVague(String vague);
	// 修改用户信息
	void updateUserById(Tb_user user);

}
