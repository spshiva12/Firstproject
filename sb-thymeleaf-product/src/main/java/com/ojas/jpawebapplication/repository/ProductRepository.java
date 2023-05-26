package com.ojas.jpawebapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.jpawebapplication.entity.ProEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProEntity, Integer> {

}
