package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.FaultRecordService;

/*
 * 故障记录控制层
 */
@RestController
public class FaultRecordController {
	@Resource
	private FaultRecordService faultRecordService;
}
