package com.ojas.restapplication.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.restapplication.validation.model.User;
import com.ojas.restapplication.validation.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		System.out.println(user.getName());

		User savedUser = userService.createUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {

		User user = userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

}
