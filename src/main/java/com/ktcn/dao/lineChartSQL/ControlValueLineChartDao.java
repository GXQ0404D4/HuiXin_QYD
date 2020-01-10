package com.ktcn.dao.lineChartSQL;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午3:12:49
* 类说明 类说明  调节阀(曲线分析) 折线图controller层
*/
@Repository
@Mapper
public interface ControlValueLineChartDao {

	@Select("SELECT ${tJF} FROM control_valve_hour WHERE TJF_time= CURDATE()")
	public List<Float> getControlValueData(@Param("tJF") String tJF) ;
	
//	@Select("SELECT TJF6 FROM control_valve_hour WHERE TJF_time= CURDATE()")
//	public List<Float> getControlValueData2(@Param("tJF") String tJF) ;

}
