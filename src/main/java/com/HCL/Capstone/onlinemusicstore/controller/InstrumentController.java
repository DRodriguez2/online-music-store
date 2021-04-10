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
public class InstrumentController {
	@Autowired
	private InstrumentService instrumentService;
	
	@RequestMapping(value = "/DeleteInstrument", method = RequestMethod.POST)
	public String deleteInstrument(ModelMap model,@RequestParam String name)throws ProductNotFoundException {
		 
		Instrument instrument = instrumentService.GetInstrumentByName(name);
		instrumentService.DeleteInstrument(instrument);
		return "taskresult";

	}
	
	
	@RequestMapping(value = "/UpdateInstrument", method = RequestMethod.POST)
	public String updateInstrument(ModelMap model, @RequestParam String name, 
			 @RequestParam String type, @RequestParam String brand,@RequestParam Double price) throws ProductNotFoundException{
		
		Instrument object = instrumentService.GetInstrumentByName(name);
		object = new Instrument(name, Category.INSTRUMENT, price, type, brand);
		instrumentService.UpdateInstrument(object);
		return "taskresult";
		
		
	}
	
	
	
	@RequestMapping(value = "/AddInstrument", method = RequestMethod.POST)
	public String addInstrument(ModelMap model, @RequestParam String name, @RequestParam String type,
			@RequestParam String brand, @RequestParam Double price) {
		
										//String name, Category category, Double price, String type, String brand
		Instrument object = new Instrument(name, Category.INSTRUMENT, price, type, brand);
		instrumentService.UpdateInstrument(object);
		return "taskresult";
	}
	
	
	@RequestMapping(value = "/SearchInstrument", method = RequestMethod.POST)
	public String searchInstrument(ModelMap model, @RequestParam String search)throws ProductNotFoundException {
		
		List <Instrument> results = new ArrayList<Instrument>();
		List <Instrument> nameResults = new ArrayList<Instrument>();
		List <Instrument> brandResults = new ArrayList<Instrument>();

		
		nameResults = instrumentService.findAllByNameContainsIgnoreCase(search);
		brandResults = instrumentService.findAllByBrandContainsIgnoreCase(search);
		for(Instrument i : nameResults) {
			results.add(i);
		}
		for(Instrument i : brandResults) {
			results.add(i);
		}
		model.addAttribute("instrumentResults", results);
		return "instrumentResults";
	}
	
	
	@RequestMapping(value = "/ViewInstrument", method = RequestMethod.GET)
	public String viewInstrument(ModelMap model) {
		
		Iterable<Instrument> list = new ArrayList<>();
		list = instrumentService.GetAllInstruments();
		model.addAttribute("instrumentResults", list);
		return "instrumentResults";
	}
}
