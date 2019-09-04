package com.ktcn.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.UserService;

/*
 * 用户管理控制层
 */
@RestController
public class UserController {
	@Resource
	private UserService userService;
	
	// 登录方法
	@RequestMapping("login")
	@SysLog(logModule = "用户管理", logName = "登录")
	public String login(@RequestBody Map<String,String> map, HttpServletRequest request) {
		// 用户验证方法
		Tb_user user = userService.login(map);
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
	@SysLog(logModule = "用户管理", logName = "退出")
	public String exit(HttpServletRequest request) {
		// 清空session
        request.getSession().invalidate();
		return "success";
	}
	
	// 查看现有全部用户
	@RequestMapping(value = "UserManagement",method = RequestMethod.GET)
	@SysLog(logModule = "用户管理", logName = "查看")
	public List<Tb_user> UserManagement(){
		List<Tb_user> user = userService.findAllUser();
		return user;
	}
	
	// 删除用户
	@RequestMapping(value = "UserManagement",method = RequestMethod.DELETE)
	@SysLog(logModule = "用户管理", logName = "删除")
	public String deleteUserById(int id){
		userService.deleteUserById(id);
		return "success";
	}
	
	// 修改用户信息
	@RequestMapping(value = "UserManagement",method = RequestMethod.PUT)
	@SysLog(logModule = "用户管理", logName = "修改")
	public String updateUserById(@RequestBody Map<String,String> map){
		userService.updateUserById(map);
		return "success";
	}
	
	// 条件查询用户
	@RequestMapping("Userquery")
	@SysLog(logModule = "用户管理", logName = "条件查询")
	public List<Tb_user> Userquery(String vague){
		List<Tb_user> user = userService.findUserByVague(vague);
		return user;
	}
	
	// 修改用户密码
	@RequestMapping("ChangePassword")
	@SysLog(logModule = "用户管理", logName = "密码修改")
	public String ChangePassword(String password, String Newpassword1, String Newpassword2, HttpServletRequest request) {
		String str = userService.ChangePassword(password,Newpassword1,Newpassword2,request);
		return str;
	}
	
	// 用户注册功能
	@RequestMapping("HomePage")
	@SysLog(logModule = "用户管理", logName = "注册")
	public String HomePage(@RequestBody Map<String,String> map, String password1) {
		// 比较两次密码输入是否相同
		if (password1.equals(map.get("password"))) {
			userService.addUser(map);
		} else {
			return "两次密码输入不一致";
		}
		return "success";
	}
}
