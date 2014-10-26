package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;

@Controller
@RequestMapping("/app/books")
public class BookController {
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String addBook(Model model){
		
		model.addAttribute("bookDto", new BookDto());
		return "addBook";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addBook(@ModelAttribute("bookDto") BookDto bookDto, BindingResult result, Model model){
		
		return "addBook";
	}
}
