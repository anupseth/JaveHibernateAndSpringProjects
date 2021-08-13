package com.cousemanageent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", fees=" + fees + "]";
	}
	
	
	
}
