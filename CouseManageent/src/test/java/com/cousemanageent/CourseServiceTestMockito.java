package com.cousemanageent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cousemanageent.entity.Course;
import com.cousemanageent.repository.CourseRepository;
import com.cousemanageent.service.CourseServiceImpl;
@SpringBootTest()
@Transactional
@Sql({"/TestEnv.sql"})
class CourseServiceTestMockito {

	@InjectMocks
	CourseServiceImpl courseService;
	
	@Mock
	CourseRepository courserepo;
	
	
	private Course course = new Course(1,"TestCourse1", 4, 5000);
	
	@Test
	public void saveCourse() {
		
		Mockito.when(courserepo.save(course)).thenReturn(new Course(2,"TestCourse1", 6, 58000));
		Course saveCourse = courseService.saveCourse(course);
		System.out.println(" Course saved {}" + saveCourse);
		Assertions.assertNotNull(saveCourse);
	}
	
	
	@Test
	public void retreiveCourse() {
		Mockito.when(courserepo.findById(1l)).thenReturn(Optional.of(new Course(3,"TestCourse1", 6, 58000)));
		course = courseService.retreiveCourse(1l);
		System.out.println("Course retreived {} = "+ course);
		Assertions.assertNotNull(course);
	}
	
	@Test
	public void deleteCourse() {
		
	}
	
	@Test
	public void getAllCourses() {
		
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course(3,"TestCourse1", 6, 58000));
		courseList.add(new Course(3,"TestCourse1", 6, 58000));
		courseList.add(new Course(3,"TestCourse1", 6, 58000));
		
		
		Mockito.when(courserepo.findAll()).thenReturn(courseList);
		List<Course> courseListfromdb = courseService.getAllCourse();
		Assertions.assertEquals(3, courseListfromdb.size());
		
	}

}
