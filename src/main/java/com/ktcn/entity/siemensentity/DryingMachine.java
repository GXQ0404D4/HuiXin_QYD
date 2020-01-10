package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午9:58:38
* 类说明  drying machine  干燥机
*/
@Data
@Component
public class DryingMachine {

	private int id;
	private String DryingMachine_name; //干燥机名字
	private  Object GZJ0;   //A塔吸附计时     R
	private  Object GZJ1;   //A塔加热计时     R
	private  Object GZJ2;   //A塔冷吹计时     R
	private  Object GZJ3;   //B塔吸附计时     R
	private  Object GZJ4;   //B塔加热计时     R
	private  Object GZJ5;   //B塔冷吹计时     R
	private  Object GZJ6;   //均压计时        R
	private  Object GZJ7;   //压缩空气进气温度R
	private  Object GZJ8; //A塔状态         R
	private  Object GZJ9; //B塔状态         R
	private  Object GZJ10;  //加热器温度      R
	private  Object GZJ11;  //加热器出口温度  R
	private  Object GZJ12;//设备故障        R
	private  Object GZJ13;//加热器工作      R
	private  Object GZJ14;//鼓风机工作      R
	private  Object GZJ15;//远程状态        R
	private  Object GZJ16;//运行状态        R
	private  Object GZJ17;//干燥机启动    R/W
	private  Object GZJ18;//干燥机停止    R/W
	private  Object GZJ19;//1阀状态      R
	private  Object GZJ20;//2阀状态      R
	private  Object GZJ21;//3阀状态      R
	private  Object GZJ22;//4阀状态      R
	private  Object GZJ23;//5阀状态      R
	private  Object GZJ24;//6阀状态      R
	private  Object GZJ25;//7阀状态      R
	private  Object GZJ26;//8阀状态      R
	private  Object GZJ27;//9阀状态      R
	private  Object GZJ28;//10阀状态     R
	private  Object GZJ29;//11阀状态     R
	private  Object GZJ30;//12阀状态     R
	private  Object GZJ31;//13阀状态     R
	private  Object GZJ32;  //当前运行分钟数 R
	private  Object GZJ33;  //当前运行小时数 R
	private  Object GZJ34;  //当前运行天数  R
	private  Object GZJ35;  //累计运行分钟数 R
	private  Object GZJ36;  //累计运行小时数 R
	private  Object GZJ37;  //累计运行天数  R
	private  Date GZ_time; //干燥机时间
	private  Date GZ_datatime;//干燥机数据时间
	private  int state;//状态
}
