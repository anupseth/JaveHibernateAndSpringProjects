package com.example.aop.aopdemo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public SampleBean sampleBean() {
		return new SampleBean();
	}

}
