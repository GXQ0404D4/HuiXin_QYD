package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Log;

@Repository
@Mapper
public interface TestDao {
	@Select("select * from log limit #{total},#{pageSize}")
	List<Log> findByPage(@Param("total") int total, @Param("pageSize") int pageSize);

}
