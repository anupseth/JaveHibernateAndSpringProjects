package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Employee;
import com.pojo.Hello;

public class SpringCoreMain {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee hello = (Employee)appContext.getBean("e1");
		
		System.out.println(hello);

	}

}
