package com.ktcn.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @Title: OPCSwitch_output_Dao.java
* @Package com.ktcn.dao
* @Description: TODO OPCSwitch_output_Dao
* @author GXQ
* @date 2019年9月2日
* @version V1.0
*/
@Mapper
@Repository
public interface OPCSwitch_output_Dao {
 
	void OPCswitch_output_update(Map<String, Boolean> map2);
}
