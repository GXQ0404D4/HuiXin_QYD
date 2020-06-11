package com.ktcn.dao.siemensPageDao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月11日 上午10:27:08
* 类说明
*/
@Mapper
@Repository
public interface MonitoringDao {

	void getMonitoringData();

}
