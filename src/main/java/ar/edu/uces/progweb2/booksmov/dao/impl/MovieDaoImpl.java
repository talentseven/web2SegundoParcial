package ar.edu.uces.progweb2.booksmov.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.progweb2.booksmov.dao.MovieDao;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Movie movie) {
		sessionFactory.getCurrentSession().save(movie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMovies(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Movie m WHERE m.user.id = :userId");
		query.setLong("userId", id);
		return query.list();
	}

	@Override
	public void update(Movie movie) {
		sessionFactory.getCurrentSession().update(movie);
	}

	@Override
	public Movie getMovieById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Movie m WHERE m.id = :id");
		query.setLong("id", id);
		return (Movie) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMoviesByCriteria(FilterDto filterDto) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Movie.class);
		
		if(!StringUtils.isBlank(filterDto.getUserName())){
			criteria.createAlias("user", "u");
			criteria.add(Restrictions.ilike("u.name", filterDto.getUserName()));
		}
		if(filterDto.getRating() != null){
			criteria.add(Restrictions.eq("rating", filterDto.getRating()));
		}
		if(filterDto.isBorrowable()){
			criteria.add(Restrictions.eq("borrowable", filterDto.isBorrowable()));
		}
		if(!StringUtils.isBlank(filterDto.getTitle())){
			criteria.createAlias("actors", "actor");
			criteria.createAlias("director", "dir");
			criteria.add(Restrictions.ilike("title", filterDto.getTitle()));
			criteria.add(Restrictions.ilike("actor.fullName", filterDto.getTitle()));
			criteria.add(Restrictions.ilike("dir.fullName", filterDto.getTitle()));
		}
		return (List<Movie>) criteria.list();
	}

}
