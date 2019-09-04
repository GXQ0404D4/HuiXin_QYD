package com.ktcn.dao;

import java.util.List;
import java.util.Map;

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
	@Update("UPDATE `alarmseteings` SET position_name=#{map.position_name},"
			+ "`describe`=#{map.describe},measured_value=#{map.measured_value},"
			+ "company=#{map.company},upperlimit=#{map.upperlimit},"
			+ "lowerlimit=#{map.lowerlimit},ULrange=#{map.ULrange},LLlimit=#{map.LLlimit} WHERE ala_id=#{map.ala_id}")
	void updateAlarm(@Param("map") Map<String, String> map);

}
