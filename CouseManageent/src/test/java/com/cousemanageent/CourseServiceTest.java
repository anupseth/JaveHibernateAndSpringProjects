package com.cousemanageent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.Assert.*;

import com.cousemanageent.entity.Course;
import com.cousemanageent.service.CourseService;

import ch.qos.logback.classic.Logger;

@SpringBootTest
class CourseServiceTest {

	@Autowired
	private CourseService courseService;
	
	private Course course = new Course("TestCourse1", 4, 5000);
	
	@Test
	public void saveCourse() {
		course = courseService.saveCourse(course);
		Assert.notNull(course);
	}
	
	
	@Test
	public void retreiveCourse() {
		
		course = courseService.retreiveCourse(3l);
		System.out.println("Course {}  --------------> "+  course);
		Assert.notNull(course);
	}
	
	@Test
	public void deleteCourse() {
		//long id = courseService.saveCourse(course).getId();
		courseService.deleteCourse(1l);
		//Assert.isNull(courseService.retreiveCourse(id));
	}
	

}
