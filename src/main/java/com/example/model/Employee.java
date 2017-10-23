package com.example.model;


public class Employee {
	private String name;
	private String designation;
	private Integer sapid;
	
	public Employee() {}
	public Employee(String name, String designation, Integer sapid) {
		this.name = name;
		this.designation = designation;
		this.sapid = sapid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getSapid() {
		return sapid;
	}
	public void setSapid(Integer sapid) {
		this.sapid = sapid;
	}
}
