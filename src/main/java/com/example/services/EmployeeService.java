package com.example.services;

import java.util.List;

/*import java.sql.Connection;
import java.sql.SQLException;
import org.apache.derby.iapi.sql.PreparedStatement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.EmployeeRowMapper;
import com.example.model.Employee;

@Service
public class EmployeeService {

@Autowired
private JdbcTemplate jdbcTemplate;



@Transactional(readOnly=true)
public List<Employee> findAll() {
    return jdbcTemplate.query("select * from Employee",new EmployeeRowMapper());
}

@Transactional(readOnly=true)
public Employee findUserById(int SAPID) {
    return jdbcTemplate.queryForObject(
        "select * from Employee where SAPID=?",
        new Object[]{SAPID}, new EmployeeRowMapper());
}

public Employee findYanish() {
	Employee e = new Employee();
	e.setSapid(5001);
	e.setName("Yanish");
	e.setDesignation("Senior Software Engineer");
	return e;
}
public void writeTo(Employee employee) {
	jdbcTemplate.update("INSERT INTO Employee(name, designation, SAPID) VALUES (?,?,?)",
            employee.getName(), employee.getDesignation(), employee.getSapid());
}

/*public Employee create(final Employee employee) 
{
    final String sql = "insert into Employee(SAPID,name,designation) values(?,?,?)";

    KeyHolder holder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getUserEmail());
            ps.setString(4, user.getAddress());
            return ps;
        }
    }, holder);

    int newUserId = holder.getKey().intValue();
    user.setUserId(newUserId);
    return user;
}*/
}