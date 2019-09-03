package com.ktcn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Log;

/**
 * 操作日志持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface LogDao {
	// 添加操作日志
	@Insert("INSERT INTO log VALUES (NULL,#{log.user_id},#{log.user},#{log.operTime},#{log.operModel},#{log.operName},#{log.userIp})")
	void addUserLog(@Param("log") Log log);
	
}
