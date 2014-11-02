package ar.edu.uces.progweb2.booksmov.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.progweb2.booksmov.dao.ProductDao;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsByUserId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Product p WHERE p.user.id = :id");
		query.setLong("id", id);
		return (List<Product>) query.list();
	}

	@Override
	public Product getProductById(Long id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsByCriteria(FilterDto filterDto) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);

		Conjunction conjunction = Restrictions.conjunction();
		Disjunction disjunction = Restrictions.disjunction();
		
		if(!StringUtils.isBlank(filterDto.getUserName())){
			criteria.createAlias("user", "u");
			disjunction.add(Restrictions.ilike("u.name", "%" + filterDto.getUserName() + "%"));
		}
		if(filterDto.getRating() != null){
			conjunction.add(Restrictions.eq("rating", filterDto.getRating()));
		}
		
		conjunction.add(Restrictions.eq("borrowable", filterDto.isBorrowable()));
		
		if(!StringUtils.isBlank(filterDto.getTitle())){
			disjunction.add(Restrictions.ilike("title", "%" + filterDto.getTitle() + "%"));
		}
		criteria.add(disjunction);
		criteria.add(conjunction);
		return (List<Product>) criteria.list();
	}

}
