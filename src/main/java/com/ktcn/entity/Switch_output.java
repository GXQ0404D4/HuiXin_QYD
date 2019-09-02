package com.ktcn.entity;

import java.util.Date;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
=======
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
>>>>>>> branch 'master' of https://github.com/qiuxinquan1014/Ktcn_QYD.git

import lombok.Data;

/*
 * 开关量输出
 */
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class Switch_output {
	private int output_id;		// 主键
	private String switch_name;
	private int switch_ouput;
	private int state;
	private String introduce;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
}
