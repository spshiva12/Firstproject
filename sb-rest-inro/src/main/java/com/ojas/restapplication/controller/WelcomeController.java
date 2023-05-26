package com.ojas.restapplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String sayHi() {
		return "Welcome to Restfull Webservices";

	}

//	@RequestMapping("/hello")
//	public String sayHello(@RequestParam("sname") String name) {
//		return "welcome :" + name;
//	}
	@GetMapping("/hello")
	public String hello(HttpServletRequest req) {
		String name = req.getParameter("sname");
		return "Welcome: " + name;
	}
	
	
}
