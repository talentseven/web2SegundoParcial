package ar.edu.uces.progweb2.booksmov.dao;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Movie;

public interface MovieDao {
	
	void save(Movie movie);
	List<Movie> getMovies(Long id);
	void update(Movie movie);
	Movie getMovieById(Long id);
	List<Movie> getMoviesByCriteria(FilterDto filterDto);
}
