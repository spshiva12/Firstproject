package com.ojas.restapplication.tourapp.validation.model;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Event2")
public class Event {

	@Id
	@GeneratedValue
	private Long id;
	private Instant date;
	private String title;
	private String description;
	@ManyToMany
	private Set<User> attendees;

}
