package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Tb_user;

/*
 * 用户管理持久层
 */
@Mapper
@Repository
public interface UserDao {
	// 查看现有全部用户
	@Select("SELECT * FROM `tb_user` WHERE state=0 ORDER BY createTime DESC")
	List<Tb_user> findAllUser();
	// 删除用户
	@Update("UPDATE `tb_user` SET state=1 WHERE user_id = #{id}")
	void deleteUserById(@Param("id") int id);
	// 条件查询用户
	@Select("SELECT * FROM `tb_user` WHERE account LIKE '%${vague}%' OR name LIKE '%${vague}%' OR user_name LIKE '%${vague}%' OR working_group LIKE '%${vague}%'")
	List<Tb_user> findUserByVague(@Param("vague") String vague);
	// 修改用户信息
	@Update("UPDATE tb_user SET user_name=#{user.user_name},working_group=#{user.working_group} WHERE user_id=#{user.user_id}")
	void updateUserById(@Param("user") Tb_user user);
	// 用户注册功能
	@Insert("INSERT INTO tb_user VALUES (NULL,#{user.account},#{user.password},#{user.name},#{user.sex},#{user.age},#{user.phone},#{user.user_name},#{user.working_group},#{user.createTime},0)")
	void addUser(@Param("user") Tb_user user);
	
}
