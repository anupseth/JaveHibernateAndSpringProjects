package anup.Spmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/mvc")
public class ExceptionController {
	
	@RequestMapping("/does-not-work")
	public String idDoesNotWork() {
		throw new IllegalStateException("not it does not");
	}
	
	@RequestMapping("/does-not-work-in-general")
	public String idDoesNotWorkInGeneral() {
		throw new RuntimeException("not it does not runtime");
	}
	
	@RequestMapping("/null-pointer")
	public String nullPointerException() {
		throw new NullPointerException(": This is null pointer exception :");
	}

}
