package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Opc_address;
@Mapper
@Repository
public interface OPCAddressDao {
	@Select("SELECT * FROM opc_address")
	List<Opc_address> GetALLAddress();

}
