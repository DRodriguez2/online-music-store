package com.HCL.Capstone.onlinemusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.User;
import com.HCL.Capstone.onlinemusicstore.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userSer; 
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String uname, @RequestParam String pass2, @RequestParam long credit) {
		
		User newU = new User();

		newU.setUsername(uname);
		newU.setPassword(pass2);
		newU.setCreditCard(credit);
		userSer.createUser(newU);
		
		return "register";

	}
	
}
	 
	
	

