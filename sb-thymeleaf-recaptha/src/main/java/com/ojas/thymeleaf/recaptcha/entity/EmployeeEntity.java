package com.ojas.thymeleaf.recaptcha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "emp_recaptha")
@Data
public class EmployeeEntity {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double salary;
	private String address;

}
