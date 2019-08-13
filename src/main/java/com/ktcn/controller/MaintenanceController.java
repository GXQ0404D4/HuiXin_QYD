package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.MaintenanceService;

/*
 * 维保记录控制层
 */
@RestController
public class MaintenanceController {
	@Resource
	private MaintenanceService maintenanceService;
	
}
