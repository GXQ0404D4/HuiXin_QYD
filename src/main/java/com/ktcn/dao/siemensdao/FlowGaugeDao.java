package com.ktcn.dao.siemensdao;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:51:09
* 类说明  流量计 PLC 数据获取
*/

import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.FlowGauge;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
@Repository
public interface FlowGaugeDao {

	//持久化到流量计数据表
	@Insert("INSERT INTO flow_gauge (LLJ2,LLJ3,LLJ4,LLJ5,LLJ_time,LLJ_datatime,state,FlowGauge_name) VALUES"
			+ "(#{fg.LLJ2},#{fg.LLJ3},#{fg.LLJ4},#{fg.LLJ5},NOW(),NOW(),1,#{fg.FlowGauge_name})")
	void setFlowGaugeData(@Param("fg") FlowGauge fg);

	//持久化到小时数据表 流量计数据表
	@Insert("INSERT INTO flow_gauge_hour (LLJ2,LLJ3,LLJ4,LLJ5,LLJ_time,LLJ_datatime,state,FlowGauge_name) VALUES"
			+ "(#{fg.LLJ2},#{fg.LLJ3},#{fg.LLJ4},#{fg.LLJ5},NOW(),NOW(),1,#{fg.FlowGauge_name})")
	void setFlowGaugeDataHour(@Param("fg") FlowGauge fg);
}
