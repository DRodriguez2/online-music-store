package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.AccessoryService;



@Controller
public class AccessoryController {

	@Autowired
	private AccessoryService accessoryService;
	
	@RequestMapping("/accessory")
	public String adminPage(Model model) {
		return "accessory";
	}
	
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
		Map<Long, Accessory> a1 = new HashMap<>();
		for(int i = 0; i < nameResults.size(); i++) {
			a1.put(nameResults.get(i).getId(), nameResults.get(i));
			results.add(nameResults.get(i));
		}
		
		for(int i = 0; i < brandResults.size(); i++) {
			if(a1.get(brandResults.get(i).getId()) == null) {
				results.add(brandResults.get(i));
			}
		}
		model.addAttribute("accessoryResults", results);
		return "accessoryResults";
	}
	
	@RequestMapping(value = "/ViewAccessory", method = RequestMethod.GET)
	public String viewAccessory(ModelMap model) {
		
		Iterable<Accessory> list = new ArrayList<>();
		list = accessoryService.GetAllAccessories();
		model.addAttribute("accessoryResults", list);
		return "accessoryResults";
	}
}
