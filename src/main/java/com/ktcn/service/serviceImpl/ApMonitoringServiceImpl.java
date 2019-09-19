package com.ktcn.service.serviceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ApMonitoringDao;
import com.ktcn.entity.Alarmpatrol;
import com.ktcn.entity.Alarmseteings;
import com.ktcn.entity.Real_time_data;
import com.ktcn.service.ApMonitoringService;
/**
 * 报警巡查实时监控业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class ApMonitoringServiceImpl implements ApMonitoringService {
	
	@Resource
	private ApMonitoringDao apMonitoringDao;
	// 获取实时监控表内容, 获取报警设置表内容, 进行对比, 对符合报警条件的属性生成实例对象存入list中
	public List<Alarmpatrol> alarmpatrolMethod() {
		// 新建一个list用来保存数据
		List<Alarmpatrol> list = new ArrayList<Alarmpatrol>();
		
		// 获取实时表数据
		Real_time_data real = apMonitoringDao.findReal();
		// 获取报警设置表数据
		List<Alarmseteings> all = apMonitoringDao.findAll();
		// 将对象转换成map, 以方便后续操作
		Map<String, Object> map = ApMonitoringServiceImpl.objectToMap(real);
		
		// 遍历map集合
		for(String s:map.keySet()){
             // 遍历报警设置list集合
             for (Alarmseteings ala : all) {
            	 // 判断获取的实时表中的数据名与报警设置的对象名是否一致
            	 if (s.equals(ala.getPosition_name())) {
            		 // 新建一个对象, 用来保存数据
            		 Alarmpatrol al = new Alarmpatrol();
            		 // 获取当前键值对的值
            		 double d = Double.parseDouble(map.get(s).toString());
					// 一致则进行数据对比
            		 // 对比上限值
            		 if (d > ala.getUpperlimit()) {
						al.setUpDiff(d-ala.getUpperlimit());
					} else {
						al.setUpDiff(0);
					}
            		 // 对比下限值
            		 if (d < ala.getLowerlimit()) {
						al.setLowDiff(ala.getLowerlimit() - d);
					} else {
						al.setLowDiff(0);
					}
            		 // 判断是否将对象写入集合
            		 if (d > ala.getUpperlimit() || d < ala.getLowerlimit()) {
            			 // 写入点位名
						al.setAp_name(s);
						// 写入状态码
						al.setAp_state(0);
						// 写入当前时间
						al.setAp_time(new Date());
						// 写入点位描述
						al.setDescribe(ala.getDescribe());
						// 写入点位实际值
						al.setMeasured_value(d+"");
						// 存入集合
						list.add(al);
					}
				}
             }
             
         }
		return list;
	}
	
	// 报警信息写入数据库方法
	@Override
	public void writeAlarmpatrol() {
		// 获取list
		List<Alarmpatrol> list = this.alarmpatrolMethod();
		// 判断是否报警
		if (!list.isEmpty()) {
			// 调用写入报警信息方法
			apMonitoringDao.writeAlarmpatrol(list);
		}
	}
	
	
	/*
	 * 对象转map
	 */
	public static Map<String, Object> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			
		}

		return map;
	}
}
