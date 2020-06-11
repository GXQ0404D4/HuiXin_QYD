package com.ktcn.dao.excelExportDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.siemensentity.Peripheral_Data;
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
	List<ScrewMachine> downloadExcelAir(
			@Param("eqName") String eqName, 
			@Param("time1") String time1, 
			@Param("time2") String time2);

	/*
	 *  干燥机历史数据导出
	 */
	@Select("SELECT * FROM `drying_machine` WHERE GZ_time BETWEEN #{time1} AND #{time2} ORDER BY GZ_datatime DESC")
	List<DryingMachine> downloadExcelDry(
			@Param("time1") String time1, 
			@Param("time2") String time2);

	/*
	 *  外围仪表历史数据导出
	 */
	@Select("SELECT * FROM `peripheral_data` WHERE pddate BETWEEN #{time1} AND #{time2} ORDER BY pddatetime DESC")
	List<Peripheral_Data> downloadExcelMeter(
			@Param("time1") String time1, 
			@Param("time2") String time2);

	// ----------------------- 分割线, 上面是历史数据模块, 下面是报表模块 ---------------------------------
	
	/*
	 * 空压机历史数据导出
	 */
	@Select("SELECT * FROM `screw_machine_hour` WHERE ScrewMachine_name LIKE '%${eqName}%' AND LGJ_time BETWEEN #{time1} AND #{time2} ORDER BY LGJ_datatime DESC")
	List<ScrewMachine> downloadExcelAirh(
			@Param("eqName") String eqName, 
			@Param("time1") String time1, 
			@Param("time2") String time2);
	
	/*
	 *  干燥机历史数据导出
	 */
	@Select("SELECT * FROM `drying_machine_hour` WHERE GZ_time BETWEEN #{time1} AND #{time2} ORDER BY GZ_datatime DESC")
	List<DryingMachine> downloadExcelDryh(
			@Param("time1") String time1, 
			@Param("time2") String time2);

	/*
	 *  外围仪表历史数据导出
	 */
	@Select("SELECT * FROM `peripheral_data` WHERE pddate BETWEEN #{time1} AND #{time2} ORDER BY pddatetime DESC")
	List<Peripheral_Data> downloadExcelMeterh(
			@Param("time1") String time1, 
			@Param("time2") String time2);

}
