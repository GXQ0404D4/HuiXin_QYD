package com.ktcn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	Logger logger = LoggerFactory.getLogger(Test.class);
	
	@RequestMapping("test")
	public String test() {
		logger.info("进入测试方法");
		return "page/index";
	}
}
