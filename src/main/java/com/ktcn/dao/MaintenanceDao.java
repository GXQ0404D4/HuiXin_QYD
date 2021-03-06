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
	@Insert("INSERT INTO maintenance (id,mt_time,mt_content,mt_man,mt_num,state) VALUES (NULL,#{map.mt_time},#{map.mt_content},#{user.name},#{map.mt_num},0)")
	void addMaintenance(@Param("map") Map<String, String> map, @Param("user") Tb_user user);
	// 查看全部维保记录
	@Select("SELECT * FROM `maintenance` ORDER BY mt_time DESC")
	List<Maintenance> findAllOrdList();
	// 按时间区间查看维保记录
	@SelectProvider(method = "findByTime",type = MaintenanceSQL.class)
	List<Maintenance> findByTime(@Param("timeA") String timeA, @Param("timeB") String timeB);
	
}
