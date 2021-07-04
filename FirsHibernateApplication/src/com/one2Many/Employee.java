package com.one2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@OneToMany
	@JoinTable(name = "EMP_PHONE")
	@JoinColumn(name = "Emp_ID")
	private List<Phone> phoneList = new ArrayList<Phone>();
	
	
	public Employee(String empName, List<Phone> phoneList) {
		super();
		this.empName = empName;
		this.phoneList = phoneList;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public List<Phone> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	public Employee() {
		super();
	}
	public Employee(List<Phone> phoneList) {
		super();
		this.phoneList = phoneList;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", phoneList=" + phoneList + "]";
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	

}
