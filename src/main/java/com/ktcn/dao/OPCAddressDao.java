package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Opc_address;
@Repository
@Mapper
public interface OPCAddressDao {
	
	@Select("SELECT * FROM opc_address")
	public List<Opc_address> GetALLAddress();
	
	

}
