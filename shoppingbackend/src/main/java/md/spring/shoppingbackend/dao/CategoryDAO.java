package md.spring.shoppingbackend.dao;
import java.util.List;

import md.spring.shoppingbackend.dto.Category;
public interface CategoryDAO {
	
	boolean addCategory(Category category);
	List<Category> getCategoryList();
	Category get(int id);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	
}
