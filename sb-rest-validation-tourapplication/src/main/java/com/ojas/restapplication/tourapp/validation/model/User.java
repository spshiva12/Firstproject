package com.ojas.restapplication.tourapp.validation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user2")
public class User {

	@Id
	private String id;

	private String name;

	private String email;

}
