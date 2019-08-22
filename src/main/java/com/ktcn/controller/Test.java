package com.ktcn.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktcn.service.Login_Service;

@Controller
public class Test {
	Logger logger = LoggerFactory.getLogger(Test.class);
	@Autowired 
	Login_Service login_serviceimp;
	
	@RequestMapping("test")
	public String test() {
		logger.info("进入测试方法");
		login_serviceimp.LoginUser();
		return "page/login";
	}
	@RequestMapping("img")
	public String img() {
		return "page/img";
	}
}
