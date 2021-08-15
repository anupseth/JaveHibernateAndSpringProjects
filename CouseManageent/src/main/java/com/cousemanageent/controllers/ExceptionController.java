package com.cousemanageent.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Model model, HttpServletRequest request, Exception ex) {
		
		logger.error("Request :" + request.getRequestURL() + "   Threw an exception : ", ex);
		
		model.addAttribute("errorMessage", ex.getMessage());
		
		return "error";
		
	}
}
