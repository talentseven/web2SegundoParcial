package ar.edu.uces.progweb2.booksmov.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.dto.SearchResultDto;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.LoanService;
import ar.edu.uces.progweb2.booksmov.service.ProductService;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/search")
public class SearchController {
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private ProductService productService;

	@RequestMapping(method=RequestMethod.GET)
	public String findProducts(ModelMap model, 
			@RequestParam(value="page", required=false, defaultValue="0") String page,
			@RequestParam(value="rating", required=false, defaultValue="false") String rating,
			@RequestParam(value="order", required=false, defaultValue="asc") String order,
			@RequestParam(value="userName", required=false, defaultValue="") String userName,
			@RequestParam(value="stars", required=false) String stars,
			@RequestParam(value="title", required=false, defaultValue="") String title,
			@RequestParam(value="type", required=false, defaultValue="all") String type,
			@RequestParam(value="borrowable", required=false) Boolean borrowable){
		
		User user = (User) model.get("user");
		Long id = user.getId();
		Integer pageId = Integer.parseInt(page);
		FilterDto filterDto = new FilterDto(userName, stars, title, type, borrowable);
		CriteriaSearchDto searchCriteria = new CriteriaSearchDto(pageId, order, Boolean.valueOf(rating));
		SearchResultDto<ProductDto> searchResult = productService.getProductsByUserId(id, filterDto, searchCriteria);
		model.addAttribute("products", searchResult.getProducts());
		model.addAttribute("pagination", searchResult.getPaginationDetails());
		model.addAttribute("search", searchCriteria);
		model.addAttribute("filter", "");
		model.addAttribute("filterDto", new FilterDto());
		return "search";
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.GET)
	public ModelAndView filterProductsWhenOrdering(ModelMap model, 
			@RequestParam(value="page", required=false, defaultValue="0") String page,
			@RequestParam(value="rating", required=false, defaultValue="false") String rating,
			@RequestParam(value="order", required=false, defaultValue="asc") String order,
			@RequestParam(value="userName", required=false, defaultValue="") String userName,
			@RequestParam(value="stars", required=false) String stars,
			@RequestParam(value="title", required=false, defaultValue="") String title,
			@RequestParam(value="type", required=false, defaultValue="all") String type,
			@RequestParam(value="borrowable", required=false) Boolean borrowable){

		stars = StringUtils.isEmpty(stars) ? null : stars;
		FilterDto filterDto = new FilterDto(userName, stars, title, type, borrowable);
		return doSearch(filterDto, model, page, rating, order);
	}

	private ModelAndView doSearch(FilterDto filterDto, ModelMap model,	String page, String rating, String order) {
		User user = (User) model.get("user");
		ModelAndView mav = new ModelAndView("search");
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		SearchResultDto<?> searchResult = null;
		Integer pageId = Integer.parseInt(page);
		CriteriaSearchDto searchCriteria = new CriteriaSearchDto(pageId, order, Boolean.valueOf(rating));
		searchResult = productService.getProductsByCriteria(filterDto, searchCriteria);
		productDtos.addAll(searchResult.getProducts());
		loanService.setRequestableForLoan(productDtos, user.getId());
		mav.addObject("products", productDtos);
		mav.addObject("pagination", searchResult.getPaginationDetails());
		mav.addObject("search", searchCriteria);
		mav.addObject("filter", "filter");
		mav.addObject("filterDto", filterDto);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView filterProducts(@ModelAttribute("filterDto") FilterDto filterDto, ModelMap model, 
			@RequestParam(value="page", required=false, defaultValue="0") String page,
			@RequestParam(value="rating", required=false, defaultValue="false") String rating,
			@RequestParam(value="order", required=false, defaultValue="asc") String order){
		
		return doSearch(filterDto, model, page, rating, order);
		
	}

		
	
}
