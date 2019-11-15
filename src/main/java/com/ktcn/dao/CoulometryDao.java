package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.CoulometrySQL;
import com.ktcn.entity.V_chart;

/*
 * 电量曲线分析持久层
 */
@Mapper
@Repository
public interface CoulometryDao {
	// 查询当天24小时的电量曲线信息
//	@Select("SELECT HOUR(e.`current_time`) as vTime,sum(e.electric_quantity) as vValue FROM electric_massage e WHERE e.`current_date` = (SELECT date_format(now(),'%Y-%m-%d')) GROUP BY HOUR(e.`current_time`) ORDER BY Hour(e.`current_time`)")
	@Select("SELECT DATE_FORMAT(e.`current_time`,'%Y-%m-%d %H:00') as vTime,sum(e.electric) as vValue FROM kyj_data_hour e WHERE e.`current_date` = (SELECT date_format(now(),'%Y-%m-%d')) GROUP BY HOUR(e.`current_time`) ORDER BY Hour(e.`current_time`)")
	List<V_chart> findByNowDate();
	// 查询本月流量曲线
//	@Select("SELECT DAY(e.`current_time`) as vDay,HOUR(e.`current_time`) as vTime,sum(e.electric_quantity) as vValue FROM electric_massage e WHERE date_format( e.`current_date`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) GROUP BY DAY(e.`current_time`),Hour(e.`current_time`) ORDER BY DAY(e.`current_time`),Hour(e.`current_time`)")
	@Select("SELECT DATE_FORMAT(e.`current_time`,'%Y-%m-%d %H:00') as vTime,sum(e.electric) as vValue FROM kyj_data_hour e WHERE date_format( e.`current_date`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) GROUP BY DAY(e.`current_time`),Hour(e.`current_time`) ORDER BY DAY(e.`current_time`),Hour(e.`current_time`)")
	List<V_chart> findByNowMonth();
	// 根据机器查询本月流量曲线
//	@Select("SELECT DAY(e.`current_time`) as vDay,HOUR(e.`current_time`) as vTime,sum(e.electric_quantity) as vValue FROM electric_massage e WHERE date_format( e.`current_date`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) AND machine = #{machine} GROUP BY DAY(e.`current_time`),Hour(e.`current_time`) ORDER BY DAY(e.`current_time`),Hour(e.`current_time`)")
	@Select("SELECT DATE_FORMAT(e.`current_time`,'%Y-%m-%d %H:00') as vTime,sum(e.electric) as vValue FROM kyj_data_hour e WHERE date_format( e.`current_date`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) AND e.machine_name = #{machine} GROUP BY DAY(e.`current_time`),Hour(e.`current_time`) ORDER BY DAY(e.`current_time`),Hour(e.`current_time`)")
	List<V_chart> findByMachine(@Param("machine") String machine);
	// 按照时间区间查询
	@SelectProvider(method = "findByTime",type =CoulometrySQL.class)
	List<V_chart> findByTime(@Param("timeA") String timeA, @Param("timeB") String timeB);
	
}