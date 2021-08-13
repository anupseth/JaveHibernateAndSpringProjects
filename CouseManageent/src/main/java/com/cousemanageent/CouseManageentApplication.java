package com.cousemanageent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.cousemanageent.entity.Course;
import com.cousemanageent.service.CourseService;

@SpringBootApplication
public class CouseManageentApplication {

	@Autowired
	private CourseService service;
	
	public static void main(String[] args) {
		SpringApplication.run(CouseManageentApplication.class, args);
	}

//	@Override
//	@Transactional
//	public void run(String... args) throws Exception {
//		
//		System.out.println("asdaad");
//		Course retreiveCourse = service.retreiveCourse(1001l);
//		
//		System.out.println("******************************");
//		System.out.println(retreiveCourse);
//		System.out.println("******************************");
//	}

}
