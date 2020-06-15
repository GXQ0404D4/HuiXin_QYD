package com.ktcn.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.FaultRecordService;

/*
 * 故障记录控制层
 */
@RestController
public class FaultRecordController {
	@Resource
	private FaultRecordService faultRecordService;
	
	// 查看方法
	@RequestMapping("faultFind")
	public Map<String,Object> find(String pageSize,int sizeNum,String falut_summary,String TimeA, String TimeB){
		return faultRecordService.find(pageSize,sizeNum,falut_summary,TimeA, TimeB);
	}
	
	// 新增故障记录
	@RequestMapping(value="FaultRecord",method = RequestMethod.POST)
	@SysLog(logModule = "故障记录", logName = "新增故障记录")
	public String addFaultRecord(HttpServletRequest request,@RequestBody Map<String,String> map){
		
		// 获取当前登录用户信息
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() >= 2) {
			// 调用新增故障记录方法
			faultRecordService.addFaultRecord(map,user);
			return "success";
		} else {
			return null;
		}
	}
	
	// 删除故障记录
	@RequestMapping(value="FaultRecordDelete")
	@SysLog(logModule = "故障记录", logName = "删除故障记录")
	public String deleteFaultRecord(int id,HttpServletRequest request){
		// 获取当前登录用户信息
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() >= 2) {
			faultRecordService.deleteFaultRecord(id);
			return "success";
		} else {
			return null;
		}
	}
	
	// 修改故障记录
	@RequestMapping(value="FaultRecordPut")
	@SysLog(logModule = "故障记录", logName = "修改故障记录")
	public String updateFaultRecord(HttpServletRequest request,@RequestBody Map<String,String> map){
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() >= 1) {
			// 调用修改故障记录方法
			faultRecordService.updateFaultRecord(map,user);
			return "success";
		} else {
			return null;
		}
	}
}
