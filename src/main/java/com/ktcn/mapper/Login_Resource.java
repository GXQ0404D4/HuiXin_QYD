package com.ktcn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Tb_resource;

@Mapper
@Repository
public interface Login_Resource {
	
	Tb_resource getResource();
    @Select("select * from tb_resource where res_id=#{user_id}")
	List<Tb_resource> findPermissionByUid(@Param("user_id") int user_id);

}
