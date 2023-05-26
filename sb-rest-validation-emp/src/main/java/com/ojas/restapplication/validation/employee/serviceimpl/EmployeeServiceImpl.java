package com.ojas.restapplication.validation.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.restapplication.validation.employee.entity.EmployeeEntity;
import com.ojas.restapplication.validation.employee.repo.EmployeeRepo;
import com.ojas.restapplication.validation.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity emp) {

		EmployeeEntity savedEmployee = empRepo.save(emp);
		return savedEmployee;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {

		return empRepo.findAll();
	}

	@Override
	public EmployeeEntity getEmployeeById(Integer eid) {

		return empRepo.findById(eid).get();
	}

	@Override
	public void deleteEmployeeById(Integer eid) {

		empRepo.deleteById(eid);

	}

}
