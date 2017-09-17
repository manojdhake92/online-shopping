package md.spring.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import md.spring.shoppingbackend.dao.CategoryDAO;
import md.spring.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		System.out.println("Inside Page Controller");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("ClickedHomeBtn", true);
		mv.addObject("catList", categoryDao.getCategoryList());
		System.out.println(mv.getModel());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		System.out.println("Inside Page Controller-About us");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("ClickedAboutBtn", true);
		System.out.println(mv.getModel());
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		System.out.println("Inside Page Controller-Contact Us");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("ClickedContactBtn", true);
		System.out.println(mv.getModel());
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		System.out.println("Inside Page Controller-AllProducts");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "AllProducts");
		mv.addObject("ClickedAllProductsBtn", true);
		mv.addObject("catList", categoryDao.getCategoryList());
		System.out.println(mv.getModel());
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		System.out.println("Inside Page Controller-CategoryProducts");
		//Fetch only one category products
		Category category = categoryDao.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		
		mv.addObject("ClickedCategoryProductsBtn", true);
		//Passing single category
		mv.addObject("category", category);
		//Passing single categories
		mv.addObject("catList", categoryDao.getCategoryList());
		System.out.println(mv.getModel());
		return mv;
	}
}
