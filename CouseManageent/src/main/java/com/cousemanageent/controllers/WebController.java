package com.cousemanageent.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cousemanageent.entity.Course;
import com.cousemanageent.service.CourseService;

@Controller
public class WebController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CourseService courseService;

	@ModelAttribute
	public void addAttriburesForHome(Model model, HttpSession session) {
		 model.addAttribute("message", "Welcome to Course Management");
		 model.addAttribute("courseStatus", Arrays.asList("Active","Not Active"));
		 session.setAttribute("courseList", courseService.getAllCourse());
	}
	

	@GetMapping("/")
	public String entryPoint() {
		return "Home";
	}
	
	
	
	@GetMapping("/addCourse")
	public String showCourseForm(Course course) {
		return "form";
	}
	
	@PostMapping("/addCourse")
	public String saveCourse(@Valid Course course, BindingResult bindingResult, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "form";
		}
		
		courseService.saveCourse(course);
		session.setAttribute("courseList", courseService.getAllCourse());

		return "redirect:/";
	}
	
	
}
