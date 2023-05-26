package com.ojas.jpawebapplication.entity;

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
@Table(name = "prod_table")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProEntity {

	@Id
	@Column(name = "PID")
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(name = "PNAME")
	private String pname;
	@Column(name = "PRICE")
	private String price;
	@Column(name = "QTY")
	private Integer qty;

}
