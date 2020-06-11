package com.ktcn.dao.report.monthDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.DryingMachine;

/**
 * 干燥机历史数据持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface DryDao {

	/*
	 * 查询总条数
	 */
	@Select("SELECT COUNT(id) FROM `drying_machine`")
	int findTotal();

	/*
	 * 查询数据
	 */
	@Select("SELECT * FROM `drying_machine` WHERE GZ_time BETWEEN #{time1} AND #{time2} ORDER BY GZ_datatime DESC limit #{x},10")
	List<DryingMachine> find(
			@Param("time1") String time1,
			@Param("time2") String time2,
			@Param("x") int x);


}
