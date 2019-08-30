package com.ktcn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.OPCDataMasterTable;
import com.ktcn.entity.Data_master_table;

/**
 *历史数据持久层
 *
 */

@Mapper
@Repository
@ComponentScan(basePackages ="com.ktcn.dao.DataMasterTable")
public interface DataMasterTable {
  
	
	
	//@Insert("INSERT INTO data_master_table (dmt_id,VoltageA_1,Electric_currentA_1,Host_temperature_1) VALUES(NULL,#{data_master_table.VoltageA_1},#{data_master_table.Electric_currentA_1},#{data_master_table.Host_temperature_1})")	
	//@InsertProvider(method = "opcdatamaster", type=OPCDataMasterTable.class)
	void OpcDataMasterInsert(Data_master_table data_master_table);
	//void OpcDataMasterInsert(@Param("a") float a,@Param("b") float b,@Param("c") float c);
	
//	@Insert("INSERT INTO 'data_master_table' (dmt_id,VoltageA_1,Electric_currentA_1,Loading_time_1,Unloading_pressure_1) VALUES (NULL,#{data_master_table.VoltageA_1},#{data_master_table.Electric_currentA_1},#{data_master_table.Loading_time_1},#{data_master_table.Unloading_pressure_1})")	
//	@InsertProvider(method = "findAllByTime", type=TestSQL.class)
//	void  OpcDataMasterInsert(@Param("data_master_table") Data_master_table data_master_table);
     
	
//	@Insert("INSERT INTO 'data_master_table' (dmt_id,VoltageA_1,Electric_currentA_1,Loading_time_1,Unloading_pressure_1) VALUES (NULL,#{float1},#{float2},#{float3},#{float4})")	
//	void OpcDataMasterInsert(@Param("float1")Float float1,@Param("float2") Float float2,@Param("float3") Float float3,@Param("float4") Float float4);

	//void OpcDataMasterInsert(Float float1, Float float2, Float float3);

}
