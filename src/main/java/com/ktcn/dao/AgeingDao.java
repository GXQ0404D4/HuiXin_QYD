package com.ktcn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Ageing;

/**
 * 系统运行时效持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AgeingDao {
	// 获取最后一条时间轴信息
	@Select("SELECT * FROM `ageing` ORDER BY ageTime DESC LIMIT 0,1")
	Ageing getLastCode();
	
}
