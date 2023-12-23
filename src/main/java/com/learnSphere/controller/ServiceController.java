package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.services.UserService;

@Controller
public class ServiceController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String role, Model model) {
		// TODO: process POST request
		if (userService.checkEmail(email) == false) {
			userService.addUser(name, email, password, role);
			model.addAttribute("registerSuccessMessage", "Thanks for registering Please Login!.");
			System.out.println("User registered successfully");
			return "login";
		} else {
			model.addAttribute("registerFailedMessage", "User already exists with same Email Id Please Login!.");
			System.out.println("user already exists");
			return "register";
		}
	}

	@PostMapping("/validate")
	public String validateUser(@RequestParam String email, @RequestParam String password, Model model) {
		// TODO: process POST request
		if (userService.checkEmail(email)) {
			if (userService.valid(email, password)) {
				String userRole = userService.getUserRole(email);
				if (userRole.equals("trainer"))
					return "trainerHome";
				else
					return "studentHome";
			} else {
				model.addAttribute("loginErrorMessage", "Incorrect Credentials");
				return "login";
			}
		}
		model.addAttribute("loginErrorMessage", "User not registered, Please register!.");
		return "login";
	}

}
