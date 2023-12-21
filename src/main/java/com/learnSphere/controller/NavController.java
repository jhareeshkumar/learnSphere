package com.learnSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
	}

	@GetMapping("/addLesson")
	public String addLesson() {
		return "addLesson";
	}

}
