package com.ojas.restapplication.validation.employee.service;

import java.util.List;

import com.ojas.restapplication.validation.employee.entity.EmployeeEntity;

public interface EmployeeService {

	public EmployeeEntity addEmployee(EmployeeEntity emp);

	public List<EmployeeEntity> getAllEmployees();

	public EmployeeEntity getEmployeeById(Integer eid);

	public void deleteEmployeeById(Integer eid);

}
