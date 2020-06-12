package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.Peripheral_Data;
import com.ktcn.entity.siemensentity.Peripheral_qt;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:47:44
* 类说明   外围数据DAO层操作
*/
@Mapper
@Repository
public interface Peripheral_dao {

	@Insert("INSERT INTO peripheral_data VALUES (null,#{p_da.ww0},#{p_da.ww1},#{p_da.ww2},#{p_da.ww3},#{p_da.ww4},#{p_da.ww5},#{p_da.ww6},#{p_da.ww7},#{p_da.ww8}"
			+ ",#{p_da.ww9},#{p_da.ww10},#{p_da.ww11},#{p_da.ww12},#{p_da.ww13},#{p_da.ww14},#{p_da.ww15},#{p_da.ww16},#{p_da.ww17},#{p_da.ww18},#{p_da.ww19}"
			+ ",#{p_da.ww20},#{p_da.ww21},#{p_da.ww22},#{p_da.ww23},#{p_da.ww24},#{p_da.ww25},#{p_da.ww26},#{p_da.ww27},#{p_da.ww28},#{p_da.ww29},#{p_da.ww30}"
			+ ",#{p_da.ww31},#{p_da.ww32},#{p_da.ww33},#{p_da.ww34},#{p_da.ww35},#{p_da.ww36},#{p_da.ww37},#{p_da.ww38},#{p_da.ww39},#{p_da.ww40},#{p_da.ww41}"
			+ ",#{p_da.ww42},#{p_da.ww43},#{p_da.ww44},#{p_da.ww45},#{p_da.ww46},#{p_da.ww47},#{p_da.ww48},#{p_da.ww49},#{p_da.ww50},#{p_da.ww51},#{p_da.ww52}"
			+ ",#{p_da.ww53},#{p_da.ww54},#{p_da.ww55},#{p_da.ww56},#{p_da.ww57},#{p_da.ww58},#{p_da.ww59},#{p_da.ww60},#{p_da.ww61},#{p_da.ww62},#{p_da.ww63}"
			+ ",#{p_da.ww64},#{p_da.ww65},#{p_da.ww66},#{p_da.ww67},#{p_da.ww68},#{p_da.ww69},#{p_da.ww70},#{p_da.ww71},#{p_da.ww72},#{p_da.ww73},#{p_da.ww74}"
			+ ",#{p_da.ww75},#{p_da.ww76},#{p_da.ww77},#{p_da.ww78},#{p_da.ww79},#{p_da.ww80},#{p_da.ww81},#{p_da.ww82},#{p_da.ww83},#{p_da.ww84},#{p_da.ww85}"
			+ ",#{p_da.ww86},#{p_da.ww87},#{p_da.ww88},#{p_da.ww89},#{p_da.ww90},#{p_da.ww91},#{p_da.ww92},#{p_da.ww93},#{p_da.ww94},NOW(),NOW())")
	void setPeripheral_data(@Param("p_da") Peripheral_Data p_da);

}
