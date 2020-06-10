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

	@Insert("INSERT INTO peripheral_data VALUES (null,#{p_da.WW0},#{p_da.WW1},#{p_da.WW2},#{p_da.WW3},#{p_da.WW4},#{p_da.WW5},#{p_da.WW6},#{p_da.WW7},#{p_da.WW8}"
			+ ",#{p_da.WW9},#{p_da.WW10},#{p_da.WW11},#{p_da.WW12},#{p_da.WW13},#{p_da.WW14},#{p_da.WW15},#{p_da.WW16},#{p_da.WW17},#{p_da.WW18},#{p_da.WW19}"
			+ ",#{p_da.WW20},#{p_da.WW21},#{p_da.WW22},#{p_da.WW23},#{p_da.WW24},#{p_da.WW25},#{p_da.WW26},#{p_da.WW27},#{p_da.WW28},#{p_da.WW29},#{p_da.WW30}"
			+ ",#{p_da.WW31},#{p_da.WW32},#{p_da.WW33},#{p_da.WW34},#{p_da.WW35},#{p_da.WW36},#{p_da.WW37},#{p_da.WW38},#{p_da.WW39},#{p_da.WW40},#{p_da.WW41}"
			+ ",#{p_da.WW42},#{p_da.WW43},#{p_da.WW44},#{p_da.WW45},#{p_da.WW46},#{p_da.WW47},#{p_da.WW48},#{p_da.WW49},#{p_da.WW50},#{p_da.WW51},#{p_da.WW52}"
			+ ",#{p_da.WW53},#{p_da.WW54},#{p_da.WW55},#{p_da.WW56},#{p_da.WW57},#{p_da.WW58},#{p_da.WW59},#{p_da.WW60},#{p_da.WW61},#{p_da.WW62},#{p_da.WW63}"
			+ ",#{p_da.WW64},#{p_da.WW65},#{p_da.WW66},#{p_da.WW67},#{p_da.WW68},#{p_da.WW69},#{p_da.WW70},#{p_da.WW71},#{p_da.WW72},#{p_da.WW73},#{p_da.WW74}"
			+ ",#{p_da.WW75},#{p_da.WW76},#{p_da.WW77},#{p_da.WW78},#{p_da.WW79},#{p_da.WW80},#{p_da.WW81},#{p_da.WW82},#{p_da.WW83},#{p_da.WW84},#{p_da.WW85}"
			+ ",#{p_da.WW86},#{p_da.WW87},#{p_da.WW88},#{p_da.WW89},#{p_da.WW90},#{p_da.WW91},#{p_da.WW92},#{p_da.WW93},#{p_da.WW94},NOW(),NOW())")
	void setPeripheral_data(@Param("p_da") Peripheral_Data p_da);

}
