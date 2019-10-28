package com.ktcn.dao.providerSQL;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

/**
 * 报警巡查动态SQL类
 * 
 * @author Administrator
 *
 */
public class AlarmpatrolSQL {

	// 时间查询-总条数
	public String findCountByTime(String timeA, String timeB) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("COUNT(ap_id)");
				FROM("alarmpatrol");
				if (timeA != null && !"".equals(timeA) && timeB != null
						&& !"".equals(timeB)) {
					// 任务名称
					String s = "`ap_time` BETWEEN '" + timeA + "' AND '" + timeB + "'";
					WHERE(s);
				}
				if (timeA != null && !"".equals(timeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`ap_time` BETWEEN '" + timeA + "' AND '" + nowDate + "'";
					WHERE(s);
				}
				if (timeB != null && !"".equals(timeB)) {
					// 任务名称
					String s = "`ap_time` BETWEEN '1970-01-01 00:00:00' AND '" + timeB + "'";
					WHERE(s);
				}
				if (timeA == null && "".equals(timeA) && timeB == null
						&& "".equals(timeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`ap_time` BETWEEN '1970-01-01 00:00:00' AND '" + nowDate + "'";
					WHERE(s);
				}
			}
		}.toString();
		return sql;
	}

	// 时间查询-分页查询
	public String findByTime(String timeA, String timeB, int total) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("*");
				FROM("alarmpatrol");
				if (timeA != null && !"".equals(timeA) && timeB != null
						&& !"".equals(timeB)) {
					// 任务名称
					String s = "`ap_time` BETWEEN '" + timeA + "' AND '" + timeB + "'";
					WHERE(s);
				}
				if (timeA != null && !"".equals(timeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`ap_time` BETWEEN '" + timeA + "' AND '" + nowDate + "'";
					WHERE(s);
				}
				if (timeB != null && !"".equals(timeB)) {
					// 任务名称
					String s = "`ap_time` BETWEEN '1970-01-01 00:00:00' AND '" + timeB + "'";
					WHERE(s);
				}
				if (timeA == null && "".equals(timeA) && timeB == null
						&& "".equals(timeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "`ap_time` BETWEEN '1970-01-01 00:00:00' AND '" + nowDate + "'";
					WHERE(s);
				}
			}
		}.toString() + " LIMIT " + total + ",10";
		return sql;
	}
}
