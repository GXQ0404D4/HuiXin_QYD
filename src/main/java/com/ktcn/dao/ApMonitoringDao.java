package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Alarmpatrol;
import com.ktcn.entity.Alarmseteings;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/**
 * 报警巡查实时监控持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface ApMonitoringDao {
	// 查看实时数据表
	@Select("SELECT * FROM `kyj_data_table_temp`")
	List<Kyj_data_table> findtemp();
	
	// 查看报警设置表
	@Select("SELECT * FROM `alarmseteings`")
	List<Alarmseteings> findAll();
	
	// 报警信息写入数据库方法
	@Insert({"<script> insert into `alarmpatrol` " +
            "values " +
            "<foreach collection=\"list\" item=\"Alarmpatrol\" index=\"index\"  separator=\",\"> "+
            "(NULL,#{Alarmpatrol.machine_name},#{Alarmpatrol.ap_name},#{Alarmpatrol.describe},#{Alarmpatrol.measured_value},#{Alarmpatrol.upDiff}," +
            "#{Alarmpatrol.lowDiff},#{Alarmpatrol.ap_time},#{Alarmpatrol.ap_state})"+
            "</foreach> </script>"})
	void writeAlarmpatrol(@Param("list") List<Alarmpatrol> list);
	
}
