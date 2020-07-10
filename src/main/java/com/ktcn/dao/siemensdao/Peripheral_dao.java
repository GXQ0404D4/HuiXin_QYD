package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Peripheral_Alarm;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.Peripheral_qt;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:47:44
* 类说明   外围数据DAO层操作
*/
@Mapper
@Repository
public interface Peripheral_dao {
//  外围实时数据持久到数据库
	@Insert("INSERT INTO peripheral_data VALUES (null,#{p_da.ww0},#{p_da.ww1},#{p_da.ww2},#{p_da.ww3},#{p_da.ww4},#{p_da.ww5},#{p_da.ww6},#{p_da.ww7},#{p_da.ww8}"
			+ ",#{p_da.ww9},#{p_da.ww10},#{p_da.ww11},#{p_da.ww12},#{p_da.ww13},#{p_da.ww14},#{p_da.ww15},#{p_da.ww16},#{p_da.ww17},#{p_da.ww18},#{p_da.ww19}"
			+ ",#{p_da.ww20},#{p_da.ww21},#{p_da.ww22},#{p_da.ww23},#{p_da.ww24},#{p_da.ww25},#{p_da.ww26},#{p_da.ww27},#{p_da.ww28},#{p_da.ww29},#{p_da.ww30}"
			+ ",#{p_da.ww31},#{p_da.ww32},#{p_da.ww33},#{p_da.ww34},#{p_da.ww35},#{p_da.ww36},#{p_da.ww37},#{p_da.ww38},#{p_da.ww39},#{p_da.ww40},#{p_da.ww41}"
			+ ",#{p_da.ww42},#{p_da.ww43},#{p_da.ww44},#{p_da.ww45},#{p_da.ww46},#{p_da.ww47},#{p_da.ww48},#{p_da.ww49},#{p_da.ww50},#{p_da.ww51},#{p_da.ww52}"
			+ ",#{p_da.ww53},#{p_da.ww54},#{p_da.ww55},#{p_da.ww56},#{p_da.ww57},#{p_da.ww58},#{p_da.ww59},#{p_da.ww60},#{p_da.ww61},#{p_da.ww62},#{p_da.ww63}"
			+ ",#{p_da.ww64},#{p_da.ww65},#{p_da.ww66},#{p_da.ww67},#{p_da.ww68},#{p_da.ww69},#{p_da.ww70},#{p_da.ww71},#{p_da.ww72},#{p_da.ww73},#{p_da.ww74}"
			+ ",#{p_da.ww75},#{p_da.ww76},#{p_da.ww77},#{p_da.ww78},#{p_da.ww79},#{p_da.ww80},#{p_da.ww81},#{p_da.ww82},#{p_da.ww83},#{p_da.ww84},#{p_da.ww85}"
			+ ",#{p_da.ww86},#{p_da.ww87},#{p_da.ww88},#{p_da.ww89},#{p_da.ww90},#{p_da.ww91},#{p_da.ww92},#{p_da.ww93},#{p_da.ww94},NOW(),NOW())")
	void setPeripheral_data(@Param("p_da") Peripheral_entity p_da);

//	外围小时数据持久化到数据库
	@Insert("INSERT INTO peripheral_data_hour VALUES (null,#{p_dhour.ww0},#{p_dhour.ww1},#{p_dhour.ww2},#{p_dhour.ww3},#{p_dhour.ww4},#{p_dhour.ww5},#{p_dhour.ww6},#{p_dhour.ww7},#{p_dhour.ww8}"
			+ ",#{p_dhour.ww9},#{p_dhour.ww10},#{p_dhour.ww11},#{p_dhour.ww12},#{p_dhour.ww13},#{p_dhour.ww14},#{p_dhour.ww15},#{p_dhour.ww16},#{p_dhour.ww17},#{p_dhour.ww18},#{p_dhour.ww19}"
			+ ",#{p_dhour.ww20},#{p_dhour.ww21},#{p_dhour.ww22},#{p_dhour.ww23},#{p_dhour.ww24},#{p_dhour.ww25},#{p_dhour.ww26},#{p_dhour.ww27},#{p_dhour.ww28},#{p_dhour.ww29},#{p_dhour.ww30}"
			+ ",#{p_dhour.ww31},#{p_dhour.ww32},#{p_dhour.ww33},#{p_dhour.ww34},#{p_dhour.ww35},#{p_dhour.ww36},#{p_dhour.ww37},#{p_dhour.ww38},#{p_dhour.ww39},#{p_dhour.ww40},#{p_dhour.ww41}"
			+ ",#{p_dhour.ww42},#{p_dhour.ww43},#{p_dhour.ww44},#{p_dhour.ww45},#{p_dhour.ww46},#{p_dhour.ww47},#{p_dhour.ww48},#{p_dhour.ww49},#{p_dhour.ww50},#{p_dhour.ww51},#{p_dhour.ww52}"
			+ ",#{p_dhour.ww53},#{p_dhour.ww54},#{p_dhour.ww55},#{p_dhour.ww56},#{p_dhour.ww57},#{p_dhour.ww58},#{p_dhour.ww59},#{p_dhour.ww60},#{p_dhour.ww61},#{p_dhour.ww62},#{p_dhour.ww63}"
			+ ",#{p_dhour.ww64},#{p_dhour.ww65},#{p_dhour.ww66},#{p_dhour.ww67},#{p_dhour.ww68},#{p_dhour.ww69},#{p_dhour.ww70},#{p_dhour.ww71},#{p_dhour.ww72},#{p_dhour.ww73},#{p_dhour.ww74}"
			+ ",#{p_dhour.ww75},#{p_dhour.ww76},#{p_dhour.ww77},#{p_dhour.ww78},#{p_dhour.ww79},#{p_dhour.ww80},#{p_dhour.ww81},#{p_dhour.ww82},#{p_dhour.ww83},#{p_dhour.ww84},#{p_dhour.ww85}"
			+ ",#{p_dhour.ww86},#{p_dhour.ww87},#{p_dhour.ww88},#{p_dhour.ww89},#{p_dhour.ww90},#{p_dhour.ww91},#{p_dhour.ww92},#{p_dhour.ww93},#{p_dhour.ww94},NOW(),NOW())")
	void setPeripheral_data_hour(@Param("p_dhour") Peripheral_entity p_dhour);

	
	
//  外围报警数据持久化到数据库
	@Insert("INSERT INTO peripheral_bj  VALUES(null,#{pp_Alarm.pdjname},#{pp_Alarm.pbj0},#{pp_Alarm.pbj1},#{pp_Alarm.pbj2},#{pp_Alarm.pbj3}"
			+ ",#{pp_Alarm.pbj4},#{pp_Alarm.pbj5},#{pp_Alarm.pbj6},NOW(),NOW())")
	void setBJPeripheral_data(@Param("pp_Alarm") Peripheral_Alarm pp_Alarm);

//	删除当前一个月之前的数据
//	@Delete("DELETE FROM peripheral_data WHERE pddate<=DATE_ADD(NOW(),INTERVAL -1 MONTH)")
//	定时删除当前一周时间之前的数据
	@Delete("DELETE FROM peripheral_data WHERE pddate<=DATE_ADD(NOW(),INTERVAL -2 WEEK)")
	void deletePeripheralReamlData();

}
