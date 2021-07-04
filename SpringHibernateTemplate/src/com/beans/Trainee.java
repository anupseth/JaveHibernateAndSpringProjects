package com.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String traineeName;
	
	private int traineeAge;

	public Trainee() {
		super();
	}

	public Trainee(String traineeName, int traineeAge) {
		super();
		this.traineeName = traineeName;
		this.traineeAge = traineeAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public int getTraineeAge() {
		return traineeAge;
	}

	public void setTraineeAge(int traineeAge) {
		this.traineeAge = traineeAge;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", traineeName=" + traineeName + ", traineeAge=" + traineeAge + "]";
	}
	
	
	
}
