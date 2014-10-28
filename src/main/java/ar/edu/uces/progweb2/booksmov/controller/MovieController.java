package ar.edu.uces.progweb2.booksmov.controller;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.booksmov.dto.MovieDto;
import ar.edu.uces.progweb2.booksmov.model.Actor;
import ar.edu.uces.progweb2.booksmov.model.Format;
import ar.edu.uces.progweb2.booksmov.model.Movie;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.ImageService;
import ar.edu.uces.progweb2.booksmov.service.MovieService;
import ar.edu.uces.progweb2.booksmov.validator.MovieValidator;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/movies")
public class MovieController {
	
	@Autowired
	private MovieValidator movieValidator;
	@Autowired
	private MovieService movieService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String addBook(ModelMap model){
		
		MovieDto movieDto = new MovieDto();
		movieDto.setFormats(Arrays.asList(Format.values()));
		model.addAttribute("movieDto", movieDto);
		return "addMovie";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addMovie(@ModelAttribute("movieDto") MovieDto movieDto, BindingResult result, ModelMap model) throws IOException{
		
		movieValidator.validate(movieDto, result);
		if(!result.hasErrors()){
			Movie movie = new Movie();
			movie.setAlreadyUsed(movieDto.isAlreadyUsed());
			movie.setBorrowable(movieDto.isBorrowable());
			movie.setDirector(movieDto.getDirector());
			movie.setFormat(movieDto.getSelectedFormat());
			movie.setImage(imageService.getImage(movieDto.getImage()));
			movie.setIsan(movieDto.getIsan());
			movie.setRating(movieDto.getRating());
			movie.setTitle(movieDto.getTitle());
			movie.setUser((User) model.get("user"));
			
			String actors = movieDto.getActors();
			if(!StringUtils.isBlank(actors)){
				parseActors(actors, movie);
			}
			
			movieService.save(movie);
			movieDto.setSuccess(true);
			movieDto.clearFields();
		}
		
		return "addMovie";
	}
	
	private void parseActors(String actors, Movie movie) {
		
		String[] result = actors.split(",");
		
		for (int i = 0; i < result.length; i++) {
			Actor actor = new Actor(result[i].trim());
			actor.setMovie(movie);
			movie.getActors().add(actor);
		}
	}

}
