package ar.edu.uces.progweb2.booksmov.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.progweb2.booksmov.dao.ProductDao;
import ar.edu.uces.progweb2.booksmov.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProductsByUserId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Product p WHERE p.user.id = :id");
		query.setLong("id", id);
		return (List<Product>) query.list();
	}

}
