package com.ojas.restapplication.validation.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.restapplication.validation.employee.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
