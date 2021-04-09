package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.*;



@Controller
public class ServicesController {
	@Autowired
	private ServicesService servicesService;
	
	@RequestMapping(value = "/DeleteServices", method = RequestMethod.POST)
	public String deleteServices(ModelMap model,@RequestParam String name) throws ProductNotFoundException{
		 
		Services services = servicesService.GetServiceByName(name);
		servicesService.DeleteServices(services);
		return "taskresult";

	}
	
	
	@RequestMapping(value = "/UpdateServices", method = RequestMethod.POST)
	public String updateServices(ModelMap model, @RequestParam String name, 
			 @RequestParam String description,@RequestParam Double price) throws ProductNotFoundException{
		
		Services object = servicesService.GetServiceByName(name);
		object = new Services(name, Category.SERVICE, price, description);
		servicesService.UpdateServices(object);
		return "taskresult";
		
		
	}
	
	
	@RequestMapping(value = "/AddServices", method = RequestMethod.POST)
	public String addServices(ModelMap model, @RequestParam String name, 
			 @RequestParam String description,@RequestParam Double price) {
		
		Services object = new Services(name, Category.SERVICE, price, description);
		servicesService.UpdateServices(object);
		return "taskresult";
	}
	
	@RequestMapping(value = "/SearchServices", method = RequestMethod.POST)
	public String searchServices(ModelMap model, @RequestParam String search)throws ProductNotFoundException {
		
		List <Services> results = new ArrayList<Services>();
		
		results = servicesService.findAllByNameContainsIgnoreCase(search);
		model.addAttribute("searchResults", results);
		return "searchResults";
	}
	
	@RequestMapping(value = "/ViewServices", method = RequestMethod.GET)
	public String viewServices(ModelMap model) {
		
		Iterable<Services> list = new ArrayList<>();
		list = servicesService.GetAllServices();
		model.addAttribute("searchResults", list);
		return "adminAction";
	}
}
