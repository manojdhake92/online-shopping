package md.spring.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import md.spring.shoppingbackend.dao.CategoryDAO;
import md.spring.shoppingbackend.dto.Category;

@Repository("categoryDao")  //This annotation allows to get data access.
public class CategoryDAOImpl   implements CategoryDAO{

	
	private  static List<Category> categoryList= new ArrayList<Category>();
	static{
		Category cat1= new Category();
		cat1.setId(1);
		cat1.setDescription("This is some television descrption");
		cat1.setImageURL("CAT_1.jpg");
		cat1.setName("Television");
		cat1.setActive(true);
		categoryList.add(cat1);
		
		Category cat2= new Category();
		cat2.setId(2);
		cat2.setDescription("This is some Laptop descrption");
		cat2.setImageURL("CAT_2.jpg");
		cat2.setName("Laptop");
		cat2.setActive(true);
		categoryList.add(cat2);
		
		Category cat3= new Category();
		cat3.setId(3);
		cat3.setDescription("This is some Mobile descrption");
		cat3.setImageURL("CAT_3.jpg");
		cat3.setName("Mobile");
		cat3.setActive(true);
		categoryList.add(cat3);
	}
	public List<Category> getCategoryList() {
		
		return categoryList;
	}

	public Category get(int id){
		
		for (Category cat : categoryList) {
			if(cat.getId() == id)
				return  cat; 
		}
		return null;
	}
	
}
