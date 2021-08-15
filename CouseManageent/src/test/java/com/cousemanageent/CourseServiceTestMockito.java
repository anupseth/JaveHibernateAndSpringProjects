package com.cousemanageent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cousemanageent.entity.Course;
import com.cousemanageent.entity.CourseStatus;
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
	
	
	private Course course = new Course("TC1", 5, 1000, new Date(), CourseStatus.ACTIVE);
	
	@Test
	public void saveCourse() {
		
		Mockito.when(courserepo.save(course)).thenReturn(new Course(2,"TC1", 5, 1000, new Date(), CourseStatus.ACTIVE));
		Course saveCourse = courseService.saveCourse(course);
		System.out.println(" Course saved {}" + saveCourse);
		Assertions.assertNotNull(saveCourse);
	}
	
	
	@Test
	public void retreiveCourse() {
		Mockito.when(courserepo.findById(1l)).thenReturn(Optional.of(new Course(3,"TC1", 5, 1000, new Date(), CourseStatus.ACTIVE)));
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
		courseList.add(new Course(2,"TC1", 5, 1000, new Date(), CourseStatus.ACTIVE));
		courseList.add(new Course(2,"TC1", 5, 1000, new Date(), CourseStatus.ACTIVE));
		courseList.add(new Course(2,"TC1", 5, 1000, new Date(), CourseStatus.ACTIVE));
		
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		
		Mockito.when(courserepo.findAll(sort)).thenReturn(courseList);
		List<Course> courseListfromdb = courseService.getAllCourse();
		Assertions.assertEquals(3, courseListfromdb.size());
		
	}

}
