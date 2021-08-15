package com.cousemanageent.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Course {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min = 3, message = "Minimun name size shud be 3")
	private String name;
	
	@Positive(message = "Pleasse enter positive duration in Months")
	private int duration;
	
	@PositiveOrZero(message = "Pleasse enter positive fees or 0 as value")
	private int fees;
	
	@Enumerated(EnumType.STRING)
	private CourseStatus courseState;
	
	@Past
	@Basic
	@Temporal(TemporalType.DATE)
	private Date courseInceptionDate;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(@Size(min = 3, message = "Minimun name size shud be 3") String name,
			@Positive(message = "Pleasse enter positive duration in Months") int duration,
			@PositiveOrZero(message = "Pleasse enter positive fees or 0 as value") int fees) {
		super();
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}
	
	

	public Course(long id, @Size(min = 3, message = "Minimun name size shud be 3") String name,
			@Positive(message = "Pleasse enter positive duration in Months") int duration,
			@PositiveOrZero(message = "Pleasse enter positive fees or 0 as value") int fees) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

//	@Override
//	public String toString() {
//		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", fees=" + fees + "]";
//	}

	



	public CourseStatus getCourseState() {
		return courseState;
	}

	public void setCourseState(CourseStatus courseState) {
		this.courseState = courseState;
	}

	public Course(long id, @Size(min = 3, message = "Minimun name size shud be 3") String name,
			@Positive(message = "Pleasse enter positive duration in Months") int duration,
			@PositiveOrZero(message = "Pleasse enter positive fees or 0 as value") int fees, CourseStatus courseState,
			Date courseinceptionDate) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.courseState = courseState;
		this.courseInceptionDate = courseinceptionDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", fees=" + fees + ", courseState="
				+ courseState + ", courseinceptionDate=" + courseInceptionDate + "]";
	}

	public Date getCourseInceptionDate() {
		return courseInceptionDate;
	}

	public void setCourseInceptionDate(Date courseInceptionDate) {
		this.courseInceptionDate = courseInceptionDate;
	}

	
}
