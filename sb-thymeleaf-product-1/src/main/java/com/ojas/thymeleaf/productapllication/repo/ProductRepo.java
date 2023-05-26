package com.ojas.thymeleaf.productapllication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.thymeleaf.productapllication.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
