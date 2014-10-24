package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app/search")
public class SearchController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String findProducts(){
		
		return "search";
	}
}
