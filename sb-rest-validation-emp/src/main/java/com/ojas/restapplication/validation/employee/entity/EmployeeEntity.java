package com.ojas.restapplication.validation.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "emp_rest")
@Data
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	@Column(name = "ename")
	@NotEmpty
	@Size(min = 4, message = "empname must should have 4 letters")
	private String ename;

	@NotEmpty
	@Email
	private String email;

	private Long salary;
	
	@DateTimeFormat
	private Date date;

}
