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
public class accountController {
	
	@Autowired private MusicService ms;
	
	@Autowired private ProductService ps;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/account")
	public String accountPage(Model model) {
		return "account";
	}
	

}
