package com.cousemanageent.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cousemanageent.entity.Course;
import com.cousemanageent.service.CourseService;


@Controller
public class SearchController implements WebMvcConfigurer {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("SearchPages/SearchByName");
		registry.addViewController("/resultsByDate").setViewName("SearchPages/SearchByDate");
		registry.addViewController("/resultsByFees").setViewName("SearchPages/SearchByFees");
		registry.addViewController("/resultsByDuration").setViewName("SearchPages/SearchByDuration");
	}

	@Autowired
	private CourseService courseService;

//	@ModelAttribute
//	public void addAttriburesForHome(Model model, HttpSession session) {
//		model.addAttribute("message", "Welcome to Course Management");
//		model.addAttribute("courseStatus", Arrays.asList(CourseStatus.ACTIVE, CourseStatus.NOT_ACTIVE));
//		session.setAttribute("courseList", courseService.getAllCourse());
//	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, false));
	}

	@GetMapping("/searchByName")
	public String searchByName() {
		return "SearchPages/SearchByName";
	}

	
	@PostMapping("/searchByName")
	public String searchByNamePost(HttpServletRequest reuest, HttpSession session) {
		
		String name = reuest.getParameter("name");
		
		session.setAttribute("searchByNameList", courseService.getByName(name));
		
		
		return "redirect:/results";
	}
	
	
	@GetMapping("/searchByDateRange")
	public String searchByDate() {
		return "SearchPages/SearchByDate";
	}

	
	@PostMapping("/searchByDateRange")
	public String searchByDatePost(HttpServletRequest reuest, HttpSession session) {
		
		session.setAttribute("errMsgDates", "");
		String fromDate = reuest.getParameter("fromDate");
		String toDate = reuest.getParameter("toDate");
		
		Date datefrom = null;
		Date dateTo = null;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			
			datefrom = simpleDateFormat.parse(fromDate);
			dateTo = simpleDateFormat.parse(toDate);
			
		}catch(Exception ex) {
			
			session.setAttribute("errMsgDates", "Please enter date in this format (yyyy-MM-dd)");
			return "SearchByDate";
		}
		
		List<Course> byDate = courseService.getByDate(datefrom, dateTo);
		
		session.setAttribute("searchByDateList", byDate);
		
		return "redirect:/resultsByDate";
	}
	
	
	@GetMapping("/searchByFeesRange")
	public String searchByFees() {
		return "SearchPages/SearchByFees";
	}

	
	@PostMapping("/searchByFeesRange")
	public String searchByFeesPost(HttpServletRequest reuest, HttpSession session) {
		
		List<Course> byFees = null;
		session.setAttribute("errMsgFees", "");
		String fromFees = reuest.getParameter("fromFees");
		String toFees = reuest.getParameter("toFees");
		
		try {
			
			byFees =  courseService.getByFees(Integer.parseInt(fromFees), Integer.parseInt(toFees));
			
		}catch(Exception ex) {
			
			session.setAttribute("errMsgFees", "Please enter Fees as Number");
			return "SearchByFees";
		}
		
		session.setAttribute("searchByFeesList", byFees);
		
		return "redirect:/resultsByFees";
	}
	
	
	@GetMapping("/searchByDurationRange")
	public String searchByDuration() {
		return "SearchPages/SearchByDuration";
	}

	
	@PostMapping("/searchByDurationRange")
	public String searchByDurationPost(HttpServletRequest reuest, HttpSession session) {
		
		List<Course> byDuration = null;
		session.setAttribute("errMsgDuration", "");
		String fromDuration = reuest.getParameter("fromDuration");
		String toDuration = reuest.getParameter("toDuration");
		
		try {
			
			byDuration =  courseService.getByDuration(Integer.parseInt(fromDuration), Integer.parseInt(toDuration));
			
		}catch(Exception ex) {
			
			session.setAttribute("errMsgDuration", "Please enter Duration as Number");
			return "SearchByDuration";
		}
		
		session.setAttribute("searchByDurationList", byDuration);
		
		return "redirect:/resultsByDuration";
	}


}
