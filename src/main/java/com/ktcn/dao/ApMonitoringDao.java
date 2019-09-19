package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Alarmpatrol;
import com.ktcn.entity.Alarmseteings;
import com.ktcn.entity.Real_time_data;

/**
 * 报警巡查实时监控持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface ApMonitoringDao {
	// 查看实时数据表
	@Select("SELECT * FROM `real_time_data`")
	Real_time_data findReal();
	
	// 查看报警设置表
	@Select("SELECT * FROM `alarmseteings`")
	List<Alarmseteings> findAll();
	// 报警信息写入数据库方法
	@Insert({"<script> insert into `alarmpatrol` " +
            "values " +
            "<foreach collection=\"list\" item=\"Alarmpatrol\" index=\"index\"  separator=\",\"> "+
            "(NULL,#{Alarmpatrol.ap_name},#{Alarmpatrol.describe},#{Alarmpatrol.measured_value},#{Alarmpatrol.upDiff}," +
            "#{Alarmpatrol.lowDiff},#{Alarmpatrol.ap_time},#{Alarmpatrol.ap_state})"+
            "</foreach> </script>"})
	void writeAlarmpatrol(@Param("list") List<Alarmpatrol> list);
	
	// 将报警信息写入数据库表中
	/*
	@Insert({"<script> insert into user_coupon(user_id,coupon_id,total_count," +
            "memo,start_time,end_time,create_time,type) " +
            "values " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\"  separator=\",\"> "+
            "(#{item.userId},#{item.couponId},#{item.totalCount}," +
            "#{item.memo},#{item.startTime},#{item.endTime},#{item.createTime},#{item.type})"+
            "</foreach> </script>"})
    Integer saveUserCouponList(@Param("list") List<Map<String, Object>> list);
    */
	
}
