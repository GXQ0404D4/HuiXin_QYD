package com.ktcn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Tb_user;

@Mapper
@Repository
public interface Login_Mapper  {
  
	//登录
	//@Select("select * from tb_user")
	List<Tb_user> LoginUser();
	
	@Select("select * from tb_user where account =#{username}")
	Tb_user findByName(@Param("username") String username);
	
}
