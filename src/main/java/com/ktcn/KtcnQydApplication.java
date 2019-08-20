package com.ktcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//public class KtcnQydApplication extends SpringBootServletInitializer{
//
//	public static void main(String[] args) {
//		SpringApplication.run(KtcnQydApplication.class, args);
//	}
//	/**
//	 *新增此方法
//	 */
//	 @Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//	   // 注意这里要指向原先用main方法执行的Application启动类
//	   return builder.sources(KtcnQydApplication .class);
//	}
//}
public class KtcnQydApplication{

	public static void main(String[] args) {
		SpringApplication.run(KtcnQydApplication.class, args);
	}
}