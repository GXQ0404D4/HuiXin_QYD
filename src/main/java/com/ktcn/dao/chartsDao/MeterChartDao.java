package com.ktcn.dao.chartsDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.Peripheral_Data;

/**
 * 外围仪表折线图持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface MeterChartDao {

	/*
	 * 查询方法
	 */
	@Select("SELECT HOUR(pddatetime) as id," + 
			"SUM(ww0) ww0, " + 
			"SUM(ww7) ww7, " + 
			"SUM(ww14) ww14," + 
			"SUM(ww22) ww21," + 
			"SUM(ww24) ww24," + 
			"SUM(ww27) ww27," + 
			"SUM(ww30) ww30," + 
			"SUM(ww37) ww37, " + 
			"SUM(ww44) ww44, " + 
			"SUM(ww51) ww51, " + 
			"SUM(ww58) ww58, " + 
			"SUM(ww65) ww65, " + 
			"SUM(ww72) ww72," + 
			"SUM(ww79) ww79 " + 
			"FROM peripheral_data e "
			+ "WHERE TO_DAYS(pddatetime) = TO_DAYS(NOW()) "
//			+ "WHERE e.pddate = '2020-06-10' "
			+ "GROUP BY HOUR(e.pddatetime) "
			+ "ORDER BY Hour(e.pddatetime);")
	List<Peripheral_Data> find();

}
