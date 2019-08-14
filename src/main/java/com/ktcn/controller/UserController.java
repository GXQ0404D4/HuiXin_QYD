package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Tb_user;
import com.ktcn.service.UserService;

/*
 * 用户管理控制层
 */
@RestController
public class UserController {
	@Resource
	private UserService userService;
	
	// 查看现有全部用户
	@RequestMapping(value = "UserManagement",method = RequestMethod.GET)
	public List<Tb_user> UserManagement(){
		List<Tb_user> user = userService.findAllUser();
		return user;
	}
	
	// 删除用户
	@RequestMapping(value = "UserManagement",method = RequestMethod.DELETE)
	public String deleteUserById(int id){
		userService.deleteUserById(id);
		return "success";
	}
	
	// 修改用户信息
	@RequestMapping(value = "UserManagement",method = RequestMethod.PUT)
	public String updateUserById(Tb_user user){
		System.out.println(user);
		userService.updateUserById(user);
		return "success";
	}
	
	// 条件查询用户
	@RequestMapping("Userquery")
	public List<Tb_user> Userquery(String vague){
		System.out.println(vague);
		List<Tb_user> user = userService.findUserByVague(vague);
		return user;
	}
	
	// 用户注册功能
	@RequestMapping("HomePage")
	public String HomePage(Tb_user user, String password1) {
		System.out.println(user);
		System.out.println(password1);
		if (password1.equals(user.getPassword())) {
			userService.addUser(user);
		} else {
			return "两次密码输入不一致";
		}
		return "success";
	}
}
