package com.ojas.thymeleaf.productapllication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

	@Id
	@Column(name = "PID")
	@GenericGenerator(name = "meGenerator", strategy = "increment")
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(name = "PNAME")
	private String pname;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "PRICE")
	private Double Price;

}
