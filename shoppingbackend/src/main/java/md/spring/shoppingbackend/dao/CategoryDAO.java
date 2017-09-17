package md.spring.shoppingbackend.dao;
import java.util.List;

import md.spring.shoppingbackend.dto.Category;
public interface CategoryDAO {
	
	List<Category> getCategoryList();
	Category get(int id);

}
