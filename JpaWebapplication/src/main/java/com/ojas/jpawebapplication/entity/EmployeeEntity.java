package com.ojas.jpawebapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;





import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employee_Table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

	@Id
	@Column(name = "EID")
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.AUTO)
	private Integer eid;
	@Column(name = "ENAME")
	private String ename;
	@Column(name = "EADD")
	private String eadd;
	@Column(name = "SALARY")
	private Double salary;

}
