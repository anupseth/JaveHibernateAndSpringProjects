package com.pojo;

import org.springframework.beans.factory.DisposableBean;

public class Employee implements DisposableBean{
	
	private int id;
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name) {
		super();
		System.out.println("Inside constructor.....");
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Dispose ............");
		
	}
	
	
	
	

}
