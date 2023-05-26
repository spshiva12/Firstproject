package com.ojas.securityapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/admin")
	public String user() {
		return "admin";
	}

	@GetMapping("/basic")
	public String basic() {
		return "basic";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
