package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface DataBaseDAO {
	public int getCount();
	public List<Employee> listAll();
	public void save(Employee employee);
	public void delete(Employee employee);
}
