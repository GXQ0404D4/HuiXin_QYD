package com.ktcn.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ProductionDao;
import com.ktcn.entity.Production_plan;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.ProductionService;
import com.ktcn.utils.PageReade;
/*
 * 生产管理业务层实现类
 */
@Service
@Transactional
public class ProductionServiceImpl implements ProductionService {
	@Resource
	private ProductionDao productionDao;
	
	// 查询方法
	@Override
	public Map<String, Object> find(String pageSize, int sizeNum, String pdt_people, String timeA, String timeB) {
		// 判断如果pageSize为NULL则pageSize为0
		if (pageSize == null) {
			pageSize = "1";
		}
		if ("".equals(timeA) || timeA == null) {
			timeA = "1970-01-01";
		}
		if ("".equals(timeB) || timeB == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			timeB = format.format(new Date());
		}
		// 转换页数参数类型
		int i = Integer.parseInt(pageSize);
		// 获取查询起始条数
		int x = 0;
		// 查询数据总条数
		int count = 0;
		// 获取总页数
		int countPage = 0;
		
		// 查询数据总条数
		count = productionDao.findTotal(pdt_people,timeA,timeB);
		// 获取总页数
		countPage = PageReade.getCountPage(count, sizeNum);
		// 获取查询起始条数
		x = PageReade.getPageSize(i, count, sizeNum);
		// 获取数据
		List<Production_plan> list = productionDao.find(pdt_people,timeA,timeB,x,sizeNum);
		
		// 新建一个map集合承接返回数据
		Map<String,Object> reMap = new HashMap<String,Object>();
		reMap.put("code", "1");
		reMap.put("message", "操作成功");
		reMap.put("totalpage", countPage); // 总页数
		reMap.put("totalmess", count); // 总条数
		reMap.put("pageSize", PageReade.getPageNum(i, count, sizeNum)); // 当前页数
		reMap.put("data", list);
		
		return reMap;
	}
	
	// 新增生产管理
	@Override
	public void addProduction(Map<String, String> map, Tb_user user) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("pdt_time", format.format(new Date()));
		productionDao.addProduction(map,user);
	}
	// 生产管理汇报
	@Override
	public void ProToReport(Map<String, String> map, Tb_user user) {
		productionDao.ProToReport(map,user);
	}
	// 生产管理审批
	@Override
	public void ProToApprove(int id) {
		productionDao.ProToApprove(id);
	}
	
}
