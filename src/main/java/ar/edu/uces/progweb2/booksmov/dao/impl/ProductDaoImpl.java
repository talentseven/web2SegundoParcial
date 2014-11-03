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
import ar.edu.uces.progweb2.booksmov.dto.PaginationDetailsDto;
import ar.edu.uces.progweb2.booksmov.model.Product;
import ar.edu.uces.progweb2.booksmov.model.SearchResult;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public SearchResult getProductsByUserId(Long id, Integer page) {
		Session session = sessionFactory.getCurrentSession();
		SearchResult searchResult = new SearchResult();
		
		int pageSize = 3;
	    String count = "Select count (p.id) FROM Product p WHERE p.user.id = :id";
	    Query countQuery = session.createQuery(count);
	    countQuery.setLong("id", id);
	    Long countResults = (Long) countQuery.uniqueResult();
	    int lastPageNumber = (int) ((countResults / pageSize) + 1);
		int firstResult = page * pageSize;
		
		Query selectQuery = session.createQuery("FROM Product p WHERE p.user.id = :id");
		selectQuery.setLong("id", id);
		selectQuery.setFirstResult(firstResult);
	    selectQuery.setMaxResults(pageSize);
	    List<Product> products = (List<Product>) selectQuery.list();
	    
	    PaginationDetailsDto paginationDetails = new PaginationDetailsDto();
	    paginationDetails.setCurrentPage(page);
	    paginationDetails.setItemsPerPage(Integer.valueOf(pageSize));
	    paginationDetails.setMaxPage(Integer.valueOf(lastPageNumber));
	    paginationDetails.setTotalResults(products.size());
	    paginationDetails.setEnd( (firstResult + pageSize) > lastPageNumber ? lastPageNumber : firstResult + pageSize);
	    paginationDetails.setBegin( page == 0 ? page + 1 : page);
	    	    
	    searchResult.setProducts(products);
	    searchResult.setPaginationDetails(paginationDetails);
	    
		return searchResult;
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
