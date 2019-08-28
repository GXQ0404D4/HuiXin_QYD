package com.ktcn.dao;

import java.util.List;

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
	// 查看全部生产管理表信息
	@Select("SELECT * FROM `production_plan` ORDER BY pdt_time DESC")
	List<Production_plan> findAll();
	// 生产管理条件搜索
	@Select("SELECT * FROM production_plan WHERE pdt_people LIKE '%${pdt_select}%'")
	List<Production_plan> findByParam(@Param("pdt_select") String pdt_select);
	// 生产管理时间区间查询
	@SelectProvider(method = "findByTime",type = ProductionSQL.class)
	List<Production_plan> findByTime(@Param("pdt_selecttimeA") String pdt_selecttimeA, @Param("pdt_selecttimeB") String pdt_selecttimeB);
	// 新增生产管理
	@Insert("INSERT INTO production_plan (id,pdt_time,pdt_content,pdt_people_id,pdt_people,pdt_state,op_state,data_state) "
			+ "VALUES (NULL,#{production.pdt_time},#{production.pdt_content},#{user.user_id},#{user.name},#{production.pdt_state},0,0)")
	void addProduction(@Param("production") Production_plan production,@Param("user") Tb_user user);
	// 生产管理汇报
	@Update("UPDATE production_plan SET pdt_report=#{production.pdt_report},pdt_Executor=#{production.pdt_Executor},op_state=1 WHERE id=#{production.id}")
	void ProToReport(@Param("production") Production_plan production);
	// 生产管理审批
	@Update("UPDATE production_plan SET op_state=2,data_state=1 WHERE id=#{id}")
	void ProToApprove(@Param("id") int id);
	
}
