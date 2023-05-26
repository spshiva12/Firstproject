package com.ojas.thymeleaf.recaptcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.thymeleaf.recaptcha.entity.EmployeeEntity;
import com.ojas.thymeleaf.recaptcha.repository.EmployeeRepo;
import com.ojas.thymeleaf.recaptcha.service.RecaptchaValidationService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private RecaptchaValidationService validataor;

	@Autowired
	private EmployeeRepo empRepo;

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employee,

			@RequestParam(name = "g-recaptcha-response") String captcha, Model model) {
		if (validataor.validateCaptcha(captcha)) {
			empRepo.save(employee);
			model.addAttribute("employee", new EmployeeEntity());
			model.addAttribute("message", "Employee added!!");
		} else {
			model.addAttribute("message", "Please Verify Captcha");
		}
		return "EmployeeRegister";
	}

	@GetMapping("/all")
	public String getAllEmployees(Model model) {
		model.addAttribute("list", empRepo.findAll());
		return "EmployeeData";

	}

}
