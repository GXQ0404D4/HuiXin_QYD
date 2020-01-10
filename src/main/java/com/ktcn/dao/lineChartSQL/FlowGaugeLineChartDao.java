package com.ktcn.dao.lineChartSQL;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午4:42:38
* 类说明 曲线分析流量计数据获取
*/
@Repository
@Mapper
public interface FlowGaugeLineChartDao {

	@Select("SELECT LLJ2 FROM flow_gauge_hour WHERE LLJ_time= CURDATE() and FlowGauge_name=#{lLJ}")
	public List<Float> getFlowGaugeLineChartData(@Param("lLJ")String lLJ) ;

	

}
