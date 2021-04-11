package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.AccessoryService;
import com.HCL.Capstone.onlinemusicstore.service.InstrumentService;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;
import com.HCL.Capstone.onlinemusicstore.service.ServicesService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired private ProductService ps;
	@Autowired private InstrumentService is;
	@Autowired private ServicesService ss;
	@Autowired private AccessoryService as; 
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping()
	public String showCart() {
		return "cartView";
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
	public String addToCart (@RequestParam Long id, @RequestParam List<String> table, @RequestParam String view,  Model model, HttpServletRequest req) throws ProductNotFoundException {
		
		//add Product to the cart by update session object
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
		cart.add(ps.getProductById(id));
		req.getSession().setAttribute("cart", cart);

		
		if(view.equals("serviceResults")) {
			List<Services> serviceResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				if(i % 4 == 0) {
					serviceResults.add(ss.findServiceById(Long.parseLong(table.get(i).split("=")[1])));
				}	
			}
			model.addAttribute("serviceResults", serviceResults);
		} else if(view.equals("accessoryResults")) {
			List<Accessory> accessoryResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				accessoryResults.add(as.findAccessoryById(Long.parseLong(table.get(i).split("=")[1])));
			}
			model.addAttribute("accesoryResults", accessoryResults);
		}  else if(view.equals("")) {
			
		}  else if(view.equals("instrumentResults")) {
			List<Instrument> instrumentResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				if(i % 4 == 0) {
					instrumentResults.add(is.getInstrumentById(Long.parseLong(table.get(i).split("=")[1])));
				}		
			}
			model.addAttribute("instrumentResults", instrumentResults);
		} else view = "theres a problem";
		logger.info("@@@@@@@@@@@@@@@CART: " + req.getSession().getAttribute("cart"));
		return view;
	}
	
	
}
