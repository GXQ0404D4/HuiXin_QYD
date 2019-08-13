package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.UserService;

/*
 * 用户管理控制层
 */
@RestController
public class UserController {
	@Resource
	private UserService userService;
	
}
