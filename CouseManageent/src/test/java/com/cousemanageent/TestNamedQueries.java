package com.cousemanageent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public void testNamedQueryByName() {
		List<Course> findByName = courseRepository.findByName("step");
		Assertions.assertEquals(3, findByName.size());
	}

	
	@Test
	public void testNamedQueryByDate() {
//		String fromDate="2017-01-01";  
//		String toDate="2020-01-01";  
//		Date dateFrom = null;
//		Date dateTo = null;
//	    try {
//	    	dateFrom =new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
//	    	dateTo =new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
//	    	System.out.println("************** DATES *********************");
//	    	System.out.println(dateFrom.toString());
//	    	System.out.println(dateTo.toString());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}  
	    
		String fromDate="01-01-2017";  
		String toDate="01-01-2020";  
		Date dateFrom = null;
		Date dateTo = null;
	    try {
	    	dateFrom =new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
	    	dateTo =new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
	    	System.out.println("************** DATES *********************");
	    	System.out.println(dateFrom.toString());
	    	System.out.println(dateTo.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		List<Course> findByName = courseRepository.findByDate(dateFrom,dateTo);
		System.out.println("*****************************************");
		System.out.println(findByName);
		Assertions.assertEquals(2, findByName.size());
	}
	
	@Test
	public void testNamedQueryByFees() {
		List<Course> findByName = courseRepository.findByFees(4000, 8000);
		Assertions.assertEquals(1, findByName.size());
	}
	
	@Test
	public void testNamedQueryByDuration() {
		List<Course> findByName = courseRepository.findByDeration(5,13);
		Assertions.assertEquals(2, findByName.size());
	}
	
	
}
