package com.ktcn.dao.chartsDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.DryingMachine;

/**
 * 干燥机折线图持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface DryChartDao {

	/*
	 * 查询方法
	 */
	@Select("SELECT HOUR(GZ_datatime) as id," + 
			"SUM(GZJ0) GZJ0," + 
			"SUM(GZJ1) GZJ1," + 
			"SUM(GZJ2) GZJ2," + 
			"SUM(GZJ3) GZJ3," + 
			"SUM(GZJ4) GZJ4," + 
			"SUM(GZJ5) GZJ5 " + 
			"FROM drying_machine e "
//			+ "WHERE TO_DAYS(GZ_datatime) = TO_DAYS(NOW()) "
			+ "WHERE e.GZ_time = '2020-06-10' "
			+ "GROUP BY HOUR(e.GZ_datatime) "
			+ "ORDER BY Hour(e.GZ_datatime);")
	List<DryingMachine> find();

}
