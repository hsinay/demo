package com.example.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.dao.DataBaseDAO;
import com.example.model.Employee;

@Service
public class DataBaseDAOImpl implements DataBaseDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int getCount() {
		
		return 0;
	}

	@Override
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
