package com.ojas.restapplication.validation.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.restapplication.validation.employee.entity.EmployeeEntity;
import com.ojas.restapplication.validation.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/saved")
	public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeEntity empSaved = empService.addEmployee(emp);
		return new ResponseEntity<EmployeeEntity>(empSaved, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {

		List<EmployeeEntity> listOfAllEmployees = empService.getAllEmployees();
		return new ResponseEntity<List<EmployeeEntity>>(listOfAllEmployees, HttpStatus.OK);
	}

	@GetMapping("/emp/{eid}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("eid") Integer empId) {

		EmployeeEntity employeeById = empService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeEntity>(employeeById, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("eid") Integer empId) {

		empService.deleteEmployeeById(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeEntity empSaved = empService.addEmployee(emp);
		return new ResponseEntity<EmployeeEntity>(empSaved, HttpStatus.CREATED);
	}

}
