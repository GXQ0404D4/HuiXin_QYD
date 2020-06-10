package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2019年12月31日 上午9:58:38 类说明 drying machine 干燥机
 */
@Component
@Data
public class DryingMachine {

	private int id;
	private String DryingMachine_name; // 干燥机名字
	private Object GZJ0; // 容器A压力
	private Object GZJ1; // 容器B压力
	private Object GZJ2; // 加热器出口温度
	private Object GZJ3; // 容器A底端温度
	private Object GZJ4; // 容器B底端温度
	private Object GZJ5; // 干燥器压力露点
	private Object GZJ6; // 运行时间
	private Object GZJ7; // 加载时间
	private Object GZJ8; // 干燥机启动
	private Object GZJ9; // 干燥机停止
	private Date GZ_time;//
	private Date GZ_datatime;//
	private int state;//
}
