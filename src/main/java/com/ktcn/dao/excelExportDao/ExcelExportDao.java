package com.ktcn.dao.excelExportDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ScrewMachine;

/**
 * 导出Excel持久层
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface ExcelExportDao {

	/*
	 *  空压机历史数据导出
	 */
	@Select("SELECT * FROM `screw_machine` WHERE ScrewMachine_name LIKE '%${eqName}%' AND LGJ_time BETWEEN #{time1} AND #{time2} ORDER BY LGJ_datatime DESC")
	List<ScrewMachine> downloadExcelParts(
			@Param("eqName") String eqName, 
			@Param("time1") String time1, 
			@Param("time2") String time2);

}
