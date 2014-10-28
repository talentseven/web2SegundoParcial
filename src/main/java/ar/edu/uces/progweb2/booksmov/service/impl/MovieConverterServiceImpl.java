package ar.edu.uces.progweb2.booksmov.service.impl;

import org.springframework.stereotype.Service;

import ar.edu.uces.progweb2.booksmov.dto.MovieDto;
import ar.edu.uces.progweb2.booksmov.model.Movie;
import ar.edu.uces.progweb2.booksmov.service.MovieConverterService;

@Service
public class MovieConverterServiceImpl implements MovieConverterService {

	@Override
	public MovieDto transform(Movie movie) {
		
		MovieDto movieDto = new MovieDto();
		movieDto.setActorSet(movie.getActors());
		movieDto.setAlreadyUsed(movie.isAlreadyUsed());
		movieDto.setBorrowable(movie.isBorrowable());
		movieDto.setDirector(movie.getDirector());
		movieDto.setSelectedFormat(movie.getFormat());
		movieDto.setImage(movie.getImage());
		movieDto.setIsan(movie.getIsan());
		movieDto.setRating(movie.getRating());
		movieDto.setTitle(movie.getTitle());
		
		return movieDto;
	}

}
