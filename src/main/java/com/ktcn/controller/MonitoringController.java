package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.MonitoringService;

/*
 * 监控页面控制层
 */
@RestController
public class MonitoringController {
	@Resource
	private MonitoringService monitoringService;
}
