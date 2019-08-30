package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.FlowAnalysisSQL;
import com.ktcn.entity.Mian_network;
import com.ktcn.entity.V_chart;

/*
 * 流量曲线分析持久化层
 */
@Mapper
@Repository
public interface FlowAnalysisDao {
	/* MySQL获取当月每个小时数据语句
	 * SELECT HOUR(e.t_time) as Hour,sum(e.num) as Sum FROM test_time e WHERE date_format( e.t_date, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) GROUP BY HOUR(e.t_time) ORDER BY Hour(e.t_time);
	 */
	/* MySQL根据时间区间获取每小时数据语句
	 * SELECT t_date,HOUR(e.t_time) as Hour,sum(e.num) as Sum FROM test_time e WHERE t_date BETWEEN '1970-01-01' AND '2020-01-01' GROUP BY HOUR(e.t_time) ORDER BY Hour(e.t_time);
	 */
	// 查询当天24小时的流量曲线信息,MySQL获取当天每个小时数据语句
	@Select("SELECT HOUR(e.`current_time`) as vTime,sum(e.Instantaneous_flow) as vValue FROM mian_network e WHERE e.`current_date` = (SELECT date_format(now(),'%Y-%m-%d')) GROUP BY HOUR(e.`current_time`) ORDER BY Hour(e.`current_time`)")
	List<V_chart> findByNowDate();
	// 查询当前月流量曲线
	@Select("SELECT DAY(e.`current_time`) as vDay,HOUR(e.`current_time`) as vTime,sum(e.Instantaneous_flow) as vValue FROM mian_network e WHERE date_format( e.`current_date`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) GROUP BY DAY(e.`current_time`),Hour(e.`current_time`) ORDER BY DAY(e.`current_time`),Hour(e.`current_time`)")
	List<V_chart> findByNowMonth();
	// 根据机器查询本月流量曲线
	@Select("SELECT DAY(e.`current_time`) as vDay,HOUR(e.`current_time`) as vTime,sum(e.Instantaneous_flow) as vValue FROM mian_network e WHERE date_format( e.`current_date`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) AND machine = #{machine} GROUP BY DAY(e.`current_time`),Hour(e.`current_time`) ORDER BY DAY(e.`current_time`),Hour(e.`current_time`)")
	List<V_chart> findByMachine(@Param("machine") String machine);
	// 按照时间区间查询
	@SelectProvider(method = "findByTime",type = FlowAnalysisSQL.class)
	List<V_chart> findByTime(@Param("timeA") String timeA, @Param("timeB") String timeB);
	
}
