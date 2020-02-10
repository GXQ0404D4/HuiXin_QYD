package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午9:42:57
* 类说明 control valve  调节阀
*/
@Data
@Component
public class ControlValue {
	
	private int id;
	private Float TJF0;  //比例值          R/W
	private Boolean TJF1;//手自动          R/W
	private Float TJF2;  //手动开度设定值  R/W
	private Float TJF3;  //目标压力        R/W
	private Float TJF4;  //积分值          R/W
	private Float TJF5;  //上游压力  R
	private Float TJF6;  //下游压力  R
	private Float TJF7;  //瞬时流量  R
	private Float TJF8;  //累积流量  R
	private Float TJF9;  //位置反馈  R
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date TJF_time;//调节阀时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date TJF_datatime;//调节阀数据时间
	private int state;//状态

}
