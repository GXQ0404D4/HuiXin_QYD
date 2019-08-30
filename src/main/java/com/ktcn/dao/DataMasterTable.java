package com.ktcn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Data_master_table;

/**
 *历史数据持久层
 *
 */

@Mapper
@Repository
@ComponentScan(basePackages ="com.ktcn.dao.DataMasterTable")
public interface DataMasterTable {
	void OpcDataMasterInsert(Data_master_table data_master_table);
}
