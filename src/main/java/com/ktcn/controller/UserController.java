package com.ktcn.controller;

import java.util.HashMap;
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
	public Map<String,Object> login(@RequestBody Map<String,String> map, HttpServletRequest request) {
		System.out.println("进入登录方法!");
		// 创建一个map集合用来保存返回信息
		Map<String,Object> data = new HashMap<String,Object>();
		// 用户验证方法
		Tb_user user = userService.login(map);
		if (user != null) {
			// 登录成功将用户信息存在session域中
			request.getSession().setAttribute("nowuser", user);
			data.put("code", "0000");
			data.put("data", user);
			data.put("message", "登录成功");
			System.out.println("登入sessionID: " + request.getSession().getId());
			return data;
		} else {
			data.put("code", "0001");
			data.put("message", "登录失败");
			return data;
		}
	}
	
	// 退出登录方法
	@RequestMapping("exit")
	@SysLog(logModule = "用户管理", logName = "退出")
	public String exit(HttpServletRequest request) {
		System.out.println("登出方法");
		System.out.println("登出sessionID: " + request.getSession().getId());
		// 清空session
		request.getSession().invalidate();
		return "success";
	}
	
	// 查看现有全部用户
	@RequestMapping(value = "UserManagement",method = RequestMethod.GET)
	@SysLog(logModule = "用户管理", logName = "查看")
	public List<Tb_user> UserManagement(HttpServletRequest request){
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() == 4) {
			List<Tb_user> list = userService.findAllUser();
			return list;
		} else {
			return null;
		}
	}
	
	// 删除用户
	@RequestMapping(value = "UserManagementDelete")
	@SysLog(logModule = "用户管理", logName = "删除")
	public String deleteUserById(int id, HttpServletRequest request){
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() == 4) {
			userService.deleteUserById(id);
			return "success";
		} else {
			return null;
		}
	}
	
	// 修改用户信息
	@RequestMapping(value = "UserManagementPut")
	@SysLog(logModule = "用户管理", logName = "修改")
	public String updateUserById(@RequestBody Map<String,String> map, HttpServletRequest request){
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() == 4) {
			userService.updateUserById(map);
			return "success";
		} else {
			return null;
		}
	}
	
	// 条件查询用户
	@RequestMapping("Userquery")
	@SysLog(logModule = "用户管理", logName = "条件查询")
	public List<Tb_user> Userquery(String vague, HttpServletRequest request){
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() == 4) {
			List<Tb_user> list = userService.findUserByVague(vague);
			return list;
		} else {
			return null;
		}
	}
	
	// 修改用户密码
	@RequestMapping("ChangePassword")
	@SysLog(logModule = "用户管理", logName = "密码修改")
	public String ChangePassword(@RequestBody Map<String,String> map, HttpServletRequest request) {
		String str = userService.ChangePassword(map,request);
		return str;
	}
	
	// 用户注册功能
	@RequestMapping("HomePage")
	@SysLog(logModule = "用户管理", logName = "注册")
	public String HomePage(@RequestBody Map<String,String> map, HttpServletRequest request) {
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() == 4) {
			// 比较两次密码输入是否相同
			if (map.get("password1").equals(map.get("password"))) {
				userService.addUser(map);
			} else {
				return "两次密码输入不一致";
			}
			// 清空session
	        request.getSession().invalidate();
			return "success";
		} else {
			return null;
		}
	}
	
	/**
	 * 获取当前登录用户信息
	 */
	@RequestMapping("getNowUser")
	public Map<String,Object> getNowUser(HttpServletRequest request){
		// 新建一个map集合用于存放返回信息
		Map<String,Object> map = new HashMap<String,Object>();
		// 写入返回信息
		map.put("code", "0000");
		map.put("user", (Tb_user) request.getSession().getAttribute("nowuser"));
		return map;
	}
}
