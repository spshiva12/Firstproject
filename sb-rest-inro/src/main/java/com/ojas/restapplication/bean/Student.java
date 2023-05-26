package com.ojas.restapplication.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@JsonInclude
public class Student {
	@JsonProperty("sno")
	private Integer studentId;
	@JsonProperty("sname")
	private String studentName;
	@JsonProperty("sadd")
	private String studentSkill;

}
