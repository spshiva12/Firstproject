package com.ojas.securityjdbcapplication.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "user_name")
	@Length(min = 5, message = "your username must have atleast 5 characters")
	private String username;
	@Column(name = "email")
	@Email(message = "please provide a valid email")
	@NotEmpty(message = "please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "Your password must have 5 characters")
	@NotEmpty(message = "please provide password")
	private String password;

	@Column(name = "name")
	@NotEmpty(message = "please provide name")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "pleas provide lastname")
	private String lastname;

	@Column(name = "active")
	private Boolean active;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

}
