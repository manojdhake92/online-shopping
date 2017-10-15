package md.spring.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import md.spring.shoppingbackend.dao.ProductDAO;
import md.spring.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private ProductDAO productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody   //This annotation automatically convert data to json
	public List<Product> getAllProducts(){
			return productDao.getAllActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody   //This annotation automatically convert data to json
	public List<Product> getAllProducts(@PathVariable int id){
			return productDao.getAllActiveProductsByCategory(id);
	}
	
	
}
