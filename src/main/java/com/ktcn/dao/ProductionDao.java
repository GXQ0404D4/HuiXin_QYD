package com.ktcn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.ProductionSQL;
import com.ktcn.entity.Production_plan;
import com.ktcn.entity.Tb_user;

/*
 * 生产管理表持久类
 */
@Mapper
@Repository
public interface ProductionDao {
	// 查询总条数
	@Select("SELECT COUNT(id) FROM `production_plan` "
			+ "WHERE pdt_people LIKE '%${pdt_people}%' "
			+ "AND pdt_time BETWEEN #{timeA} AND #{timeB}")
	int findTotal(
			@Param("pdt_people") String pdt_people, 
			@Param("timeA") String timeA, 
			@Param("timeB") String timeB);
	// 查询数据
	@Select("SELECT * FROM `production_plan` "
			+ "WHERE pdt_people LIKE '%${pdt_people}%' "
			+ "AND pdt_time BETWEEN #{timeA} AND #{timeB} "
			+ "ORDER BY pdt_time DESC "
			+ "limit #{x},#{sizeNum}")
	List<Production_plan> find(
			@Param("pdt_people") String pdt_people, 
			@Param("timeA") String timeA, 
			@Param("timeB") String timeB, 
			@Param("x") int x, 
			@Param("sizeNum") int sizeNum);
	
	// 新增生产管理
	@Insert("INSERT INTO production_plan (id,pdt_time,pdt_content,pdt_people_id,pdt_people,pdt_state,op_state,data_state) "
			+ "VALUES (NULL,#{map.pdt_time},#{map.pdt_content},#{user.user_id},#{user.name},#{map.pdt_state},0,0)")
	void addProduction(@Param("map") Map<String, String> map,@Param("user") Tb_user user);
	// 生产管理汇报
	@Update("UPDATE production_plan SET pdt_report=#{map.pdt_report},pdt_Executor=#{user.name},op_state=1 WHERE id=#{map.id}")
	void ProToReport(@Param("map") Map<String, String> map,@Param("user") Tb_user user);
	// 生产管理审批
	@Update("UPDATE production_plan SET op_state=2,data_state=1 WHERE id=#{id}")
	void ProToApprove(@Param("id") int id);
	
}
