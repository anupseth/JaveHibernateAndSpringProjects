package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class EmployeeColl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@ElementCollection
	@CollectionTable(name="Nicknames")
	@Column(name="Phone_numbers")
	private List<String> phoneList = new ArrayList<String>();
	
	public EmployeeColl() {
		
	}

	public EmployeeColl(String empName, String... phoneNumbers) {
		super();
		this.empName = empName;
		this.phoneList = Arrays.asList(phoneNumbers);
		this.phoneList.forEach(System.out::println);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<String> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}

	@Override
	public String toString() {
		return "EmployeeColl [employeeId=" + employeeId + ", empName=" + empName + ", phoneList=" + phoneList + "]";
	}
	
	
	
	
	

}
