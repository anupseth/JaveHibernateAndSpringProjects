package com.cousemanageent.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cousemanageent.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query("Select c from Course c where c.name like %?1%")
	List<Course> findByName(String name);
	
	
	@Query("Select c from Course c where c.courseInceptionDate > ?1 and "
			+ "c.courseInceptionDate < ?2")
	List<Course> findByDate(Date dateFrom, Date dateTo);

}
