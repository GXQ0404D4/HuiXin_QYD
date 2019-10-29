package com.ktcn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.FaultRecordSQL;
import com.ktcn.entity.Error_recording;
import com.ktcn.entity.Tb_user;

/*
 * 故障记录持久层
 */
@Mapper
@Repository
public interface FaultRecordDao {
	// 跳转并查看所有故障记录
	@Select("SELECT * FROM `error_recording` ORDER BY time DESC")
	List<Error_recording> findAll();
	// 按时间查询故障记录
	@SelectProvider(method = "findByTime",type = FaultRecordSQL.class)
	List<Error_recording> findByTime(String timeA, String timeB);
	// 按照故障机器名称查询
	@Select("SELECT * FROM `error_recording` WHERE fault_machine = #{fault_machine} ORDER BY time DESC")
	List<Error_recording> findByName(@Param("fault_machine") String fault_machine);
	// 新增故障记录
	@Insert("INSERT INTO `error_recording` (fault_id,time,fault_machine,fault_picture,falut_Reporter,falut_state) VALUES (NULL,#{map.time},#{map.fault_machine},#{map.fault_picture},#{user.name},0)")
	void addFaultRecord(@Param("map") Map<String, String> map, @Param("user") Tb_user user);
	// 删除故障记录
	@Delete("DELETE FROM `error_recording` WHERE fault_id = #{id}")
	void deleteFaultRecord(@Param("id") int id);
	// 修改故障记录
	@Update("UPDATE `error_recording` SET falut_people=#{user.name},Repair_time=#{map.Repair_time},falut_summary=#{map.falut_summary},falut_state=1 WHERE fault_id=#{map.fault_id}")
	void updateFaultRecord(@Param("map") Map<String, String> map,@Param("user") Tb_user user);

}
