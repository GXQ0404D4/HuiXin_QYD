package com.ktcn.dao.reportDao.yearReport;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.reportProviderSQL.yearReport.ValveySQL;
import com.ktcn.entity.siemensentity.ControlValue;

/*
 * 调节阀日报表持久层
 */
@Mapper
@Repository
public interface ValveyDao {
	// 获取数据总条数
	@Select("SELECT COUNT(id) FROM control_valve_hour")
	int findTotal();
	// 获取查询数据
	@Select("SELECT * FROM control_valve_hour ORDER BY `TJF_datatime` DESC limit #{total},10")
	List<ControlValue> findAllByIndex(int x);
	
	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = ValveySQL.class)
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询调节阀日报表信息
	@SelectProvider(method = "findByTime", type = ValveySQL.class)
	List<ControlValue> findByTime(String current_timeA, String current_timeB, int total);
	
	// 导出Excel
	@Select("SELECT * FROM control_valve_hour LIMIT 0,10000")
	List<ControlValue> findExport();
}
