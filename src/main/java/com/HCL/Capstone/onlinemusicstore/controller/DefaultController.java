package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HCL.Capstone.onlinemusicstore.entity.Product;

@Controller
@RequestMapping("/")
public class DefaultController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping()
	public String defaultPath(HttpServletRequest req) {
		if(req.getSession().getAttribute("cart") == null) {
			List<Product> cart = new ArrayList<>();
			req.getSession().setAttribute("cart", cart);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@CREATING CART");
		}		
    //checking if user object is stored in session after login
		//logger.info(req.getSession().getAttribute("user").toString());
		return "home"; 
	}
	
	@GetMapping("/home")
	public String home(HttpServletRequest req) {
		if(req.getSession().getAttribute("cart") == null) {
			List<Product> cart = new ArrayList<>();
			req.getSession().setAttribute("cart", cart);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@CREATING CART");
		}
		return "home"; 
  }
	@GetMapping("/home2")
	public String home() {
		return "home2"; 
	}
	
	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
	
	@GetMapping("/instruments")
	public String instruments() {
		return "instruments"; 
	}
	
	@GetMapping("/accessory")
	public String accessory() {
		return "accessory"; 
	}
	
	@GetMapping("/services")
	public String services() {
		return "services"; 
	}
	
	@GetMapping("/register")
	public String register() {
		return "register"; 
	}
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "denied"; 
	}
}
