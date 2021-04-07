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
public class AccessoryController {

	@Autowired
	private AccessoryService accessoryService;
	
	@RequestMapping(value = "/DeleteAccessory", method = RequestMethod.POST)
	public String deleteAccessory(ModelMap model,@RequestParam String type,@RequestParam String name) {
		 
		Accessory accessory = accessoryService.GetAccessoryByName(name);
		accessoryService.DeleteAccessory(accessory);
		return "taskresult";

	}
	
	
	@RequestMapping(value = "/UpdateAccessory", method = RequestMethod.POST)
	public String updateAccessory(ModelMap model, @RequestParam Category category, @RequestParam String name, 
			 @RequestParam String description, @RequestParam String brand,@RequestParam Double price) {
		
		Accessory object = accessoryService.GetAccessoryByName(name);
		object = new Accessory(name, category, price, brand, description);
		accessoryService.UpdateAccessory(object);
		return "taskresult";
		
		
	}
	
	
	
	@RequestMapping(value = "/AddAccessory", method = RequestMethod.POST)
	public String addAccessory(ModelMap model, @RequestParam Category category, @RequestParam String name, 
			 @RequestParam String description, @RequestParam String brand,@RequestParam Double price) {
		
		Accessory object = new Accessory(name, category, price, brand, description);
		accessoryService.UpdateAccessory(object);
		return "taskresult";
	}
	
	@RequestMapping(value = "/ViewAccessory", method = RequestMethod.GET)
	public String viewAccessory(ModelMap model) {
		
		Iterable<Accessory> list = new ArrayList<>();
		list = accessoryService.GetAllAccessories();
		model.addAttribute("searchResults", list);
		return "searchResults";
	}
}