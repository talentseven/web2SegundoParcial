package ar.edu.uces.progweb2.booksmov.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	public void update(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public List<Book> getBooksByCriteria(String criteria, Map<String, String> values) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(criteria);
		
		for(Map.Entry<String, String> entry : values.entrySet()){
			query.setString(entry.getKey(), entry.getValue());
		}
		return query.list();
	}
	
	@Override
	public List<Book> getBooksByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		//Query query = session.createQuery("SELECT ub FROM User u INNER JOIN u.books ub on u.id = ub.user.id WHERE u.firstName = :name");
		SQLQuery query = session.createSQLQuery("select * from books b inner join users u on b.user_id = u.id_user where u.first_name = :name");
		query.addEntity(Book.class);
		query.setParameter("name", userName);
		return (List<Book>) query.list();
	}

	@Override
	public Book getBookById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Book b WHERE b.id = :id");
		query.setLong("id", id);
		return (Book) query.uniqueResult();
	}

}
