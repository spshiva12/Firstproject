package com.ojas.restapplication.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.restapplication.validation.model.User;
import com.ojas.restapplication.validation.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(long id) {
		return userRepository.findById(id).get();
	}

}
