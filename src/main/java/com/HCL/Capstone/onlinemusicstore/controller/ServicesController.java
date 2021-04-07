package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.service.*;



@Controller
public class ServicesController {
	@Autowired
	private ServicesService servicesService;
	
	@RequestMapping(value = "/DeleteServices", method = RequestMethod.POST)
	public String deleteServices(ModelMap model,@RequestParam String type,@RequestParam String name) {
		 
		Services services = servicesService.GetServiceByName(name);
		servicesService.DeleteServices(services);
		return "taskresult";

	}
	
	
	@RequestMapping(value = "/UpdateServices", method = RequestMethod.POST)
	public String updateServices(ModelMap model, @RequestParam Category category, @RequestParam String name, 
			 @RequestParam String description,@RequestParam Double price) {
		
		Services object = servicesService.GetServiceByName(name);
		object = new Services(name, category, price, description);
		servicesService.UpdateServices(object);
		return "taskresult";
		
		
	}
	
	
	@RequestMapping(value = "/AddServices", method = RequestMethod.POST)
	public String addServices(ModelMap model, @RequestParam Category category, @RequestParam String name, 
			 @RequestParam String description,@RequestParam Double price) {
		
		Services object = new Services(name, category, price, description);
		servicesService.UpdateServices(object);
		return "taskresult";
	}
	
	
	@RequestMapping(value = "/ViewServices", method = RequestMethod.GET)
	public String viewServices(ModelMap model) {
		
		Iterable<Services> list = new ArrayList<>();
		list = servicesService.GetAllServices();
		model.addAttribute("searchResults", list);
		return "searchResults";
	}
}
