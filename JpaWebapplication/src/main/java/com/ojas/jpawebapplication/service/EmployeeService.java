package com.ojas.jpawebapplication.service;

import java.util.List;

import com.ojas.jpawebapplication.model.Employee;

public interface EmployeeService {

	public boolean saveEmp(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int eid);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int eid);

}
