package com.ojas.java8.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ojas.java8.entity.Employee;
import com.ojas.java8.mapper.EmployeeMapper;

public class EmployeeDao {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM Employee";
		List<Employee> employees = jdbcTemplate.query(sql, new EmployeeMapper());

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		return employees;

	}

}
