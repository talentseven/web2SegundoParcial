package ar.edu.uces.progweb2.booksmov.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.progweb2.booksmov.dao.LoginDao;
import ar.edu.uces.progweb2.booksmov.model.User;

@Repository
public class LoginDaoImpl implements LoginDao{

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User get(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User where email = :mail");
		query.setString("mail", email);
		return (User) query.uniqueResult();

	}

}
