package ar.edu.uces.progweb2.booksmov.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.booksmov.dto.CriteriaSearchDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.MovieDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.dto.SearchResultDto;
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
	public ModelAndView filterSearch(@ModelAttribute("filterDto") FilterDto filterDto,
			ModelMap model, @RequestParam(value="page", required=false, defaultValue="0") String page,
			@RequestParam(value="rating", required=false, defaultValue="false") String rating,
			@RequestParam(value="order", required=false, defaultValue="asc") String order){
		
		User user = (User) model.get("user");
		ModelAndView mav = new ModelAndView("search");
		List<MovieDto> movies = null;
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		Integer pageId = Integer.parseInt(page);
		SearchResultDto searchResult = null;
		CriteriaSearchDto searchCriteria = new CriteriaSearchDto(pageId, order, Boolean.valueOf(rating));
		
		if(filterDto.getType().equals("movies")){
		
			movies = movieService.getMoviesByCriteria(filterDto);
			productDtos.addAll(movies);
	
		}else if(filterDto.getType().equals("books")){
			
			searchResult = bookService.getBooksByCriteria(filterDto, searchCriteria);
			productDtos.addAll(searchResult.getProducts());

		}else{
			
			productDtos = productService.getProductsByCriteria(filterDto);
		}
		
		loanService.setRequestableForLoan(productDtos, user.getId());
		mav.addObject("products", productDtos);
		mav.addObject("pagination", searchResult.getPaginationDetails());
		mav.addObject("search", searchCriteria);
		
		return mav;
	}
	
}
