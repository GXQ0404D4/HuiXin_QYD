package com.ktcn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Tb_role;
@Mapper
@Repository
public interface Login_Role {

	Tb_role getRole();
	
	
	@Select("select * from tb_role where role_id =#{user_id}")
	List<Tb_role> findRoleByUid(@Param("user_id") int user_id);
}
