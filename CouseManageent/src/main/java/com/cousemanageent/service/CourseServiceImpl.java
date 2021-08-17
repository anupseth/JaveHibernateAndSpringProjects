package com.cousemanageent.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		Course coursefromrepo = null;
		Course save = null;
		logger.info(" ->>>>>>>>>>>>>>>>> Course Id :" + course.getId());
		if (course.getId() > 0 && courseRepo.existsById(course.getId())) {
			coursefromrepo = courseRepo.getById(course.getId());
			coursefromrepo = course;
		}
		save = courseRepo.save(coursefromrepo);
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
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		List<Course> allCourses = courseRepo.findAll(sort);
		return allCourses;
	}

	@Override
	public List<Course> getByName(String name) {
		return courseRepo.findByName(name);
	}

	@Override
	public List<Course> getByDate(Date fromDate, Date toDate) {
		return courseRepo.findByDate(fromDate, toDate);
	}


}
