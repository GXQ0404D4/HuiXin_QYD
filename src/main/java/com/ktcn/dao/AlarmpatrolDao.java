package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.AlarmpatrolSQL;
import com.ktcn.entity.Alarmpatrol;

/**
 * 报警巡查持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AlarmpatrolDao {
	
	// 查询全部报警巡查信息
	@Select("SELECT * FROM `alarmpatrol` ORDER BY ap_id DESC LIMIT 0,50")
	List<Alarmpatrol> apFindAll();
	// 按照时间区间查询报警巡查信息
	@SelectProvider(method = "findByTime",type = AlarmpatrolSQL.class)
	List<Alarmpatrol> apFindByTime(String timeA, String timeB);
	
}
