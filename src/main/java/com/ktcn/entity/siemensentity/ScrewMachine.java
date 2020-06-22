package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午10:29:02
* 类说明 screw machine   螺杆机
*/
@Data
@Component
public class ScrewMachine {

	private int id;
	private String ScrewMachine_name;//螺杆机名字
	private Object LGJ0;   //压缩机出口压力
	private Object LGJ1;   //空气过滤器压差
	private Object LGJ2;   //主机喷油压力
	private Object LGJ3;    //油分离器压差
	private Object LGJ4;    //空压机出口温度
	private Object LGJ5;    //主机出口温度
	private Object LGJ6;    //冷却水出口压力
	private Object LGJ7;    //运行时间
	private Object LGJ8;    //加载时间
	private Object LGJ9;    //电机启动次数
	private Object LGJ10;   //加载继电器
	private Object LGJ11;   //控制器运行时间
	private Object LGJ12;   //空压机投入写2.切除写1
	private Object LGJ13;   //报警
	private Object LGJ14;   //报警
	private Object LGJ15;   //报警
	private Object LGJ16;   //报警
	private Object LGJ17;   //加卸载
	private Object LGJ18;   //远程本地
	private Object LGJ19;   //运行/停止
	private Object LGJ20;   //空压机 启动
	private Object LGJ21;   //空压机 停止
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date LGJ_time; //空压机时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date LGJ_datatime;//空压机数据时间
	private int state;//状态
}
