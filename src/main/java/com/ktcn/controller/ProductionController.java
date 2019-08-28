package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Production_plan;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.ProductionService;

/*
 * 生产管理控制层
 */
@RestController
public class ProductionController {
	@Resource
	private ProductionService productionService;
	
	// 查看全部生产管理表信息
	@RequestMapping("ProdactionMgt")
	public List<Production_plan> ProdactionMgt() {
		List<Production_plan> production = productionService.findAll();
		return production;
	}
	
	// 生产管理条件搜索
	@RequestMapping("Prodaction_select")
	public List<Production_plan> Prodaction_select(String Pdt_select) {
		List<Production_plan> production = productionService.findByParam(Pdt_select);
		return production;
	}
	
	// 生产管理时间区间查询
	@RequestMapping("Prodaction_time")
	public List<Production_plan> Prodaction_time(String Pdt_selecttimeA, String Pdt_selecttimeB) {
		List<Production_plan> production = productionService.findByTime(Pdt_selecttimeA,Pdt_selecttimeB);
		return production;
	}
	
	// 新增生产管理
	@RequestMapping("Prodaction")
	public String Prodaction(Production_plan production, HttpServletRequest request) {
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		// 调用新增生产管理方法
		productionService.addProduction(production,user);
		return "success";
	}
	
	// 生产管理汇报
	@RequestMapping("ProToReport")
	public String ProToReport(Production_plan production, HttpServletRequest request) {
		// 调用生产管理汇报方法
		productionService.ProToReport(production);
		return "success";
	}
	
	// 生产管理审批
	@RequestMapping("ProToApprove")
	public String ProToApprove(int id, int pdt_people_id, HttpServletRequest request) {
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		// 判断此信息是否是当前用户发布的,是则执行,不是则返回error
		if (user.getUser_id() == pdt_people_id) {
			// 判断成功则调用生产管理审批方法
			productionService.ProToApprove(id);
			return "success";
		}
		return "error";
	}
}
