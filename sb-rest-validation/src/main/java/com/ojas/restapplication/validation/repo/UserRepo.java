package com.ojas.restapplication.validation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ojas.restapplication.validation.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
