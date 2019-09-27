package com.ktcn.service.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.AgeingDao;
import com.ktcn.entity.Ageing;
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
	
	// 获取最后一条时间轴信息
	@Override
	public Ageing getLastCode() {
		return ageingDao.getLastCode();
	}

	// 获取总条数, 查看系统时效时间轴是否存在初始数据
	@Override
	public int getCodeCount() {
		return ageingDao.getCodeCount();
	}

	// 写入初始时间轴
	@Override
	public void writeInitialCode() {
		// 获取时间轴表总条数
		int count = this.getCodeCount();
		// 若无数据则写入初始时间轴数据
		if (count == 0) {
			ageingDao.writeCode(new Date());
		}
	}
	// 写入单次时间轴数据
	@Override
	public void writeOnceCode() {
		ageingDao.writeCode(new Date());
	}
	
	
}
