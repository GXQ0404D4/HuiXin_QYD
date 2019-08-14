package com.ktcn.dao.providerSQL;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

/*
 * 生产管理表动态SQL类
 */
public class ProductionSQL {
	public String findByTime(String pdt_selecttimeA, String pdt_selecttimeB) {
		// 新建一条SQL语句
		String sql = new SQL() {
			// 编写拼接SQL代码块
			{
				SELECT("*");
				FROM("production_plan");
				if (pdt_selecttimeA!=null && !"".equals(pdt_selecttimeA) && pdt_selecttimeB!=null && !"".equals(pdt_selecttimeB)) {
					// 任务名称
					String s = "pdt_time BETWEEN '"+ pdt_selecttimeA +"' AND '"+ pdt_selecttimeB +"'";
					WHERE(s);
				}
				if (pdt_selecttimeA!=null && !"".equals(pdt_selecttimeA)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "pdt_time BETWEEN '"+ pdt_selecttimeA +"' AND '"+ nowDate +"'";
					WHERE(s);
				}
				if (pdt_selecttimeB!=null && !"".equals(pdt_selecttimeB)) {
					// 任务名称
					String s = "pdt_time BETWEEN '1970-01-01 00:00:00' AND '"+ pdt_selecttimeB +"'";
					WHERE(s);
				}
				if (pdt_selecttimeA==null && "".equals(pdt_selecttimeA) && pdt_selecttimeB==null && "".equals(pdt_selecttimeB)) {
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate = format.format(date);
					// 任务名称
					String s = "pdt_time BETWEEN '1970-01-01 00:00:00' AND '"+ nowDate +"'";
					WHERE(s);
				}
			}
		}.toString();
		return sql;
	}
}
