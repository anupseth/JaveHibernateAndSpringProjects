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
	
	@Query("Select c from Course c where c.fees > 1 and "
			+ "c.fees < 20")
	List<Course> findByFees(int startFees, int endFees);
	
	
	@Query("Select c from Course c where c.duration BETWEEN ?1 AND ?2")
	List<Course> findByDeration(int startDuration, int endDuration);

}
