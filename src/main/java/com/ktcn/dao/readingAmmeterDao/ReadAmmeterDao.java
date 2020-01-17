package com.ktcn.dao.readingAmmeterDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.Reading_Ammeter;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月17日 下午4:23:54
* 类说明  抄表模块 获取 正向有功总电能的数据
*/
@Mapper
@Repository
public interface ReadAmmeterDao {

	//获取抄表模块 正向有功总电能的数据
	@Select("SELECT * FROM reading_ammeter WHERE amDB_time= DATE(NOW())")
	List<Reading_Ammeter> getReadAmmeterData();

}
