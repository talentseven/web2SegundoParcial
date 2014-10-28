package ar.edu.uces.progweb2.booksmov.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.model.Author;

@Controller
@RequestMapping("/app/authors")
public class AuthorController {
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Set<Author>> addBook(@ModelAttribute("author") Author author, BindingResult result,
			ModelMap model){
		
		BookDto bookDto = (BookDto) model.get("bookDto");
		
		Map<String, Set<Author>> authors = new HashMap<String, Set<Author>>();
	//	bookDto.getAuthors().add(author);
		//authors.put("authors", bookDto.getAuthors());
		//model.addAttribute("bookDto", new BookDto());
		return authors;
	}
}
