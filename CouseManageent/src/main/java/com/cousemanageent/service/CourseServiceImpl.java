package com.cousemanageent.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cousemanageent.entity.Course;
import com.cousemanageent.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Course saveCourse(Course course) {
		 Course save = courseRepo.save(course);
		 return save;
	}

	@Override
	public Course retreiveCourse(long id) {
		Optional<Course> course = courseRepo.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		 return null;
	}

	@Override
	public void deleteCourse(long id) {
		courseRepo.deleteById(id);
	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> allCourses = courseRepo.findAll();
		return allCourses;
	}

}
