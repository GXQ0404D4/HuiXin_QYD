package com.ktcn.dao.siemensdao;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:02:21
* 类说明  通信状态获取PLC 数据类
*/

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.CommunicateState;


@Mapper
@Repository
public interface CommunicateDao {

	//持久化到周数据表
	@Insert("INSERT INTO communicate (TX0,TX1,TX2,TX3,TX4,TX5,TX6,TX7,TX8,TX9,TX10,TX11,TX_time,TX_data_time,state) VALUES"
			+ "(#{cm.TX0},#{cm.TX1},#{cm.TX2},#{cm.TX3},#{cm.TX4},#{cm.TX5},#{cm.TX6},#{cm.TX7},#{cm.TX8},#{cm.TX9},#{cm.TX10},#{cm.TX11},NOW(),NOW(),1)")
	void setCommunicateStateData(@Param ("cm") CommunicateState cm);

	//c持久化到 小时数据库
	@Insert("INSERT INTO communicate_hour (TX0,TX1,TX2,TX3,TX4,TX5,TX6,TX7,TX8,TX9,TX10,TX11,TX_time,TX_data_time,state) VALUES"
			+ "(#{cm.TX0},#{cm.TX1},#{cm.TX2},#{cm.TX3},#{cm.TX4},#{cm.TX5},#{cm.TX6},#{cm.TX7},#{cm.TX8},#{cm.TX9},#{cm.TX10},#{cm.TX11},NOW(),NOW(),1)")
	void setCommunicateStateDataHour(@Param ("cm")CommunicateState cm);

}
