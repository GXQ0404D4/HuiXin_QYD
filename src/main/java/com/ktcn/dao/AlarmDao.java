package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Alarmseteings;

/*
 * 报警设置持久层
 */
@Mapper
@Repository
public interface AlarmDao {
	// 查看报警设置
	@Select("SELECT * FROM `alarmseteings`")
	List<Alarmseteings> findAll();
	// 修改报警设置
	@Update("UPDATE `alarmseteings` SET position_name=#{alarm.position_name},"
			+ "`describe`=#{alarm.describe},measured_value=#{alarm.measured_value},"
			+ "company=#{alarm.company},upperlimit=#{alarm.upperlimit},"
			+ "lowerlimit=#{alarm.lowerlimit},ULrange=#{alarm.ULrange},LLlimit=#{alarm.LLlimit} WHERE ala_id=#{alarm.ala_id}")
	void updateAlarm(@Param("alarm") Alarmseteings alarm);

}
