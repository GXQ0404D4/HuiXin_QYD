package com.ktcn.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/*
 * 监控页面持久层
 */
@Mapper
@Repository
public interface MonitoringDao {

	
	void OpcDataMasterInsert(ArrayList<Boolean> sl, ArrayList<Float> fl);
}