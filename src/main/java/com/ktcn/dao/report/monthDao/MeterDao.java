package com.ktcn.dao.report.monthDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.Peripheral_Data;

/**
 * 外围仪表持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface MeterDao {

	/*
	 * 查询总条数
	 */
	@Select("SELECT COUNT(id) FROM `peripheral_data` WHERE pddate BETWEEN #{time1} AND #{time2}")
	int findTotal(
			@Param("time1") String time1,
			@Param("time2") String time2);

	/*
	 * 查询数据
	 */
	@Select("SELECT * FROM `peripheral_data` WHERE pddate BETWEEN #{time1} AND #{time2} ORDER BY pddatetime DESC limit #{x},10")
	List<Peripheral_Data> find(
			@Param("time1") String time1,
			@Param("time2") String time2,
			@Param("x") int x);
}
