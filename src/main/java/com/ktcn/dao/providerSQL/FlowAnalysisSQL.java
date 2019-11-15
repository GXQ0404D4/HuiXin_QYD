package com.ktcn.dao.providerSQL;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

/*
 * 流量曲线分析动态SQL类
 */
public class FlowAnalysisSQL {
	public String findByTime(String timeA, String timeB) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = format.format(date);
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("DATE_FORMAT(e.`current_time`,'%Y-%m-%d %H:00') as vTime,sum(e.Compensated_flow) as vValue");
				FROM("kyj_data_hour e");
				if (timeA!=null && !"".equals(timeA) && timeB!=null && !"".equals(timeB)) {
					// 任务名称
					String s = "e.`current_time` BETWEEN '"+ timeA +"' AND '"+ timeB +"'";
					WHERE(s);
				} else 
				if (timeB==null && "".equals(timeB) ) {
					// 任务名称
					String s = "e.`current_time` BETWEEN '"+ timeA +"' AND '"+ nowDate +"'";
					WHERE(s);
				} else 
				if (timeB!=null && !"".equals(timeB)) {
					// 任务名称
					String s = "e.`current_time` BETWEEN '1970-01-01 00:00:00' AND '"+ timeB +"'";
					WHERE(s);
				} else 
				if (timeA==null && "".equals(timeA) && timeB==null && "".equals(timeB)) {
					// 任务名称
					String s = "e.`current_time` BETWEEN '1970-01-01 00:00:00' AND '"+ nowDate +"'";
					WHERE(s);
				}
			}
		}.toString()+" GROUP BY MONTH(e.`current_time`),DAY(e.`current_time`),Hour(e.`current_time`) ";
		return sql;
	}
}
