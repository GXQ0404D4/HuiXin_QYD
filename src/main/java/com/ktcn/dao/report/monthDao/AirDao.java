package com.ktcn.dao.report.monthDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ScrewMachine;

/**
 * 空压机历史数据持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AirDao {

	/*
	 * 查询总条数
	 */
	@Select("SELECT COUNT(id) FROM `screw_machine` WHERE ScrewMachine_name LIKE '%${eqName}%'")
	int findTotal(@Param("eqName") String eqName);

	/*
	 * 查询数据
	 */
	@Select("SELECT * FROM `screw_machine` WHERE ScrewMachine_name LIKE '%${eqName}%' AND LGJ_time BETWEEN #{time1} AND #{time2} ORDER BY LGJ_datatime DESC limit #{x},10")
	List<ScrewMachine> find(
			@Param("eqName") String eqName,
			@Param("time1") String time1,
			@Param("time2") String time2,
			@Param("x") int x);

}
