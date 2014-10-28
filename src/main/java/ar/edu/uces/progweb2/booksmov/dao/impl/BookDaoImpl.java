package ar.edu.uces.progweb2.booksmov.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.progweb2.booksmov.dao.BookDao;
import ar.edu.uces.progweb2.booksmov.model.Book;

@Repository
public class BookDaoImpl implements BookDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public List<Book> getBooks(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Book b WHERE b.user.id = :userId");
		query.setLong("userId", id);
		return query.list();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Book b WHERE b.isbn = :isbn");
		query.setString("isbn", isbn);
		return (Book) query.uniqueResult();
	}

	@Override
	public void update(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

}
