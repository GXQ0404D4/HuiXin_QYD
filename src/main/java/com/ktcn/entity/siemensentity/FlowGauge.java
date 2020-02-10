package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午10:24:06
* 类说明  flow gauge  流量计
*/
@Data
@Component
public class FlowGauge {
	
	private int id;
	private String FlowGauge_name;//流量计名字
	private Float LLJ0;  //补偿压力   R
	private Float LLJ1;  //补偿温度   R
	private Float LLJ2;  //瞬时流量   R
	private Float LLJ3;  //累积流量   R
	private Float LLJ4;  //管道压力   R
	private Float LLJ5;  //管道温度   R
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date LLJ_time; //流量计时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date LLJ_datatime; //流量计数据时间
	private int state;  //状态
	

}
