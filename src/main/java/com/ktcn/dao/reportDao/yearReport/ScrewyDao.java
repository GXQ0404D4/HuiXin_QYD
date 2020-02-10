package com.ktcn.dao.reportDao.yearReport;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.ktcn.dao.providerSQL.reportProviderSQL.yearReport.ScrewySQL;
import com.ktcn.entity.siemensentity.ScrewMachine;

/*
 * 螺杆机日报表持久层
 */
@Mapper
@Repository
public interface ScrewyDao {
	// 获取数据总条数
	@Select("SELECT COUNT(id) FROM screw_machine")
	int findTotal();
	// 获取查询数据
	@Select("SELECT * FROM screw_machine ORDER BY `LGJ_datatime` DESC limit #{total},10")
	List<ScrewMachine> findAllByIndex(int x);
	
	// 时间区间查询总条数
	@SelectProvider(method = "findCountByTime", type = ScrewySQL.class)
	int findCountByTime(String current_timeA, String current_timeB);
	// 根据时间区间查询离心机日报表信息
	@SelectProvider(method = "findByTime", type = ScrewySQL.class)
	List<ScrewMachine> findByTime(String current_timeA, String current_timeB, int total);
	
	// 导出Excel
	@Select("SELECT * FROM screw_machine LIMIT 0,10000")
	List<ScrewMachine> findExport();
}
