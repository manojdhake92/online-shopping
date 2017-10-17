package md.spring.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import md.spring.shoppingbackend.dao.CategoryDAO;
import md.spring.shoppingbackend.dao.ProductDAO;
import md.spring.shoppingbackend.dto.Category;
import md.spring.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/manage")
public class MangeProductsController {

	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private ProductDAO productDAO;
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(required = false) String operation){
		logger.info("Inside Manage Products Controller");
		ModelAndView mv = new ModelAndView("page");
		
		//Create dummy product with some default objects
		
		if(operation != null){
			if(operation.equals("product")){
				mv.addObject("message", "The Product Added Succesfully!");
			}
		}
		Product nproduct = new Product();
		nproduct.setActive(true);
		nproduct.setSupplierId(1);
		
		mv.addObject("product", nproduct);
		mv.addObject("title", "Manage Product");
		mv.addObject("ClickedManageProductBtn", true);
		return mv;
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getlistOfCategories(){
		logger.info("inside get list category...........");
		System.out.println(categoryDao.getCategoryList().get(0));
		return categoryDao.getCategoryList();
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String storageProductToDB(@ModelAttribute @Valid Product mproduct, BindingResult results , Model model){
		logger.info("Inside Stoage Product Controller");
		
		if(results.hasErrors()){
			model.addAttribute("title", "Manage Product");
			model.addAttribute("ClickedManageProductBtn", true);
			return "page";
			
		}
		
		productDAO.addProduct(mproduct);
		return "redirect:/manage/products?operation=product";
	}
	
}
