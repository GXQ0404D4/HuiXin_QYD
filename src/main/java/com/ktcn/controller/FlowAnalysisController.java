package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.FlowAnalysisService;

/*
 * 流量曲线分析控制层
 */
@RestController
public class FlowAnalysisController {
	@Resource
	private FlowAnalysisService flowAnalysisService;
}
