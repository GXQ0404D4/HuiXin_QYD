package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Reading_Ammeter;
import com.ktcn.entity.siemensentity.Ammeter;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年1月2日 上午10:34:36 类说明 电表数据获取 电表dao层操作
 */
@Repository
@Mapper
public interface AmmeterDao {
	// 实时持久化电表数据
	@Insert("INSERT INTO ammeter (DB9,DB10,DB11,DB12,DB_time,DB_datatime,state,ammeter_name) VALUES(#{ammeter.DB9},#{ammeter.DB10},#{ammeter.DB11},#{ammeter.DB12},NOW(),NOW(),1,#{ammeter1})")
	void setAmmeterData(@Param("ammeter") Ammeter ammeter, @Param("ammeter1") String ammeter1);

	// 实时持久化电表数据
	@Insert("INSERT INTO ammeter_hour (DB9,DB10,DB11,DB12,DB_time,DB_datatime,state,ammeter_name) VALUES(#{ammeter.DB9},#{ammeter.DB10},#{ammeter.DB11},#{ammeter.DB12},NOW(),NOW(),1,#{ammeter1})")
	void setAmmeterDataHour(@Param("ammeter") Ammeter ammeter, @Param("ammeter1") String ammeter1);

	//定时删除周报表数据
	@Delete(" DELETE FROM ammeter WHERE DB_time<=DATE_SUB(NOW(),INTERVAL 1 WEEK)")
	void deleteAmmeterData();

	//电表 正向有功总电能 抄表模块
	@Insert("INSERT INTO reading_ammeter(amDB1,amDB2,amDB3,amDB4,amDB5,amDB6,amDB7,amDB8,amDB9,amDB_time,amDB_date,state) VALUES "
			+ "(#{reading_Ammeter.amDB1},#{reading_Ammeter.amDB2},#{reading_Ammeter.amDB3},#{reading_Ammeter.amDB4},#{reading_Ammeter.amDB5},#{reading_Ammeter.amDB6},"
			+ "#{reading_Ammeter.amDB7},#{reading_Ammeter.amDB8},#{reading_Ammeter.amDB9},NOW(),NOW(),1)")
	void readingAmmeterData(@Param("reading_Ammeter") Reading_Ammeter reading_Ammeter);

}
