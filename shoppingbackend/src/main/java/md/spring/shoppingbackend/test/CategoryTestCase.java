package md.spring.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.Assert;
import md.spring.shoppingbackend.dao.CategoryDAO;
import md.spring.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDao;
	private Category category;
	
	
	@BeforeClass
	public  static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("md.spring.shoppingbackend");
		context.refresh();
		categoryDao = (CategoryDAO)context.getBean("categoryDao");
		
	}
	
	@Test
	public void testCRUDCategory(){
		category= new Category();
		category.setDescription("This is some television descrption");
		category.setImageURL("CAT_1.jpg");
		category.setName("Television");
		category.setActive(true);
		
		Assert.assertEquals("The category added succesfully", true, categoryDao.addCategory(category));
		
		category= new Category();
		category.setDescription("This is some Mobile descrption");
		category.setImageURL("CAT_2.jpg");
		category.setName("Mobile");
		category.setActive(true);
		
		Assert.assertEquals("The category added succesfully", true, categoryDao.addCategory(category));
		
		
		category= new Category();
		category.setDescription("This is some Laptop descrption");
		category.setImageURL("CAT_3.jpg");
		category.setName("Laptop");
		category.setActive(true);
		
		Assert.assertEquals("The category added succesfully", true, categoryDao.addCategory(category));
		/*
		//Update the category
		Category cat = categoryDao.get(2);
		cat.setName("Laptop");
		Assert.assertEquals("The category Updated succesfully", true, categoryDao.updateCategory(cat));
		
		//Delete Caltegory
		Category catToDelete = categoryDao.get(2);	
		Assert.assertEquals("The category Deleted succesfully", true, categoryDao.deleteCategory(catToDelete));
		
		//Fetch list of category
		Assert.assertEquals("The category List fetched succesfully", 1, categoryDao.getCategoryList().size());
*/	}

}
