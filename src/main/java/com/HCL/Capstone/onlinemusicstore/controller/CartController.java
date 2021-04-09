package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired private ProductService ps;
	
	@GetMapping()
	public String showCart() {
		return "cart";
	}
	
//	@PostMapping("/add")
//	public String addToCart (@RequestParam Long id, @RequestParam String view, HttpServletRequest req) throws ProductNotFoundException {
//		
//		//add Product to the cart by update session object
//		@SuppressWarnings("unchecked")
//		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
//		cart.add(ps.getProductById(id));
//		req.getSession().setAttribute("cart", cart);
//
//		return view;
//	}
	
	@PostMapping("/add")
	public String addToCart (@RequestParam Long id, @RequestParam List<Object> table, @RequestParam String view,  Model model, HttpServletRequest req) throws ProductNotFoundException {
		
		//add Product to the cart by update session object
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
		cart.add(ps.getProductById(id));
		req.getSession().setAttribute("cart", cart);
		
		if(table.get(0) instanceof Music) {
			model.addAttribute("searchResult", table.stream().map(object -> (Music) object).collect(Collectors.toList()));
		} else if(table.get(0) instanceof Services) {
			model.addAttribute("searchResult", table.stream().map(object -> (Services) object).collect(Collectors.toList()));
		}  else if(table.get(0) instanceof Instrument) {
			model.addAttribute("searchResult", table.stream().map(object -> (Instrument) object).collect(Collectors.toList()));
		}  else if(table.get(0) instanceof Accessory) {
			model.addAttribute("searchResult", table.stream().map(object -> (Accessory) object).collect(Collectors.toList()));
		} else view = "theres a problem";
		
		return view;
	}
	
	
}
