package com.cousemanageent.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
//@NamedQuery(name = "Course.findByName",
//query = "select c from Course u where u.emailAddress = ?1")
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
	
	@OneToMany(mappedBy = "course")
	private List<Review> review;
	
	public Course() {
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

	public CourseStatus getCourseState() {
		return courseState;
	}

	public void setCourseState(CourseStatus courseState) {
		this.courseState = courseState;
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


	public Course(long id, @Size(min = 3, message = "Minimun name size shud be 3") String name,
			@Positive(message = "Pleasse enter positive duration in Months") int duration,
			@PositiveOrZero(message = "Pleasse enter positive fees or 0 as value") int fees, @Past Date courseInceptionDate,
			CourseStatus courseState) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.courseState = courseState;
		this.courseInceptionDate = courseInceptionDate;
	}


	public Course(@Size(min = 3, message = "Minimun name size shud be 3") String name,
			@Positive(message = "Pleasse enter positive duration in Months") int duration,
			@PositiveOrZero(message = "Pleasse enter positive fees or 0 as value") int fees, @Past Date courseInceptionDate,
			CourseStatus courseState) {
		super();
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.courseState = courseState;
		this.courseInceptionDate = courseInceptionDate;
	}


	public List<Review> getReview() {
		return review;
	}


	public void addReview(Review review) {
		this.review.add(review);
	}
	
}
