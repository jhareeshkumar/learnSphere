package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Users;
import com.learnSphere.services.UserService;

@Controller
public class ServiceController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String role) {
		// TODO: process POST request
		Users user = new Users();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		userService.addUser(user);
		return "login";
	}
}
