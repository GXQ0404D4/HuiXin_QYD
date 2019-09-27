package com.ktcn.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	
	// 获取总条数, 查看系统时效时间轴是否存在初始数据
	@Select("SELECT COUNT(id) FROM `ageing`")
	int getCodeCount();
	
	// 写入初始时间轴
	@Insert("INSERT INTO `ageing` VALUES (NULL,#{date})")
	void writeCode(@Param("date") Date date);

	// 查看最后一个时间轴与当前时间月数差
	@Select("SELECT TIMESTAMPDIFF(MONTH,(SELECT ageTime FROM `ageing` ORDER BY ageTime DESC LIMIT 0,1),DATE_FORMAT(NOW(), '%Y-%m-%d'))")
	int comparisonCode();
	
}
