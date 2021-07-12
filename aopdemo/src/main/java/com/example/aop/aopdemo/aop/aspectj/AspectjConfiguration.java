package com.example.aop.aopdemo.aop.aspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectjConfiguration {
	
	@Bean
	public LoggerAspect executeLoggerAspect() {
		return new LoggerAspect();
	}

}
