package com.ktcn.dao.providerSQL;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

/*
 * 空压机报表动态SQL类
 */
public class ComReportSQL {
	public String findAllByTime(String current_timeA, String current_timeB) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("*");
				FROM("compressor_report");
				if (current_timeA!=null && !"".equals(current_timeA) && current_timeB!=null && !"".equals(current_timeB)) {
					// 任务名称
					String s = "Air_current_time BETWEEN '"+ current_timeA +"' AND '"+ current_timeB +"'";
					WHERE(s);
				}
				if (current_timeA!=null && !"".equals(current_timeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "Air_current_time BETWEEN '"+ current_timeA +"' AND '"+ nowDate +"'";
					WHERE(s);
				}
				if (current_timeB!=null && !"".equals(current_timeB)) {
					// 任务名称
					String s = "Air_current_time BETWEEN '1970-01-01 00:00:00' AND '"+ current_timeB +"'";
					WHERE(s);
				}
				if (current_timeA==null && "".equals(current_timeA) && current_timeB==null && "".equals(current_timeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "Air_current_time BETWEEN '1970-01-01 00:00:00' AND '"+ nowDate +"'";
					WHERE(s);
				}
			}
		}.toString();
		return sql;
	}
}
