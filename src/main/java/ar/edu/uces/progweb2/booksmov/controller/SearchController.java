package ar.edu.uces.progweb2.booksmov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.BookService;
import ar.edu.uces.progweb2.booksmov.service.MovieService;
import ar.edu.uces.progweb2.booksmov.service.ProductService;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/search")
public class SearchController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private ProductService productService;

	@RequestMapping(method=RequestMethod.GET)
	public String findProducts(ModelMap model){
		
		User user = (User) model.get("user");
		Long id = user.getId();
		List<ProductDto> products = productService.getProductsByUserId(id);
		model.addAttribute("filterDto", new FilterDto());
		model.addAttribute("products", products);
		return "search";
	}
	
	
}
