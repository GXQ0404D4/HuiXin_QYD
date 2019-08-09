package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Tb_user;
@Mapper
@Repository
public interface TestDao {
	@Select("select * from tb_user")
	public List<Tb_user> findUser();

}
