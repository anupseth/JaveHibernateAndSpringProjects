package com.cousemanageent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cousemanageent.entity.Course;
import com.cousemanageent.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public Course saveCourse(Course course) {
		//logger.info("...........................Inside saveCourse ");
		 Course save = courseRepo.save(course);
		 //logger.info("..........................Course {} -> "+ save);
		 return save;
	}

	@Override
	public Course retreiveCourse(long id) {
		//logger.info("........................Inside retreiveCourse ");
		 Course save = courseRepo.getById(id);
		 if(save == null) {
			 return null;
		 }
		// logger.info("....................................Course {} -> "+ save);
		 return save;
	}

	@Override
	public void deleteCourse(long id) {
		//logger.info(".................Inside deleteCourse ");
		courseRepo.deleteById(id);
		//logger.info("...................Course deleted");
	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> allCourses = courseRepo.findAll();
		return allCourses;
	}

}
