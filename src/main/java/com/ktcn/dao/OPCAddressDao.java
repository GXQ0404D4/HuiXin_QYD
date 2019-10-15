package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Opc_address;
@Repository
@Mapper
public interface OPCAddressDao {
	
	
	@Select("SELECT tag_name FROM opc_address WHERE type=1")
	public List<String> GetALLAddress();
	
	@Select("SELECT tag_name FROM opc_address WHERE type in (2,3)")
	public List<String> GetSwitchAddress();
	
	

}
