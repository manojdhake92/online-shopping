package md.spring.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.Assert;
import md.spring.shoppingbackend.dao.ProductDAO;
import md.spring.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext appContext;
	private static ProductDAO productDao;

	@BeforeClass
	public static void init() {
		appContext = new AnnotationConfigApplicationContext();
		appContext.scan("md.spring.shoppingbackend");
		appContext.refresh();
		productDao = (ProductDAO) appContext.getBean("productDao");
	}

	/*@Test
	public void testCRUDProduct() {
		Product prod = new Product();

		prod.setName("Oppo s2 Mobile");
		prod.setBrand("OPPo");
		prod.setActive(true);
		prod.setDescription("This is some Oppo description");
		prod.setUnitPrice(23000);
		prod.setQuantity(3);
		prod.setCategoryId(3);
		prod.setSupplierId(3);

		Assert.assertEquals("The product added succesfully", true, productDao.addProduct(prod));

		// Update the category
		prod = productDao.get(2);
		prod.setName("Samsung s7");
		Assert.assertEquals("The product Updated succesfully", true, productDao.updateProduct(prod));

		// Delete Caltegory
		Product prodToDelete = productDao.get(6);
		Assert.assertEquals("The product deleted succesfully", true, productDao.deleteProduct(prodToDelete));

		// Fetch list of category
		Assert.assertEquals("The products fetched succesfully", 6, productDao.getProductList().size());
	}*/
	
	@Test
	public void getAllActiveProducts(){
		Assert.assertEquals("The all active products has been fetched succesfully", 4, productDao.getAllActiveProducts().size());
	}
	
	@Test
	public void getAllActiveProductsByCategory(){
		Assert.assertEquals("The all active products by category fetched succesfully", 2, productDao.getAllActiveProductsByCategory(3).size());
	}
	
	@Test
	public void getAllActiveLatestProducts(){
		Assert.assertEquals("The all active latest products has been  fetched succesfully", 3, productDao.getAllActiveLatestProducts(3).size());
	}

}
