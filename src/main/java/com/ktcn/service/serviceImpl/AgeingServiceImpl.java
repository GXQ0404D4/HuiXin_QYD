package com.ktcn.service.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.AgeingDao;
import com.ktcn.service.AgeingService;
/**
 * 系统运行时效业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class AgeingServiceImpl implements AgeingService {
	
	@Resource
	private AgeingDao ageingDao;

	// 获取总条数, 查看系统时效时间轴是否存在初始数据
	@Override
	public int getCodeCount() {
		return ageingDao.getCodeCount();
	}

	// 写入初始时间轴
	@Override
	public void writeInitialCode() {
		// 获取时间轴表总条数,若无数据则写入初始时间轴数据
		if (this.getCodeCount() == 0) {
			ageingDao.writeCode(new Date());
		}
	}
	// 写入单次时间轴数据
	@Override
	public void writeOnceCode() {
		ageingDao.writeCode(new Date());
	}

	// 用户登录调用此方法, 查看系统运行是否超时
	@Override
	public Map<String, String> comparisonCode() {
		// 创建一个Map集合用来保存返回信息
		Map<String,String> map = new HashMap<String,String>();
		// 查看最后一个时间轴与当前时间月数差
		int i = ageingDao.comparisonCode();
		// 判断时间是否超时
    	if (i <= 3) {
    		map.put("code","0000");
    		map.put("message","未超时效");
		} else {
			map.put("code","0001");
    		map.put("message","已超时效");
		}
		return map;
	}
	
	
}
