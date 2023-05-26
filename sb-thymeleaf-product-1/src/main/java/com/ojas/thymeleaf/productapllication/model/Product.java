package com.ojas.thymeleaf.productapllication.model;

import lombok.Data;

@Data
public class Product {

	private Integer pid;
	private String pname;
	private Integer quantity;
	private Double Price;

}
