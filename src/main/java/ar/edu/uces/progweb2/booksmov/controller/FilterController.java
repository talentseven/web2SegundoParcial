package ar.edu.uces.progweb2.booksmov.controller;

import java.util.ArrayList;
import java.util.List;

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
import ar.edu.uces.progweb2.booksmov.service.BookService;
import ar.edu.uces.progweb2.booksmov.service.LoanService;
import ar.edu.uces.progweb2.booksmov.service.MovieService;
import ar.edu.uces.progweb2.booksmov.service.ProductService;

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
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView filter(){
		
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("filterDto", new FilterDto());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView filterSearch(@ModelAttribute("filterDto") FilterDto filterDto, ModelMap model){
		
		User user = (User) model.get("user");
		ModelAndView mav = new ModelAndView("search");
		List<BookDto> books = null;
		List<MovieDto> movies = null;
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
	
		if(filterDto.getType().equals("movies")){
		
			movies = movieService.getMoviesByCriteria(filterDto);
			productDtos.addAll(movies);
	
		}else if(filterDto.getType().equals("books")){
			
			books = bookService.getBooksByCriteria(filterDto);
			productDtos.addAll(books);

		}else{
			
			productDtos = productService.getProductsByCriteria(filterDto);
		}
		
		loanService.setRequestableForLoan(productDtos, user.getId());
		mav.addObject("products", productDtos);
		return mav;
	}
	
}
