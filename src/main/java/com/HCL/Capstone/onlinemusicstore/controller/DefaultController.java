package com.HCL.Capstone.onlinemusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	@GetMapping
	public String defaultPath() {
		return "home"; 
	}
	
	@GetMapping("/home")
	public String home() {
		return "home"; 
	}
	
	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
	
	@GetMapping("/instruments")
	public String instruments() {
		return "instruments"; 
	}
	
	@GetMapping("/services")
	public String services() {
		return "services"; 
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "cart"; 
	}
	
	@GetMapping("/register")
	public String register() {
		return "register"; 
	}
}
