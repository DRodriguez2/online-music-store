package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HCL.Capstone.onlinemusicstore.entity.Product;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	@GetMapping()
	public String defaultPath(HttpServletRequest req) {
		List<Product> cart = new ArrayList<>();
		req.getSession().setAttribute("cart", cart);
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
	
	@GetMapping("/register")
	public String register() {
		return "register"; 
	}
}
