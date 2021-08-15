package com.cousemanageent.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cousemanageent.entity.Course;
import com.cousemanageent.entity.CourseStatus;
import com.cousemanageent.service.CourseService;

@Controller
public class WebController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CourseService courseService;

	@ModelAttribute
	public void addAttriburesForHome(Model model, HttpSession session) {
		model.addAttribute("message", "Welcome to Course Management");
		model.addAttribute("courseStatus", Arrays.asList(CourseStatus.ACTIVE, CourseStatus.NOT_ACTIVE));
		session.setAttribute("courseList", courseService.getAllCourse());
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, false));
	}

	@GetMapping("/")
	public String entryPoint() {
		return "Home";
	}

	@GetMapping("/addCourse")
	public String showCourseForm(Course course) {
		course.setFees(2000);
		course.setDuration(3);
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

	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable long id, HttpSession session) {

		courseService.deleteCourse(id);
		session.setAttribute("courseList", courseService.getAllCourse());
		
		return "redirect:/";
	}
	
	@GetMapping("/updateCourse/{id}")
	public ModelAndView showUpdateCourseForm(@PathVariable long id, ModelAndView model) {
		Course retreiveCourse = courseService.retreiveCourse(id);
		model.addObject("course", retreiveCourse);
		model.setViewName("form");
		return model;
	}

}
