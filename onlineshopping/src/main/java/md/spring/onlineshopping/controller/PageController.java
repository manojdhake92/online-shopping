package md.spring.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
		
    @RequestMapping(value= {"/",   "/home" ,   "/index"  })
    public ModelAndView index()  {
    	System.out.println("Inside Page Controller");
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("greeting", "Welcome To Spring MVC Tutorial");
    	System.out.println(mv.getModel());
    	return mv;
    }
    

}
