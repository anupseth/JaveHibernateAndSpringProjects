package com.cousemanageent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cousemanageent.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
