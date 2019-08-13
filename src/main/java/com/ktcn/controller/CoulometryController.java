package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.CoulometryService;

/*
 * 电量曲线分析控制层
 */
@RestController
public class CoulometryController {
	@Resource
	private CoulometryService coulometryService;
	
}
