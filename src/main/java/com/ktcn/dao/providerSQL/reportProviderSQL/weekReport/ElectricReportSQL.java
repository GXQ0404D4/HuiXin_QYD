package com.ktcn.dao.providerSQL.reportProviderSQL.weekReport;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

/*
 * 电表日报表动态SQL类
 */
public class ElectricReportSQL {
	// 时间查询-总条数
	public String findCountByTime(String current_timeA, String current_timeB) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("COUNT(id)");
				FROM("ammeter_hour");
				if (current_timeA != null && !"".equals(current_timeA) && current_timeB != null
						&& !"".equals(current_timeB)) {
					// 任务名称
					String s = "`DB_datatime` BETWEEN '" + current_timeA + "' AND '" + current_timeB + "'";
					WHERE(s);
				}
				if (current_timeA != null && !"".equals(current_timeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`DB_datatime` BETWEEN '" + current_timeA + "' AND '" + nowDate + "'";
					WHERE(s);
				}
				if (current_timeB != null && !"".equals(current_timeB)) {
					// 任务名称
					String s = "`DB_datatime` BETWEEN '1970-01-01 00:00:00' AND '" + current_timeB + "'";
					WHERE(s);
				}
				if (current_timeA == null && "".equals(current_timeA) && current_timeB == null
						&& "".equals(current_timeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`DB_datatime` BETWEEN '1970-01-01 00:00:00' AND '" + nowDate + "'";
					WHERE(s);
				}
			}
		}.toString();
		return sql;
	}

	// 时间查询-分页查询
	public String findByTime(String current_timeA, String current_timeB, int total) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("*");
				FROM("ammeter_hour");
				if (current_timeA != null && !"".equals(current_timeA) && current_timeB != null
						&& !"".equals(current_timeB)) {
					// 任务名称
					String s = "`DB_datatime` BETWEEN '" + current_timeA + "' AND '" + current_timeB + "'";
					WHERE(s);
				}
				if (current_timeA != null && !"".equals(current_timeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`DB_datatime` BETWEEN '" + current_timeA + "' AND '" + nowDate + "'";
					WHERE(s);
				}
				if (current_timeB != null && !"".equals(current_timeB)) {
					// 任务名称
					String s = "`DB_datatime` BETWEEN '1970-01-01 00:00:00' AND '" + current_timeB + "'";
					WHERE(s);
				}
				if (current_timeA == null && "".equals(current_timeA) && current_timeB == null
						&& "".equals(current_timeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`DB_datatime` BETWEEN '1970-01-01 00:00:00' AND '" + nowDate + "'";
					WHERE(s);
				}
			}
		}.toString() + " LIMIT " + total + ",10";
		return sql;
	}
}
