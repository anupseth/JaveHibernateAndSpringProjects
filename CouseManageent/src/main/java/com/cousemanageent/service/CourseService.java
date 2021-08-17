package com.cousemanageent.service;

import java.util.Date;
import java.util.List;

import com.cousemanageent.entity.Course;

public interface CourseService {
	
	public Course saveCourse(Course course);
	
	public Course retreiveCourse(long id);
	
	public void deleteCourse(long id);
	
	public List<Course> getAllCourse();
	
	public List<Course> getByName(String name);
	
	public List<Course> getByDate(Date fromDate, Date toDate);
	
	public List<Course> getByFees(int startFees, int endFees);
	
	public List<Course> getByDuration(int startDuration, int endDuration);
}
