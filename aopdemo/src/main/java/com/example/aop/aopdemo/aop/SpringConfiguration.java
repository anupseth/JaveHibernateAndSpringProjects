package com.example.aop.aopdemo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.aop.aopdemo.aop.aspectj.beans.UtilityClass;
import com.example.aop.aopdemo.aop.aspectj.beans.subpackage.SubPackageClass;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public SampleBean sampleBean() {
		return new SampleBean();
	}

	@Bean
	public UtilityClass utilityClass() {
		return new UtilityClass();
	}
	
	
	@Bean
	public SubPackageClass subPackageClass() {
		return new SubPackageClass();
	}
}
