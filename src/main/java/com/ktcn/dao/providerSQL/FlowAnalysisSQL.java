package com.ktcn.dao.providerSQL;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

/*
 * 流量曲线分析动态SQL类
 */
public class FlowAnalysisSQL {
	public String findByTime(String timeA, String timeB) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("*");
				FROM("`mian_network`");
				if (timeA!=null && !"".equals(timeA) && timeB!=null && !"".equals(timeB)) {
					// 任务名称
					String s = "`current_time` BETWEEN '"+ timeA +"' AND '"+ timeB +"'";
					WHERE(s);
				}
				if (timeA!=null && !"".equals(timeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`current_time` BETWEEN '"+ timeA +"' AND '"+ nowDate +"'";
					WHERE(s);
				}
				if (timeB!=null && !"".equals(timeB)) {
					// 任务名称
					String s = "`current_time` BETWEEN '1970-01-01 00:00:00' AND '"+ timeB +"'";
					WHERE(s);
				}
				if (timeA==null && "".equals(timeA) && timeB==null && "".equals(timeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`current_time` BETWEEN '1970-01-01 00:00:00' AND '"+ nowDate +"'";
					WHERE(s);
				}
			}
		}.toString()+"GROUP BY HOUR(e.t_time) ORDER BY Hour(e.t_time)";
		return sql;
	}
}
