package com.cousemanageent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cousemanageent.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query("Select c from Course c where c.name like %?1%")
	List<Course> findByName(String name);

}
