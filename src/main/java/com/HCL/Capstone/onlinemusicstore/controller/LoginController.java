package com.HCL.Capstone.onlinemusicstore.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping()
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest req) {

		String result = "";
		if (error != null) result = "<SPAN style='color:#F62020'>Invalid Login</SPAN>";

		else if (logout != null) {
			req.getSession().setAttribute("cart", new ArrayList<>());
			result = "<SPAN style='color:#50F227'>Logout Successful</SPAN>";
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("login");
		return mv;
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){  
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout=true";
	}	
}
