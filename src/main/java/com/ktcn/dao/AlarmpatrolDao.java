package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.AlarmpatrolSQL;
import com.ktcn.entity.Alarmpatrol;

/**
 * 报警巡查持久层
 * 
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AlarmpatrolDao {

	// 查询数据总条数
	@Select("SELECT COUNT(ap_id) FROM alarmpatrol")
	int findTotal();
	// 分页查询-查询全部
	@Select("SELECT * FROM alarmpatrol ORDER BY `ap_time` DESC limit #{total},10")
	List<Alarmpatrol> findAllByIndex(@Param("total") int total);

	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = AlarmpatrolSQL.class)
	int findCountByTime(String timeA, String timeB);
	// 根据时间区间查询空压机报表信息
	@SelectProvider(method = "findByTime", type = AlarmpatrolSQL.class)
	List<Alarmpatrol> findByTime(String timeA, String timeB, int total);

	@Select("SELECT * FROM alarmpatrol ORDER BY `ap_time` DESC limit 0,10000")
	List<Alarmpatrol> findExport();
}
