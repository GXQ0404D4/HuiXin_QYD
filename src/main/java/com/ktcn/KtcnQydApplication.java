package com.ktcn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
	
<<<<<<< HEAD
=======
	/*
	  * 解决跨域问题
	  */
	 private CorsConfiguration buildConfig() {
	  CorsConfiguration corsConfiguration = new CorsConfiguration();
	  corsConfiguration.addAllowedOrigin("*");
	  corsConfiguration.addAllowedHeader("*");
	  corsConfiguration.addAllowedMethod("*");
	  return corsConfiguration;
	 }
	 
	 public CorsFilter corsFilter() {
	  System.out.println("=====设置跨域过滤器=====");
	  UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	  source.registerCorsConfiguration("/**", buildConfig());
	  return new CorsFilter(source);
	 }
>>>>>>> branch 'master' of https://github.com/qiuxinquan1014/Ktcn_QYD.git
}