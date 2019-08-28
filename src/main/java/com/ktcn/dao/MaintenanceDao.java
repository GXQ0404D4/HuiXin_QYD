package com.ktcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.MaintenanceSQL;
import com.ktcn.entity.Maintenance;
import com.ktcn.entity.Tb_user;

/*
 * 维保记录持久层
 */
@Mapper
@Repository
public interface MaintenanceDao {
	// 新增维保计划
	@Insert("INSERT INTO maintenance (id,mt_plan_time,mt_content,mt_apply_man,mt_num,mt_state,data_state) VALUES (NULL,#{maintenance.mt_plan_time},#{maintenance.mt_content},#{user.name},#{maintenance.mt_num},0,0)")
	void addMaintenance(@Param("maintenance") Maintenance maintenance, @Param("user") Tb_user user);
	// 查看维保计划
	@Select("SELECT * FROM `maintenance` WHERE data_state=0 ORDER BY mt_plan_time DESC")
	List<Maintenance> findAll();
	// 执行维保计划
	@Update("UPDATE `maintenance` SET mt_time=#{maintenance.mt_time},mt_yiliu=#{maintenance.mt_yiliu},mt_personnel=#{maintenance.mt_personnel},mt_state=1,data_state=1 WHERE id=#{maintenance.id}")
	void updateMaintenance(@Param("maintenance") Maintenance maintenance);
	// 查看全部维保记录
	@Select("SELECT * FROM `maintenance` WHERE data_state=1 ORDER BY mt_plan_time DESC")
	List<Maintenance> findAllOrdList();
	// 按时间区间查看维保记录
	@SelectProvider(method = "findByTime",type = MaintenanceSQL.class)
	List<Maintenance> findByTime(@Param("timeA") String timeA, @Param("timeB") String timeB);
	
}
