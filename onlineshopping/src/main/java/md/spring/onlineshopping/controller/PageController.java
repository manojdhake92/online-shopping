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
    	mv.addObject("title", "Home");  
    	mv.addObject("ClickedHomeBtn", true); 
    	System.out.println(mv.getModel());
    	return mv;
    }
    
    @RequestMapping(value="/about")
    public ModelAndView about()  {
    	System.out.println("Inside Page Controller-About us");
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("title", "About Us");  
    	mv.addObject("ClickedAboutBtn", true); 
    	System.out.println(mv.getModel());
    	return mv;
    }
    @RequestMapping(value="/contact")
    public ModelAndView contact()  {
    	System.out.println("Inside Page Controller-Contact Us");
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("title", "Contact Us");  
    	mv.addObject("ClickedContactBtn", true); 
    	System.out.println(mv.getModel());
    	return mv;
    }

}
