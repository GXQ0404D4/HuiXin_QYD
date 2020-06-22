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
	private Object TJF0;  
	private Object TJF1;
	private Object TJF2;  
	private Object TJF3;  
	private Object TJF4;  
	private Object TJF5;  
	private Object TJF6;  
	private Object TJF7;  
//	private Object TJF8;  
//	private Object TJF9;  
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date TJF_time;//调节阀时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date TJF_datatime;//调节阀数据时间
	private int state;//状态

}
