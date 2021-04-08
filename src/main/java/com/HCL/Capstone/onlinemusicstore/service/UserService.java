package com.HCL.Capstone.onlinemusicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.HCL.Capstone.onlinemusicstore.entity.User;
import com.HCL.Capstone.onlinemusicstore.repository.UserRepository;

@Service 
public class UserService {
	
	@Autowired 
	private PasswordEncoder encoder;
	
	@Autowired
	public UserRepository userRepo; 
	
	
	public Iterable<User> GetAllUsers () { 
		return userRepo.findAll(); 
	}
	
	public void findUserById (Long Id) { 
		userRepo.findById(Id);
	}
	
	
	public void createUser (User newUser) { 
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		userRepo.save(newUser);	
	}
	
	

}
