package com.ojas.restapplication.tourapp.validation.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

	Group findByName(String name);
}
