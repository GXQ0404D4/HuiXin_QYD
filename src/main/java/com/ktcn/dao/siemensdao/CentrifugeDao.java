package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.CentriFuge;


/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午3:27:11
* 类说明  离心机获取数据类
*/
@Mapper
@Repository
public interface CentrifugeDao {

	@Insert("INSERT INTO centrifuge (LXJ5,LXJ7,LXJ8,LXJ9,LXJ10,LXJ11,LXJ14,LXJ15,LXJ16,LXJ17,LXJ18,LXJ19,LXJ20,LXJ21,LXJ22,LXJ23,LXJ_time,LXJ_datatime,state,centrifuge_name) "
			+ "VALUES(#{cen.LXJ5},#{cen.LXJ7},#{cen.LXJ8},#{cen.LXJ9},#{cen.LXJ10},#{cen.LXJ11},#{cen.LXJ14},#{cen.LXJ15},#{cen.LXJ16},#{cen.LXJ17},#{cen.LXJ18},#{cen.LXJ19},#{cen.LXJ20},"
			+ "#{cen.LXJ21},#{cen.LXJ22},#{cen.LXJ23},NOW(),NOW(),1,#{cen.centrifuge_name})")
	void setsetCentrifugeData(@Param("cen") CentriFuge cen);

	@Insert("INSERT INTO centrifuge_hour (LXJ5,LXJ7,LXJ8,LXJ9,LXJ10,LXJ11,LXJ14,LXJ15,LXJ16,LXJ17,LXJ18,LXJ19,LXJ20,LXJ21,LXJ22,LXJ23,LXJ_time,LXJ_datatime,state,centrifuge_name) "
			+ "VALUES(#{cen.LXJ5},#{cen.LXJ7},#{cen.LXJ8},#{cen.LXJ9},#{cen.LXJ10},#{cen.LXJ11},#{cen.LXJ14},#{cen.LXJ15},#{cen.LXJ16},#{cen.LXJ17},#{cen.LXJ18},#{cen.LXJ19},#{cen.LXJ20},"
			+ "#{cen.LXJ21},#{cen.LXJ22},#{cen.LXJ23},NOW(),NOW(),1,#{cen.centrifuge_name})")
	void setsetCentrifugeDataHour(@Param("cen")CentriFuge cen);

}
