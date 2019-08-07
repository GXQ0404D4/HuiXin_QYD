package com.ktcn.initial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartGlobalKeyboard implements CommandLineRunner {
	// 当服务器启动即执行此方法
	@Override
	public void run(String... args) throws Exception {
		System.out.println("服务器启动了!");
	}
	
}
