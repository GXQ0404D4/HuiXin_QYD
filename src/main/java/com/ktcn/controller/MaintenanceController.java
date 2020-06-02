package com.ktcn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Maintenance;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.AgeingService;
import com.ktcn.service.MaintenanceService;
import com.ktcn.utils.MD5Util;

/*
 * 维保记录控制层
 */
@RestController
public class MaintenanceController {
	@Resource
	private MaintenanceService maintenanceService;
	@Resource
	private AgeingService ageingService;
	// 获取维保申请码
	@RequestMapping("getMtCode")
	public String getMtCode(HttpServletRequest request) {
		// 获取随机码
		String s = MD5Util.getUUID();
		// 截取前6位
		String str = s.substring(0, 6);
		// 调用生成维保码方法
		mtCode(str,request);
		
		return str;
	}
	// 生成维保码
	private void mtCode(String str,HttpServletRequest request) {
		// 获取当前日期
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
		String date = format.format(new Date());
		// 加盐
		String s1 = date + str + "qyd";
		// 生成维保码
		String string = MD5Util.encodeByMd5_32(s1);
		// 截取前十位
		String s2 = string.substring(0, 10);
		System.out.println(s2);
		// 获取session
		HttpSession session = request.getSession();
		// 存入维保码
		session.setAttribute("mtCode", s2);
	}
	
	// 新增维保计划
	@RequestMapping("MtcApply")
	@SysLog(logModule = "维保记录", logName = "新增维保计划")
	public String MtcApply(@RequestBody Map<String,String> map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 判断用户输入维保码是否有效
		if (session.getAttribute("mtCode").equals(map.get("mt_num"))) {
			System.out.println(session.getAttribute("mtCode"));
			System.out.println(map.get("mt_num")+"--- 维保码");
			// 获取当前用户
			Tb_user user = (Tb_user) session.getAttribute("nowuser");
			if (user.getUserPower() >= 2) {
				// 调用新增维保计划方法
				maintenanceService.addMaintenance(map,user);
				return "success";
			} else {
				return null;
			}
		} else {
			return "error";
		}
	}
	
	// 查看全部维保记录
	@RequestMapping("MtcRecords")
	@SysLog(logModule = "维保记录", logName = "查看维保记录")
	public List<Maintenance> MtcRecords() {
		List<Maintenance> maintenance = maintenanceService.findAllOrdList();
		return maintenance;
	}
	
	// 按时间区间查看维保记录
	@RequestMapping("MtcRecords_time")
	@SysLog(logModule = "维保记录", logName = "时间区间查看维保记录")
	public List<Maintenance> MtcRecords_time(String TimeA, String TimeB) {
		List<Maintenance> maintenance = maintenanceService.findByTime(TimeA,TimeB);
		return maintenance;
	}
}
