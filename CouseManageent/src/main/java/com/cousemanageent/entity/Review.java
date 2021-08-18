package com.cousemanageent.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	@Size(min = 5, message = "Minimun name size shud be 5")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Course course;
	
	@Transient
	private long courseId;
	
	public Review() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Review(long id, @Size(min = 5, message = "Minimun name size shud be 5") String description, Course course) {
		super();
		this.id = id;
		this.description = description;
		this.course = course;
	}

	public Review(@Size(min = 5, message = "Minimun name size shud be 5") String description, Course course) {
		super();
		this.description = description;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + "]";
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	
	
	
}
