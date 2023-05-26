package com.ojas.restapplication.studentcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.restapplication.bean.Student;

@RestController
public class StudentController {

	@GetMapping(value = "/student/{sid}")
	public Student getStudentDetails(@PathVariable("sid") Integer studentId) {
		Student s = new Student();
		if (studentId == 101) {
			s.setStudentId(101);
			s.setStudentName("shiva");
			s.setStudentSkill("java");
		} else if (studentId == 102) {
			s.setStudentId(102);
			s.setStudentName("kalyan");
			s.setStudentSkill("react");

		}
		return s;
	}

}
