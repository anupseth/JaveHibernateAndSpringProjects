package com.one2Many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phoneId;
	private int phoneNumber;
	
	public Phone() {
		
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int id) {
		this.phoneId = id;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Phone(int phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Phone [id=" + phoneId + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
