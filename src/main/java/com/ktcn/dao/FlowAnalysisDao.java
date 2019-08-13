package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.FlowAnalysisSQL;
import com.ktcn.entity.Mian_network;

/*
 * 流量曲线分析持久化层
 */
@Mapper
@Repository
public interface FlowAnalysisDao {
	// 查询当天24小时的电量曲线信息
	@Select("SELECT * FROM `mian_network` WHERE date(`mian_network`.`current_time`) = curdate()")
	List<Mian_network> findByNowDate();
	// 查询当前月流量曲线
	@Select("SELECT * FROM `mian_network` WHERE date_format( `current_time`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' )")
	List<Mian_network> findByNowMonth();
	// 根据机器查询本月流量曲线
	@Select("SELECT * FROM `mian_network` WHERE date_format( `current_time`, '%Y%m' ) = date_format(curdate( ) , '%Y%m' ) AND machine = #{machine}")
	List<Mian_network> findByMachine(@Param("machine") String machine);
	// 按照时间区间查询
	@SelectProvider(method = "findByTime",type = FlowAnalysisSQL.class)
	List<Mian_network> findByTime(@Param("timeA") String timeA, @Param("timeB") String timeB);
	
}
