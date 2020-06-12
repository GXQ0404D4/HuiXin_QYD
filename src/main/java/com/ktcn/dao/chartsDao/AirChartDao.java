package com.ktcn.dao.chartsDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ScrewMachine;

/**
 * 空压机折线图持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface AirChartDao {

	/*
	 * 查询方法
	 */
	@Select("SELECT HOUR(LGJ_datatime) as id," + 
			"SUM(LGJ0) LGJ0," + 
			"SUM(LGJ1) LGJ1," + 
			"SUM(LGJ2) LGJ2," + 
			"SUM(LGJ3) LGJ3," + 
			"SUM(LGJ4) LGJ4," + 
			"SUM(LGJ5) LGJ5," + 
			"SUM(LGJ6) LGJ6 " + 
			"FROM screw_machine e "
			+ "WHERE e.LGJ_time = '2020-06-10' "
//			+ "WHERE TO_DAYS(LGJ_datatime) = TO_DAYS(NOW()) "
			+ "AND ScrewMachine_name = #{eqName} "
			+ "GROUP BY HOUR(e.LGJ_datatime) "
			+ "ORDER BY Hour(e.LGJ_datatime)")
	List<ScrewMachine> find(@Param("eqName") String eqName);

}
