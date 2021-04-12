package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.entity.User;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.AccessoryService;
import com.HCL.Capstone.onlinemusicstore.service.InstrumentService;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;
import com.HCL.Capstone.onlinemusicstore.service.ServicesService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired private ProductService ps;
	@Autowired private InstrumentService is;
	@Autowired private ServicesService ss;
	@Autowired private AccessoryService as; 
	@Autowired private MusicService ms; 
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping()
	public String showCart(HttpServletRequest req, Model model) {
		
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
		logger.info("showing cart view with cart: " + cart);
		model.addAttribute("cart", cart);

		if(cart.size() > 0) {
			double total = cart.stream().map(p -> p.getPrice()).reduce(0.0, (p1, p2) -> p1 + p2);
			total = Math.round(total * 100.0) / 100.0;
			model.addAttribute("total", total);
		}
		
		return "cartView";
	}
	
	@PostMapping("/deleteItem")
	public String deleteItemFromCart(Model model, @RequestParam Long productId, HttpServletRequest req) throws ProductNotFoundException {
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getId() == productId) {
				cart.remove(i);
				break;
			}
		}
		if(cart.size() > 0) {
			double total = cart.stream().map(p -> p.getPrice()).reduce(0.0, (p1, p2) -> p1 + p2);
			total = Math.round(total * 100.0) / 100.0;
			model.addAttribute("total", total);
		}
		req.getSession().setAttribute("cart", cart);
		model.addAttribute("cart", cart);
		return "cartView";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model, @RequestParam Double total, HttpServletRequest req) {
		if(req.getSession().getAttribute("user") != null) {
			User user = (User)req.getSession().getAttribute("user");
			model.addAttribute("cardnumber", user.getCreditCard());
		}
		
		model.addAttribute("total", total);
		model.addAttribute("checkingOut", "true");	
		return "cartView";
	}
	
	@PostMapping("/checkout")
	public String submitCheckout(Model model, HttpServletRequest req) {
		model.addAttribute("result", "Checkout Successful");
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>)req.getSession().getAttribute("cart");
		//clear the cart when the user checks out
		cart.removeAll(cart);
		req.getSession().setAttribute("cart", cart);
		return "cartView";
	}

	@PostMapping("/add")
	public String addToCart (@RequestParam Long id, @RequestParam List<String> table, @RequestParam String view,  Model model, HttpServletRequest req) throws ProductNotFoundException {
		
		//add Product to the cart by update session object
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
		cart.add(ps.getProductById(id));
		req.getSession().setAttribute("cart", cart);

		
		if(view.equals("serviceResults")) {
			List<Services> serviceResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				if(i % 4 == 0) {
					serviceResults.add(ss.findServiceById(Long.parseLong(table.get(i).split("=")[1])));
				}	
			}
			model.addAttribute("serviceResults", serviceResults);
		} else if(view.equals("accessoryResults")) {
			List<Accessory> accessoryResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				if(i % 4 == 0) {
					accessoryResults.add(as.findAccessoryById(Long.parseLong(table.get(i).split("=")[1])));
				}		
			}
			model.addAttribute("accessoryResults", accessoryResults);
		}  else if(view.equals("instrumentResults")) {
			List<Instrument> instrumentResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				if(i % 4 == 0) {
					instrumentResults.add(is.getInstrumentById(Long.parseLong(table.get(i).split("=")[1])));
				}		
			}
			model.addAttribute("instrumentResults", instrumentResults);
		} 
		else if(view.equals("music")) {
			List<Music> musicResults = new ArrayList<>();
			for(int i = 0; i < table.size(); i++) {
				if(i % 4 == 0) 
				{
					try {
						musicResults.add(ms.getMusicById(Long.parseLong(table.get(i).split("=")[1])));
					} catch (NumberFormatException | MusicNotFoundException e) 
					{
						e.printStackTrace();
					}
				}		
			}
			model.addAttribute("searchResults", musicResults);
		}else view = "theres a problem";
		logger.info("@@@@@@@@@@@@@@@CART: " + req.getSession().getAttribute("cart"));
		return view;
	}
	
	
}
