package com.ojas.restapplication.tourapp.validation.component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ojas.restapplication.tourapp.validation.model.Event;
import com.ojas.restapplication.tourapp.validation.model.Group;
import com.ojas.restapplication.tourapp.validation.model.GroupRepository;

@Component
public class Initializer implements CommandLineRunner {

	private final GroupRepository repository;

	public Initializer(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {

		Stream.of("prasad", "kalyan", "kshiva", "ksp")
				.forEach(name -> repository.save(new Group(name)));

		Group djug = repository.findByName("prasad");
		Event e = Event.builder().title("Micro Frontends for Java Developers")
				.description("JHipster now has microfrontend support!").date(Instant.parse("2022-09-13T17:00:00.000Z"))
				.build();
		djug.setEvents(Collections.singleton(e));
		repository.save(djug);

		repository.findAll().forEach(System.out::println);
	}

}
