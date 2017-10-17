package md.spring.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import md.spring.onlineshopping.controller.exception.NoProductFoundException;
import md.spring.shoppingbackend.dao.CategoryDAO;
import md.spring.shoppingbackend.dao.ProductDAO;
import md.spring.shoppingbackend.dto.Category;
import md.spring.shoppingbackend.dto.Product;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private ProductDAO productDao;

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		logger.info("Inside Page Controller");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("ClickedHomeBtn", true);
		mv.addObject("catList", categoryDao.getCategoryList());
	
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		logger.info("Inside Page Controller-About us");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("ClickedAboutBtn", true);
	
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		logger.info("Inside Page Controller-Contact Us");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("ClickedContactBtn", true);
	
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		logger.info("Inside Page Controller-AllProducts");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "AllProducts");
		mv.addObject("ClickedAllProductsBtn", true);
		mv.addObject("catList", categoryDao.getCategoryList());
		
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		logger.info("Inside Page Controller-CategoryProducts");
		// Fetch only one category products
		Category category = categoryDao.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());

		mv.addObject("ClickedCategoryProductsBtn", true);
		// Passing single category
		mv.addObject("category", category);
		// Passing single categories
		mv.addObject("catList", categoryDao.getCategoryList());

		return mv;
	}

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws NoProductFoundException {
		Product product = productDao.get(id);
		ModelAndView mv = new ModelAndView("page");

		//throw custom exception if product not found.
		
		if(product == null)
			throw new NoProductFoundException();
		// Update Views count
		product.setViews(product.getViews() + 1);
		productDao.updateProduct(product);

		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("ClickedShowProductBtn", true);

		return mv;
	}
}
