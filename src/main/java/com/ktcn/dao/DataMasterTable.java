package com.ktcn.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *历史数据持久层
 *
 */
@Mapper
@Repository
public interface DataMasterTable {
  
	void OpcDataMasterInsert(ArrayList<Boolean> sl, ArrayList<Float> fl);

}
