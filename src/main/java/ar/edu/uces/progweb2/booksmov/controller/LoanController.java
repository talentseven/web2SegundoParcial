package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.service.BookService;

@Controller
@RequestMapping("/app/loan")
public class LoanController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/{id}")
	public String requestLoan(@PathVariable("id") Long id, @RequestParam("type") String type, Model model){
		
		if("book".equalsIgnoreCase(type)){
			BookDto bookDto = bookService.getBookById(id);
			model.addAttribute("bookDto", bookDto);
		}else{
			
		}
		return "loanRequest";
	}
	
}
