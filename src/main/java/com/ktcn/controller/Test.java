package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktcn.entity.Tb_user;
import com.ktcn.service.TestService;

@Controller
public class Test {
	Logger logger = LoggerFactory.getLogger(Test.class);
	@Resource
	TestService testService;
	@RequestMapping("test")
	public String test() {
		logger.info("进入测试方法");
		List<Tb_user> users = testService.findUser();
		for (Tb_user u : users) {
			System.out.println(u);
		}
		return "page/index";
	}
}
