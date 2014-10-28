package ar.edu.uces.progweb2.booksmov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.dto.MovieDto;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.BookService;
import ar.edu.uces.progweb2.booksmov.service.MovieService;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/search")
public class SearchController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String findProducts(ModelMap model){
		
		User user = (User) model.get("user");
		Long id = user.getId();
		
		List<BookDto> books = bookService.getBooksByUserId(id);
		List<MovieDto> movies = movieService.getMoviesByUserId(id);
		model.addAttribute("books", books);
		model.addAttribute("movies", movies);
		
		return "search";
	}
}
