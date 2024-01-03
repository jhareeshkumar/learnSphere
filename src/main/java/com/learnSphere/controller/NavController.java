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

	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
	}

	@GetMapping("/addLesson")
	public String addLesson() {
		return "addLesson";
	}

	@GetMapping("/trainerHome")
	public String trainerHome() {
		return "trainerHome";
	}

	@GetMapping("/studentHome")
	public String studentHome() {
		return "studentHome";
	}
	
	@GetMapping("/myCourses")
	public String myCourses() {
		return "myCourses";
	}

	@GetMapping("/purchase")
	public String purchase() {
		return "purchase";
	}

	@GetMapping("/myLesson")
	public String myLesson() {
		return "myLesson";
	}
	@GetMapping("/demoLesson")
	public String demoLesson() {
		return "demoLesson";
	}

}
