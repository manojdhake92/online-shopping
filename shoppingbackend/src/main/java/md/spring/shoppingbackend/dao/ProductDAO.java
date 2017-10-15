package md.spring.shoppingbackend.dao;

import java.util.List;
import md.spring.shoppingbackend.dto.Product;
public interface ProductDAO {
	
	boolean addProduct(Product product);
	List<Product> getProductList();
	Product get(int id);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	//More business Method's
	List<Product> getAllActiveProducts();
	List<Product> getAllActiveProductsByCategory(int categoryId);
	List<Product> getAllActiveLatestProducts(int count);
	

}
