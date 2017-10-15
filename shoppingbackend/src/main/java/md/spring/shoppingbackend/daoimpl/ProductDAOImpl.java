package md.spring.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import md.spring.shoppingbackend.dao.ProductDAO;
import md.spring.shoppingbackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getProductList() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	}

	@Override
	public Product get(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));

	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getAllActiveProducts() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active =:active")
				.setParameter("active", true).list();
	}

	@Override
	public List<Product> getAllActiveProductsByCategory(int categoryId) {
		return (List<Product>) sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active =:active and categoryId =:categoryId")
				.setParameter("active", true).setParameter("categoryId", categoryId).list();
	}

	@Override
	public List<Product> getAllActiveLatestProducts(int count) {
		return (List<Product>) sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active =:active order by id").setParameter("active", true)
				.setFirstResult(0).setMaxResults(count).list();
	}

}
