package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;


@Controller
public class adminController {
	
	@Autowired private MusicService ms;
	
	@Autowired private ProductService ps;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/admin")
	public String adminPage(Model model) {
		List <Product> results = ps.getAllProducts();
		model.addAttribute("searchResults", results);
		return "admin";
	}
	
	@RequestMapping("/admin/task")
	public String adminTask(@RequestParam String category, @RequestParam Long productId,  Model model) throws MusicNotFoundException {
		switch(category) {
		case "MUSIC":
			model.addAttribute("music", ms.getMusicById(productId));
			return "adminMusicTask";
		case "ACCESSORIES":
			return "adminAccessoryTask";
		case "INSTRUMENT": 
			return "adminInstrumentTask";
		case "SERVICE":
			return "adminInstrumentTask";
		default:
			return "error";
		}
	}
	
	@PostMapping("/admin/delete")
	public String adminPage(Model model, @RequestParam Long productId) throws MusicNotFoundException {
		Music music = ms.getMusicById(productId);
		ms.deleteMusic(music);
		List <Product> results = ps.getAllProducts();
		model.addAttribute("searchResults", results);

		logger.info("deleting product with id: " + productId);
		return "admin";
	}
	
	@RequestMapping(value = "/AdminTask", method = RequestMethod.POST)
	public String selectTask(ModelMap model,@RequestParam String entity,@RequestParam String action) {
		
//'entity' and 'action' can be a drop down menu selections in the Admin View page 
		switch(entity) {
		case "Music":
			switch(action) {
			case "add":
				return "addMusic";
			case "update":
				return "updateMusic";
			case "delete":
				return "deleteMusic";
			default:
				System.out.println("no match");
			}
			break;
		case "Album":
			switch(action) {
			case "add":
				return "addAlbum";
			case "update":
				return "updateAlbum";
			case "delete":
				return "deleteAlbum";
			default:
				System.out.println("no match");
		}
			break;
		case "Instrument":
			switch(action) {
			case "add":
				return "addInstrument";
			case "update":
				return "updateInstrument";
			case "delete":
				return "deleteInstrument";
			default:
				System.out.println("no match");
		}
			break;
		case "Services":
			switch(action) {
			case "add":
				return "addServices";
			case "update":
				return "updateServices";
			case "delete":
				return "deleteServices";
			default:
				System.out.println("no match");
		}
			break;
		case "Accessory":
			switch(action) {
			case "add":
				return "addAccessory";
			case "update":
				return "updateAccessory";
			case "delete":
				return "deleteAccessory";
			default:
				System.out.println("no match");
		}
			break;
		default:
			return "error";
		}
		return "error";
		
	}
}
