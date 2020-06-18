package com.ktcn.dao.alarmDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.DryingMachine;

/**
 * 干燥机报警记录持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AldryDao {

	/*
	 * 查询总条数
	 */
	@Select("SELECT COUNT(id) FROM `drying_machine_bj` WHERE GZ_time BETWEEN #{time1} AND #{time2}")
	int findTotal(
			@Param("time1") String time1,
			@Param("time2") String time2);

	/*
	 * 查询数据
	 */
	@Select("SELECT * FROM `drying_machine_bj` WHERE GZ_time BETWEEN #{time1} AND #{time2} ORDER BY GZ_datatime DESC limit #{x},#{sizeNum}")
	List<DryingMachine> find(
			@Param("time1") String time1,
			@Param("time2") String time2,
			@Param("x") int x,
			@Param("sizeNum") int sizeNum);
}
