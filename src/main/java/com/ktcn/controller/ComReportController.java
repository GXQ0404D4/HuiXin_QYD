package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.ComReportService;

/*
 * 空压机报表控制类
 */
@RestController
public class ComReportController {
	@Resource
	private ComReportService comReportService;
	
}
