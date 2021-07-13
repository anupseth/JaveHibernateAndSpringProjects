package com.example.aop.aopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.aop.aopdemo.aop.SampleBean;
import com.example.aop.aopdemo.aop.aspectj.beans.UtilityClass;
import com.example.aop.aopdemo.aop.aspectj.beans.subpackage.SubPackageClass;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AopdemoApplication.class, args);
		SampleBean sam = ctx.getBean(SampleBean.class);
		
		UtilityClass utiClass = ctx.getBean(UtilityClass.class);
		SubPackageClass subPackageClass = ctx.getBean(SubPackageClass.class);

		System.out.println("**************************************************");
		
		sam.doSomething();
		
		System.out.println("**************************************************");
		
		utiClass.doSomething();
		
		System.out.println("**************************************************");
		
		subPackageClass.doSomething();
		
		
	}

}
