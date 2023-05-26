package com.ojas.jpawebapplication.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.jpawebapplication.entity.EmployeeEntity;
import com.ojas.jpawebapplication.model.Employee;
import com.ojas.jpawebapplication.repo.EmployeeRepo;
import com.ojas.jpawebapplication.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public boolean saveEmp(Employee emp) {
		// TODO Auto-generated method stub

		EmployeeEntity entity = new EmployeeEntity();

		BeanUtils.copyProperties(emp, entity);

		EmployeeEntity ent = empRepo.save(entity);
		boolean flag = false;
		if (ent != null)
			return true;

		return flag;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub

		List<EmployeeEntity> findAll = empRepo.findAll();
		List<Employee> addEmployees = new ArrayList<Employee>();
		for (EmployeeEntity entity : findAll) {
			Employee emp = new Employee();
			BeanUtils.copyProperties(entity, emp);
			addEmployees.add(emp);
		}
		return addEmployees;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		// TODO Auto-generated method stub

		Optional<EmployeeEntity> findById = empRepo.findById(eid);
		EmployeeEntity entity = findById.get();
		Employee emp = new Employee();
		BeanUtils.copyProperties(entity, emp);
		return emp;
	}

	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
	return true;
	}

	@Override
	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> findById = empRepo.findById(eid);
		EmployeeEntity entity = findById.get();
		boolean flag = false;
		if (entity != null) {
			empRepo.deleteById(eid);
			flag = true;
		}
		return flag;
	}

}
