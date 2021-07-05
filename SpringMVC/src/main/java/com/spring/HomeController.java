package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String helloWorld() {
		System.out.println("Inside Home .......");
		return "home";
	}
	
	@RequestMapping(value = "sayName", method = RequestMethod.POST)
	public String readName(@RequestParam("fname") String firstName, ModelMap map ) {
		map.addAttribute("firstname", firstName);
		return "profile";
	}
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String isValidUser(@RequestParam("username") String username, 
			@RequestParam("password") String password,ModelMap map ) {
		String page="home";
		
		if(username.equalsIgnoreCase("tom") && password.equalsIgnoreCase("jerry")) {
			map.addAttribute("firstname", username);
			page = "profile";
		}else {
			map.addAttribute("errorMessage", "Invalid Creds ......");
		}
		
		return page;
	}

}
