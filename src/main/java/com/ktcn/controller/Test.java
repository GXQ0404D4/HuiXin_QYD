package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Log;
import com.ktcn.service.TestSercice;

@RestController
public class Test {
	@Resource
	private TestSercice testService;
	
	@RequestMapping("pagetest")
	public List<Log> pagetest(){
		int page = 2;
        int pageSize = 10;
        int start = page-1;
        int total = start*pageSize;
		List<Log> list = testService.findByPage(total,pageSize);
		return list;
	}
}
