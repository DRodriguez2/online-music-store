package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;

@Controller
public class searchController {

	@Autowired

	private ProductService ps;
	
	@RequestMapping(value = "/Search", method = RequestMethod.POST)
	public String searchInventory(ModelMap model,@RequestParam String search) throws ProductNotFoundException {

		
		List <Product> results = new ArrayList<Product>(); 

		results = ps.getAllByNameContains(search);
		model.addAttribute("searchResults", results);
		
		return "searchResults";
	}
	
	
	@RequestMapping(value = "/AdvSearch", method = RequestMethod.POST)
	public String advanceSearchInventory(ModelMap model,@RequestParam String type,@RequestParam String search,
			@RequestParam Double priceLow, @RequestParam Double priceHigh) throws ProductNotFoundException {

		List <Product> results = new ArrayList<Product>();
		results = ps.getAllByNameContains(search);	
		for(Product i: results) {
			if(i.getPrice() < priceLow || i.getPrice() > priceHigh) {
				results.remove(i);
			}
		}

		model.addAttribute("searchResults", results);
	
		return "searchResults";
	}
}
