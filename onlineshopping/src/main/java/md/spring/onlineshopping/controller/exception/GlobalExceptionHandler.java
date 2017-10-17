package md.spring.onlineshopping.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException(){
		
		ModelAndView mv  = new ModelAndView("error");
		
		mv.addObject("title", "404 - Page Not Found");
		mv.addObject("errorTitle", "The Page is not Available");
		mv.addObject("errorDescription", "The Page you looking for is not available!");
		return mv;
		
	}
	
	@ExceptionHandler(NoProductFoundException.class)
	public ModelAndView handleNoProductFoundException(){
		
		ModelAndView mv  = new ModelAndView("error");
		
		mv.addObject("title", "Product Not Available!");
		mv.addObject("errorTitle", "This Product is not Available");
		mv.addObject("errorDescription", "The Product you looking for is not available currently in our Inventory!");
		return mv;
		
	}
	
	//Handler if product = "30ABD".
	@ExceptionHandler(Exception.class)
	public ModelAndView handleGeneralizeException(Exception e){
		
		ModelAndView mv  = new ModelAndView("error");
		
		mv.addObject("title", "Error!");
		mv.addObject("errorTitle", "Contact Your Administrator!");
		mv.addObject("errorDescription",e.getMessage().toString());
		return mv;
		
	}
}
