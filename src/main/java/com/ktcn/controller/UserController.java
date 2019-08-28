package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	// 登录方法(备用)
	@RequestMapping("login")
	public String login(Tb_user user, HttpServletRequest request) {
		// 用户验证方法
		user = userService.login(user);
		if (user!=null) {
			// 登录成功将用户信息存在session域中
			request.getSession().setAttribute("nowuser", user);
			return "success";
		} else {
			return "error";
		}
	}
	
	// 退出登录方法
	@RequestMapping("exit")
	public String exit(HttpServletRequest request) {
		// 清空session
        request.getSession().invalidate();
		return "success";
	}
	
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
		userService.updateUserById(user);
		return "success";
	}
	
	// 条件查询用户
	@RequestMapping("Userquery")
	public List<Tb_user> Userquery(String vague){
		List<Tb_user> user = userService.findUserByVague(vague);
		return user;
	}
	
	// 修改用户密码
	@RequestMapping("ChangePassword")
	public String ChangePassword(String password, String Newpassword1, String Newpassword2, HttpServletRequest request) {
		String str = userService.ChangePassword(password,Newpassword1,Newpassword2,request);
		return str;
	}
	
	// 用户注册功能
	@RequestMapping("HomePage")
	public String HomePage(Tb_user user, String password1) {
		// 比较两次密码输入是否相同
		if (password1.equals(user.getPassword())) {
			userService.addUser(user);
		} else {
			return "两次密码输入不一致";
		}
		return "success";
	}
}
