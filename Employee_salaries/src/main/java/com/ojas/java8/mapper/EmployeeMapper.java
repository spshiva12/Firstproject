package com.ojas.java8.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ojas.java8.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));

		employee.setAge(rs.getInt("age"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}

}
