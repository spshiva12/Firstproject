package com.ojas.jpawebapplication.model;

import lombok.Data;

@Data
public class Product {

	private int pid;
	private String pname;
	private String price;
	private int qty;

}
