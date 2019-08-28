package com.ktcn.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ProductionDao;
import com.ktcn.entity.Production_plan;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.ProductionService;
/*
 * 生产管理业务层实现类
 */
@Service
@Transactional
public class ProductionServiceImpl implements ProductionService {
	@Resource
	private ProductionDao productionDao;
	// 查看全部生产管理表信息
	@Override
	public List<Production_plan> findAll() {
		return productionDao.findAll();
	}
	// 生产管理条件搜索
	@Override
	public List<Production_plan> findByParam(String pdt_select) {
		return productionDao.findByParam(pdt_select);
	}
	// 生产管理时间区间查询
	@Override
	public List<Production_plan> findByTime(String pdt_selecttimeA, String pdt_selecttimeB) {
		return productionDao.findByTime(pdt_selecttimeA,pdt_selecttimeB);
	}
	// 新增生产管理
	@Override
	public void addProduction(Production_plan production, Tb_user user) {
		production.setPdt_time(new Date());
		productionDao.addProduction(production,user);
	}
	// 生产管理汇报
	@Override
	public void ProToReport(Production_plan production) {
		productionDao.ProToReport(production);
	}
	// 生产管理审批
	@Override
	public void ProToApprove(int id) {
		productionDao.ProToApprove(id);
	}
	
}
