package com.HCL.Capstone.onlinemusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class adminController {
	
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
