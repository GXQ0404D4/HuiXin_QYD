package com.ktcn.dao.reportDao.yearReport;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.reportProviderSQL.yearReport.AirStatementsySQL;
import com.ktcn.entity.siemensentity.CentriFuge;

/*
 * 离心机日报表持久层
 */
@Mapper
@Repository
public interface AirStatementsyDao {
	// 获取数据总条数
	@Select("SELECT COUNT(id) FROM centrifuge_hour")
	int findTotal();
	// 获取查询数据
	@Select("SELECT * FROM centrifuge_hour ORDER BY `LXJ_datatime` DESC limit #{total},10")
	List<CentriFuge> findAllByIndex(int x);
	
	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = AirStatementsySQL.class)
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询离心机日报表信息
	@SelectProvider(method = "findByTime", type = AirStatementsySQL.class)
	List<CentriFuge> findByTime(String current_timeA, String current_timeB, int total);
	
	// 导出Excel
	@Select("SELECT * FROM centrifuge_hour LIMIT 0,10000")
	List<CentriFuge> findExport();
}
