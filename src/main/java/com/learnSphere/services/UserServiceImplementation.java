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
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return "User Added Successfully";
	}

}
