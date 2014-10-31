package ar.edu.uces.progweb2.booksmov.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.MovieDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.search.filter.CriteriaBuilder;
import ar.edu.uces.progweb2.booksmov.search.filter.TypeSelector;
import ar.edu.uces.progweb2.booksmov.service.BookService;
import ar.edu.uces.progweb2.booksmov.service.LoanService;
import ar.edu.uces.progweb2.booksmov.service.MovieService;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/filter")
public class FilterController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private LoanService loanService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView filter(){
		
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("filterDto", new FilterDto());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView filterSearch(@ModelAttribute("filterDto") FilterDto filterDto, ModelMap model){
		
		CriteriaBuilder cb = CriteriaBuilder.getInstance();
		User user = (User) model.get("user");
		Map<String, String> values = new LinkedHashMap<String, String>();
		//TypeSelector selector = new TypeSelector();
		ModelAndView mav = new ModelAndView("search");
		//Map<String, Object> options = filterDto.getOptionsMap();
		//decideOverallSearch((String) options.get("type"), selector);
		List<BookDto> books = null;
		List<MovieDto> movies = null;
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		if(filterDto.getType().equals("movies")){
			
			movies = movieService.getMoviesByCriteria(filterDto);
			
		}else if(filterDto.getType().equals("books")){
			
			//String userName = (String) options.get("userName");
			String userName = filterDto.getUserName();
			
			/*
			String userName = (String) options.get("userName");
			String title = (String) options.get("title");
			String borrowable = ((Boolean)options.get("borrowable")) ? "1" : "0";
			String rating = (String) options.get("rating");
			cb.from(Book.class);
			cb.join(User.class);
			cb.on("Boo", "user_id", "Use", "id");
			if(!StringUtils.isBlank(title)){
				cb.join(Author.class);
				cb.on("Boo", "Aut", "userId", "id");
			}
			cb.where();
			cb.borrowable(borrowable, "Boo");
			values.put("Boo" + ".borrowable", borrowable);
			cb.and();
			cb.rating(rating, "Boo");
			values.put("Boo" + ".rating", rating);
			if(!StringUtils.isBlank(userName)){
				cb.and();
				cb.userName(userName);
				values.put("Use" + ".firstName", userName);
			}if(!StringUtils.isBlank(title)){
				cb.and();
				cb.title(title, "Boo");
				values.put("Boo" + ".title", title);
				cb.or();
				cb.author(title);
				values.put("Boo" + ".fullName", title);
			}
			
			bookService.searchBooksWithCriteria(cb.build(), values);
			*/
			
			books = bookService.getBooksByCriteria(filterDto);
			
			//books = bookService.getBooksByUserName(userName);
			productDtos.addAll(books);
		}else{
			
			
		}
		
		loanService.setRequestableForLoan(productDtos, user.getId());
		mav.addObject("products", productDtos);
		return mav;
	}
	
	private void decideOverallSearch(String type, TypeSelector selector){
		
		switch(type){
			case "all" : selector.setAll(true); break; 
			case "books" : selector.setBooksOnly(true); break; 
			case "movies" : selector.setMoviesOnly(true); break; 
		}
	}
}
