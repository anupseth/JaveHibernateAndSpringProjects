package com.example.aop.aopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.aop.aopdemo.aop.SampleBean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AopdemoApplication.class, args);
		SampleBean sam = ctx.getBean(SampleBean.class);

		System.out.println("**************************************************");
		
		sam.doSomething();
	}

}
