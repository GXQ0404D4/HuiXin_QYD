package com.ktcn.dao;

import java.util.List;
import java.util.Map;

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
	// 用户登录验证
	@Select("SELECT * FROM `tb_user` WHERE account = #{map.account} AND `password` = #{map.password} AND `state` = 0")
	Tb_user login(@Param("map") Map<String, String> map);
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
	@Update("UPDATE tb_user SET user_name=#{map.user_name},working_group=#{map.working_group},userPower=#{map.userPower} WHERE user_id=#{map.user_id}")
	void updateUserById(@Param("map") Map<String, String> map);
	// 用户注册功能
	@Insert("INSERT INTO tb_user VALUES (NULL,#{map.account},#{map.password},#{map.name},#{map.sex},#{map.age},#{map.phone},#{map.user_name},#{map.working_group},#{map.createTime},0,#{map.userPower})")
	void addUser(@Param("map") Map<String, String> map);
	// 修改用户密码
	@Update("UPDATE tb_user SET password=#{user.password} WHERE user_id=#{user.user_id}")
	void ChangePassword(@Param("user") Tb_user user);
	
}
