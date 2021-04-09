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
import com.HCL.Capstone.onlinemusicstore.exceptions.AccessoryNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.*;



@Controller
public class AccessoryController {

	@Autowired
	private AccessoryService accessoryService;
	
	@RequestMapping(value = "/DeleteAccessory", method = RequestMethod.POST)
	public String deleteAccessory(ModelMap model,@RequestParam String name) throws ProductNotFoundException{
		 
			Accessory accessory = accessoryService.GetAccessoryByName(name);
			accessoryService.DeleteAccessory(accessory);
			return "taskresult";
		
	}
	
	
	@RequestMapping(value = "/UpdateAccessory", method = RequestMethod.POST)
	public String updateAccessory(ModelMap model, @RequestParam String name, 
			 @RequestParam String description, @RequestParam String brand,@RequestParam Double price) throws ProductNotFoundException{
		
			Accessory object = accessoryService.GetAccessoryByName(name);
			object = new Accessory(name, Category.ACCESSORIES, price, brand, description);
			accessoryService.UpdateAccessory(object);
			return "taskresult";
	}
	
	
	
	@RequestMapping(value = "/AddAccessory", method = RequestMethod.POST)
	public String addAccessory(ModelMap model, @RequestParam String name, 
			 @RequestParam String description, @RequestParam String brand,@RequestParam Double price) {
		
		Accessory object = new Accessory(name, Category.ACCESSORIES, price, brand, description);
		accessoryService.UpdateAccessory(object);
		return "taskresult";
	}
	
	@RequestMapping(value = "/SearchAccessory", method = RequestMethod.POST)
	public String searchInstrument(ModelMap model, @RequestParam String search)throws ProductNotFoundException {
		
		List <Accessory> results = new ArrayList<Accessory>();
		List <Accessory> nameResults = new ArrayList<Accessory>();
		List <Accessory> brandResults = new ArrayList<Accessory>();

		
		nameResults = accessoryService.findAllByNameContainsIgnoreCase(search);
		brandResults = accessoryService.findAllByBrandContainsIgnoreCase(search);
		for(Accessory i : nameResults) {
			results.add(i);
		}
		for(Accessory i : brandResults) {
			results.add(i);
		}
		model.addAttribute("searchResults", results);
		return "searchResults";
	}
	
	@RequestMapping(value = "/ViewAccessory", method = RequestMethod.GET)
	public String viewAccessory(ModelMap model) {
		
		Iterable<Accessory> list = new ArrayList<>();
		list = accessoryService.GetAllAccessories();
		model.addAttribute("searchResults", list);
		return "searchResults";
	}
}
