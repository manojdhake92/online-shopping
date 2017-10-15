package md.spring.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import md.spring.shoppingbackend.dao.CategoryDAO;
import md.spring.shoppingbackend.dto.Category;

@Repository("categoryDao")  //This annotation allows to get data access.
@Transactional
public class CategoryDAOImpl   implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private  static List<Category> categoryList= new ArrayList<Category>();
	
	
	public List<Category> getCategoryList() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Category WHERE active = :active"); 
		query.setParameter("active", true);
		return query.list();
	}

	public Category get(int id){
		return (Category) sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	
	}

	public boolean addCategory(Category category) {
		
		try{
					sessionFactory.getCurrentSession().save(category);
					return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean updateCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
				e.printStackTrace();
	return false;
}
	}

	
	public boolean deleteCategory(Category category) {
		category.setActive(false);
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
				e.printStackTrace();
	return false;
}
	}
	
	
	
}
