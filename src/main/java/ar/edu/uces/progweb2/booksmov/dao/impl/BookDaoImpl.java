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

import ar.edu.uces.progweb2.booksmov.dao.BookDao;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Book;

@Repository
public class BookDaoImpl implements BookDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Book b WHERE b.user.id = :userId");
		query.setLong("userId", id);
		return query.list();
	}

	@Override
	public void update(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Book b WHERE b.user.name = :name");
		query.setString("name", userName);
		return (List<Book>) query.list();
	}

	@Override
	public Book getBookById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Book b WHERE b.id = :id");
		query.setLong("id", id);
		return (Book) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksByCriteria(FilterDto filterDto) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Book.class);

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
			criteria.createAlias("authors", "author");
			disjunction.add(Restrictions.ilike("title", "%" + filterDto.getTitle() + "%"));
			disjunction.add(Restrictions.ilike("author.fullName", "%" + filterDto.getTitle() + "%"));
		}
		criteria.add(disjunction);
		criteria.add(conjunction);
		return (List<Book>) criteria.list();
	}

}
