package anup.Spmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ConcreteExceptionHandeler {

	
	@ExceptionHandler(IllegalStateException.class)
	@ResponseBody
	//@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String handleillegalStateExcept(HttpServletRequest request, Exception excep) {
		
		return "Error occured : "+excep.getMessage() + "  request details "+request.getRequestURL().toString();
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleNullPointerException(Exception excep) {
		
		ModelAndView modelAndView = new ModelAndView("common-exceptions");
		modelAndView.addObject("requestId", excep.getMessage());
		return modelAndView;
		
	}
	

}
