package ar.edu.uces.progweb2.booksmov.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.progweb2.booksmov.dao.LoanDao;
import ar.edu.uces.progweb2.booksmov.model.LoanRequest;
import ar.edu.uces.progweb2.booksmov.model.LoanStateEnum;
@Repository
public class LoanDaoImpl implements LoanDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LoanRequest> getLoanRequestsByProductAndUserId(Long productId, Long userId) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoanRequest.class);
		criteria.add(Restrictions.eq("product.id", productId));
		criteria.add(Restrictions.eq("requester.id", userId));
		return (List<LoanRequest>) criteria.list();
	}

	@Override
	public void save(LoanRequest loan) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(loan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanRequest> getMyRequestedLoans(Long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoanRequest.class);
		criteria.add(Restrictions.eq("requester.id", userId));
		criteria.add(Restrictions.ne("state", LoanStateEnum.DELIVERED));
		return (List<LoanRequest>) criteria.list();
	}

	@Override
	public List<LoanRequest> getMyNotifiedLoans(Long userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoanRequest.class);
		criteria.add(Restrictions.eq("consignee.id", userId));
		return (List<LoanRequest>) criteria.list();
	}

}
