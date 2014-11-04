package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.booksmov.dto.CriteriaSearchDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.SearchResultDto;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.ProductService;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/search")
public class SearchController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(method=RequestMethod.GET)
	public String findProducts(ModelMap model, 
			@RequestParam(value="page", required=false, defaultValue="0") String page,
			@RequestParam(value="rating", required=false, defaultValue="false") String rating,
			@RequestParam(value="order", required=false, defaultValue="asc") String order){
		
		User user = (User) model.get("user");
		Long id = user.getId();
		Integer pageId = Integer.parseInt(page);
		CriteriaSearchDto searchCriteria = new CriteriaSearchDto(pageId, order, Boolean.valueOf(rating));
		SearchResultDto searchResult = productService.getProductsByUserId(id, searchCriteria);
		model.addAttribute("filterDto", new FilterDto());
		model.addAttribute("products", searchResult.getProducts());
		model.addAttribute("pagination", searchResult.getPaginationDetails());
		model.addAttribute("search", searchCriteria);
		return "search";
	}
	
	
}
