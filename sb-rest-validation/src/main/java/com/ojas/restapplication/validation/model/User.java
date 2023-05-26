package com.ojas.restapplication.validation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Table(name = "users")
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "username should have atleast 2 characters")
	private String name;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(min = 8, message = "password must should have atleast 8 characters")
	private String password;

}
