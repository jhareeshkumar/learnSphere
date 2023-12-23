package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Users;
import com.learnSphere.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String addUser(String name, String email, String password, String role) {
		// TODO Auto-generated method stub
		Users user = new Users();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		userRepository.save(user);
		return "User Added Successfully";
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);

	}

	@Override
	public boolean valid(String email, String password) {
		// TODO Auto-generated method stub
		if (userRepository.existsByEmail(email)) {
			Users user = userRepository.findByEmail(email);
			if (password.equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String getUserRole(String email) {
		// TODO Auto-generated method stub
		Users user = userRepository.findByEmail(email);
		return user.getRole();
	}

}
