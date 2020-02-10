package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.DryingMachine;


/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月3日 上午11:42:19
* 类说明 干燥机PLC 获取数据类
*/
@Mapper
@Repository
public interface DryingMachineDao {

	@Insert("INSERT INTO drying_machine (GZJ0,GZJ1,GZJ2,GZJ3,GZJ4,GZJ5,GZJ12,GZJ15,GZJ16,GZJ19,GZJ20,GZJ21,GZJ22,GZJ23,GZJ24,GZJ25,"
			+ "GZJ26,GZJ27,GZJ28,GZJ29,GZJ30,GZJ31,GZJ32,GZJ33,GZJ34,GZJ35,GZJ36,GZJ37,GZ_time,GZ_datatime,state,DryingMachine_name)VALUES"
			+ "(#{dm.GZJ0},#{dm.GZJ1},#{dm.GZJ2},#{dm.GZJ3},#{dm.GZJ4},#{dm.GZJ5},#{dm.GZJ12},#{dm.GZJ15},#{dm.GZJ16},#{dm.GZJ19},#{dm.GZJ20},"
			+ "#{dm.GZJ21},#{dm.GZJ22},#{dm.GZJ23},#{dm.GZJ24},#{dm.GZJ25},#{dm.GZJ26},#{dm.GZJ27},#{dm.GZJ28},#{dm.GZJ29},#{dm.GZJ30},"
			+ "#{dm.GZJ31},#{dm.GZJ32},#{dm.GZJ33},#{dm.GZJ34},#{dm.GZJ35},#{dm.GZJ36},#{dm.GZJ37},NOW(),NOW(),1,#{dm.DryingMachine_name})")
	void setDryingMachineData(@Param("dm") DryingMachine dm);

	@Insert("INSERT INTO drying_machine (GZJ0,GZJ1,GZJ2,GZJ3,GZJ4,GZJ5,GZJ6,GZJ10,GZJ11,GZJ12,GZJ13,GZJ14,GZJ15,GZJ16,GZJ19,GZJ20,GZJ21,"
			+ "GZJ22,GZJ23,GZJ24,GZJ25,GZJ26,GZJ27,GZJ28,GZJ29,GZJ30,GZJ31,GZ_time,GZ_datatime,state,DryingMachine_name)VALUES"
			+ "(#{dm.GZJ0},#{dm.GZJ1},#{dm.GZJ2},#{dm.GZJ3},#{dm.GZJ4},#{dm.GZJ5},#{dm.GZJ6},#{dm.GZJ10},#{dm.GZJ11},#{dm.GZJ12},#{dm.GZJ13},"
			+ "#{dm.GZJ14},#{dm.GZJ15},#{dm.GZJ16},#{dm.GZJ19},#{dm.GZJ20},#{dm.GZJ21},#{dm.GZJ22},#{dm.GZJ23},#{dm.GZJ24},#{dm.GZJ25},#{dm.GZJ26},"
			+ "#{dm.GZJ27},#{dm.GZJ28},#{dm.GZJ29},#{dm.GZJ30},#{dm.GZJ31},NOW(),NOW(),1,#{dm.DryingMachine_name})")
	void setDryingMachineData1(@Param("dm") DryingMachine dm);

	@Insert("INSERT INTO drying_machine (GZJ9,GZJ10,GZJ18,GZJ19,GZ_time,GZ_datatime,state,DryingMachine_name) VALUES"
			+ "(#{dm.GZJ9},#{dm.GZJ10},#{dm.GZJ18},#{dm.GZJ19},NOW(),NOW(),1,#{dm.DryingMachine_name})")
	void setDryingMachineData2(@Param("dm") DryingMachine dm);
	
	//Hour小时数据持久化Dao层
	@Insert("INSERT INTO drying_machine_hour (GZJ0,GZJ1,GZJ2,GZJ3,GZJ4,GZJ5,GZJ12,GZJ15,GZJ16,GZJ19,GZJ20,GZJ21,GZJ22,GZJ23,GZJ24,GZJ25,"
			+ "GZJ26,GZJ27,GZJ28,GZJ29,GZJ30,GZJ31,GZJ32,GZJ33,GZJ34,GZJ35,GZJ36,GZJ37,GZ_time,GZ_datatime,state,DryingMachine_name)VALUES"
			+ "(#{dm.GZJ0},#{dm.GZJ1},#{dm.GZJ2},#{dm.GZJ3},#{dm.GZJ4},#{dm.GZJ5},#{dm.GZJ12},#{dm.GZJ15},#{dm.GZJ16},#{dm.GZJ19},#{dm.GZJ20},"
			+ "#{dm.GZJ21},#{dm.GZJ22},#{dm.GZJ23},#{dm.GZJ24},#{dm.GZJ25},#{dm.GZJ26},#{dm.GZJ27},#{dm.GZJ28},#{dm.GZJ29},#{dm.GZJ30},"
			+ "#{dm.GZJ31},#{dm.GZJ32},#{dm.GZJ33},#{dm.GZJ34},#{dm.GZJ35},#{dm.GZJ36},#{dm.GZJ37},NOW(),NOW(),1,#{dm.DryingMachine_name})")
	void setDryingMachineDataHour(@Param("dm") DryingMachine dm);

	@Insert("INSERT INTO drying_machine_hour (GZJ0,GZJ1,GZJ2,GZJ3,GZJ4,GZJ5,GZJ6,GZJ10,GZJ11,GZJ12,GZJ13,GZJ14,GZJ15,GZJ16,GZJ19,GZJ20,GZJ21,"
			+ "GZJ22,GZJ23,GZJ24,GZJ25,GZJ26,GZJ27,GZJ28,GZJ29,GZJ30,GZJ31,GZ_time,GZ_datatime,state,DryingMachine_name)VALUES"
			+ "(#{dm.GZJ0},#{dm.GZJ1},#{dm.GZJ2},#{dm.GZJ3},#{dm.GZJ4},#{dm.GZJ5},#{dm.GZJ6},#{dm.GZJ10},#{dm.GZJ11},#{dm.GZJ12},#{dm.GZJ13},"
			+ "#{dm.GZJ14},#{dm.GZJ15},#{dm.GZJ16},#{dm.GZJ19},#{dm.GZJ20},#{dm.GZJ21},#{dm.GZJ22},#{dm.GZJ23},#{dm.GZJ24},#{dm.GZJ25},#{dm.GZJ26},"
			+ "#{dm.GZJ27},#{dm.GZJ28},#{dm.GZJ29},#{dm.GZJ30},#{dm.GZJ31},NOW(),NOW(),1,#{dm.DryingMachine_name})")
	void setDryingMachineDataHour1(@Param("dm") DryingMachine dm);

	@Insert("INSERT INTO drying_machine_hour (GZJ9,GZJ10,GZJ18,GZJ19,GZ_time,GZ_datatime,state,DryingMachine_name) VALUES"
			+ "(#{dm.GZJ9},#{dm.GZJ10},#{dm.GZJ18},#{dm.GZJ19},NOW(),NOW(),1,#{dm.DryingMachine_name})")
	void setDryingMachineDataHour2(@Param("dm") DryingMachine dm);

	//定时删除周报表数据
	@Delete(" DELETE FROM drying_machine WHERE GZ_time<=DATE_SUB(NOW(),INTERVAL 1 WEEK)")
	void deleteDryingMachineData();


}
