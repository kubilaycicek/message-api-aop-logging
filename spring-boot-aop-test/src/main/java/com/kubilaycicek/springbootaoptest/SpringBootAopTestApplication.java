package com.kubilaycicek.springbootaoptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootAopTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopTestApplication.class, args);
	}

}
