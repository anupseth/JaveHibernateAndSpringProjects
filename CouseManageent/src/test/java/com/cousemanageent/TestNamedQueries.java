package com.cousemanageent;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cousemanageent.entity.Course;
import com.cousemanageent.repository.CourseRepository;

@SpringBootTest()
@Transactional
@Sql({"/TestEnv.sql"})
class TestNamedQueries {

	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test
	public void testNamedQuery() {
		List<Course> findByName = courseRepository.findByName("step");
		Assertions.assertEquals(3, findByName.size());
	}
	

	

}
