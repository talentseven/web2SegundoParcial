package ar.edu.uces.progweb2.booksmov.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Book;
import ar.edu.uces.progweb2.booksmov.search.filter.CriteriaBuilder;
import ar.edu.uces.progweb2.booksmov.search.filter.TypeSelector;
import ar.edu.uces.progweb2.booksmov.service.BookService;
import ar.edu.uces.progweb2.booksmov.service.MovieService;

@Controller
@RequestMapping("/app/filter")
public class FilterController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView filter(){
		
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("filterDto", new FilterDto());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView filterSearch(@ModelAttribute("filterDto") FilterDto filterDto){
		
		CriteriaBuilder cb = CriteriaBuilder.getInstance();
		Map<String, String> values = new LinkedHashMap<String, String>();
		TypeSelector selector = new TypeSelector();
		ModelAndView mav = new ModelAndView("search");
		Map<String, Object> options = filterDto.getOptionsMap();
		decideOverallSearch((String) options.get("type"), selector);
		List<BookDto> books = null;
		if(selector.isAll()){
			
			
		}else if(selector.isBooksOnly()){
			
			String userName = (String) options.get("userName");
			
			
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
			books = bookService.getBooksByUserName(userName);
		}else{
			
			
		}
		
		mav.addObject("products", books);
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
