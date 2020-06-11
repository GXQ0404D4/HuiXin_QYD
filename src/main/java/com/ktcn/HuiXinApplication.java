package com.ktcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableAsync //开启异步调用
@SpringBootApplication
@EnableScheduling
@ServletComponentScan // 解决跨域session丢失问题\
@EnableTransactionManagement //注解事务
//public class HuXinApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(HuXinApplication.class, args);
//	}
//
//	/**
//	 * 新增此方法
//	 */
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		// 注意这里要指向原先用main方法执行的Application启动类
//		return builder.sources(HuXinApplication.class);
//	}
//}
public class HuiXinApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(HuiXinApplication.class, args);
		
	}
}