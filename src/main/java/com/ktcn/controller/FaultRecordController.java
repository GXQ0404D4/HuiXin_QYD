package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Error_recording;
import com.ktcn.service.FaultRecordService;

/*
 * 故障记录控制层
 */
@RestController
public class FaultRecordController {
	@Resource
	private FaultRecordService faultRecordService;
	
	// 跳转并查看所有故障记录
	@RequestMapping("FaultRecordAll")
	public List<Error_recording> FaultRecordAll(){
		List<Error_recording> recording = faultRecordService.findAll();
		return recording;
	}
	
	// 按时间查询故障记录
	@RequestMapping("FaultRecord_time")
	public List<Error_recording> FaultRecord_time(String TimeA, String TimeB){
		List<Error_recording> recording = faultRecordService.findByTime(TimeA,TimeB);
		return recording;
	}
	
	// 按照故障机器名称查询
	@RequestMapping(value="FaultRecord",method = RequestMethod.GET)
	public List<Error_recording> getFaultRecordByName(String fault_machine){
		List<Error_recording> recording = faultRecordService.findByName(fault_machine);
		return recording;
	}
	
	// 新增故障记录
	@RequestMapping(value="FaultRecord",method = RequestMethod.POST)
	public String addFaultRecord(Error_recording error_recording){
		System.out.println(error_recording);
		faultRecordService.addFaultRecord(error_recording);
		return "success";
	}
	
	// 删除故障记录
	@RequestMapping(value="FaultRecord",method = RequestMethod.DELETE)
	public String deleteFaultRecord(int id){
		System.out.println(id);
		faultRecordService.deleteFaultRecord(id);
		return "success";
	}
	
	// 修改故障记录
	@RequestMapping(value="FaultRecord",method = RequestMethod.PUT)
	public String updateFaultRecord(Error_recording error_recording){
		System.out.println(error_recording);
		faultRecordService.updateFaultRecord(error_recording);
		return "success";
	}
}
