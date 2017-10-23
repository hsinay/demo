package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int row) throws SQLException {
		Employee employee = new Employee();
		employee.setSapid(rs.getInt("SAPID"));
		employee.setName(rs.getString("name"));
		employee.setDesignation(rs.getString("designation"));
		return employee;
	}

}
