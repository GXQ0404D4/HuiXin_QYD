package com.ktcn.utils;
/**
 * 获取当前登录用户
 * @author Administrator
 *
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ktcn.entity.Tb_user;

public class GetLoggingUser {
	
	
	// 获取当前登录用户方法
	public static Tb_user getLoggingUser() {
		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 写入一个user
		request.getSession().setAttribute("nowuser", new Tb_user());
		// 获取登录用户, 并返回
		return (Tb_user) request.getSession().getAttribute("nowuser");
	}
}
