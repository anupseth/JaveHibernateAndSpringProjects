package com.cousemanageent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cousemanageent.entity.Course;
import com.cousemanageent.service.CourseService;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
@SpringBootTest()
@Transactional
@Sql({"/TestEnv.sql"})
class CourseServiceTest {

	@Autowired
	CourseService courseService;
	
	
	private Course course = new Course("TestCourse1", 4, 5000);
	
	@Test
	public void saveCourse() {
		course = courseService.saveCourse(course);
		Assertions.assertNotNull(course);
	}
	
	
	@Test
	public void retreiveCourse() {
		
		course = courseService.retreiveCourse(102l);
		Assertions.assertNotNull(course);
	}
	
	@Test
	public void deleteCourse() {
		
		courseService.deleteCourse(103l);
		Assertions.assertNull(courseService.retreiveCourse(1003l));
	}
	
	@Test
	public void getAllCourses() {
		
		List<Course> courseList = courseService.getAllCourse();
		Assertions.assertEquals(3, courseList.size());
		
	}

}
