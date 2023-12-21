package com.learnSphere.services;

public interface UserService {
	String addUser(String name, String email, String password, String role);
	boolean checkEmail(String email);
	boolean valid(String email,String password);
}
