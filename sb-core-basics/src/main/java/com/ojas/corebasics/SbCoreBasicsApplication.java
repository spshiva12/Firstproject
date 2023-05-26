package com.ojas.corebasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ojas.corebasics.doctor.Doctor;

@SpringBootApplication
public class SbCoreBasicsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SbCoreBasicsApplication.class, args);
		
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");
		Doctor doc = context.getBean(Doctor.class);
		doc.assist();
//		Doctor doc = new Doctor();
//		doc.assist();
	}

}
