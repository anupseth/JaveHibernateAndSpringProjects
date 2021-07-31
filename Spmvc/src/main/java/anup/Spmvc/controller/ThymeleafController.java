package anup.Spmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class ThymeleafController {
	
	@RequestMapping("/view")
	public String whatIsCool() {
		return "thymeleaf-is-cool.html";
	}
	
	@RequestMapping("/model")
	public String whatCanWePassToView(Model model) {
		model.addAttribute("attributeKey", "Anything We want to passs");
		return "thymeleaf-is-cool.html";
	}
	
}
