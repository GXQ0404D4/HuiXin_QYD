package com.ktcn.dao.reportDao.yearReport;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.reportProviderSQL.yearReport.MainReportySQL;
import com.ktcn.entity.siemensentity.FlowGauge;

/*
 * 总管网日报表持久层
 */
@Mapper
@Repository
public interface MainReportyDao {
	// 获取数据总条数
	@Select("SELECT COUNT(id) FROM flow_gauge")
	int findTotal();
	// 获取查询数据
	@Select("SELECT * FROM flow_gauge ORDER BY `LLJ_datatime` DESC limit #{total},10")
	List<FlowGauge> findAllByIndex(int x);
	
	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = MainReportySQL.class)
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询离心机日报表信息
	@SelectProvider(method = "findByTime", type = MainReportySQL.class)
	List<FlowGauge> findByTime(String current_timeA, String current_timeB, int total);
	
	// 导出Excel
	@Select("SELECT * FROM flow_gauge LIMIT 0,10000")
	List<FlowGauge> findExport();
}
