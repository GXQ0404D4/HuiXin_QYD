package com.ktcn.dao.alarmDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Peripheral_Alarm;

/**
 * 外围仪表报警记录持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AlmeterDao {

	/*
	 * 查询总条数
	 */
	@Select("SELECT COUNT(id) FROM `peripheral_bj` WHERE pdjname LIKE '%${eqName}%' AND pdjtime BETWEEN #{time1} AND #{time2}")
	int findTotal(
			@Param("eqName") String eqName,
			@Param("time1") String time1,
			@Param("time2") String time2);

	/*
	 * 查询数据
	 */
	@Select("SELECT * FROM `peripheral_bj` WHERE pdjname LIKE '%${eqName}%' AND pdjtime BETWEEN #{time1} AND #{time2} ORDER BY pdjdatetime DESC limit #{x},#{sizeNum}")
	List<Peripheral_Alarm> find(
			@Param("eqName") String eqName,
			@Param("time1") String time1,
			@Param("time2") String time2,
			@Param("x") int x,
			@Param("sizeNum") int sizeNum);
}
