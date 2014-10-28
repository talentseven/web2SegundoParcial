package ar.edu.uces.progweb2.booksmov.controller;

import java.io.IOException;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.model.Author;
import ar.edu.uces.progweb2.booksmov.model.Book;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.BookService;
import ar.edu.uces.progweb2.booksmov.service.ImageService;
import ar.edu.uces.progweb2.booksmov.validator.BookValidator;

@Controller
@SessionAttributes("user")
@RequestMapping("/app/books")
public class BookController {
	
	@Autowired
	private BookValidator bookValidator;
	@Autowired
	private BookService bookService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String addBook(ModelMap model){
		
		model.addAttribute("bookDto", new BookDto());
		return "addBook";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addBook(@ModelAttribute("bookDto") BookDto bookDto, BindingResult result, ModelMap model) throws FileUploadException, IOException{
		
		bookValidator.validate(bookDto, result);
		if(!result.hasErrors()){
		
			Book book = new Book();
			book.setImage(imageService.getImage(bookDto.getImage()));
			book.setAlreadyUsed(bookDto.isAlreadyUsed());
			book.setBorrowable(bookDto.isBorrowable());
			book.setDescription(bookDto.getDescription());
			book.setIsbn(bookDto.getIsbn());
			book.setRating(bookDto.getRating());
			book.setTitle(bookDto.getTitle());
			book.setUser((User) model.get("user"));
			
			String authors = bookDto.getAuthors();
			if(!StringUtils.isBlank(authors)){
				parseAuthors(authors, book);
			}
			
			System.out.println();
			bookService.save(book);
			bookDto.setSuccess(true);
			bookDto.clearFields();
		}
		
		return "addBook";
	}

	private void parseAuthors(String authors, Book book) {
		
		String[] result = authors.split(",");
		
		for (int i = 0; i < result.length; i++) {
			Author author = new Author(result[i].trim());
			author.getBooks().add(book);
			book.getAuthors().add(author);
		}
	}
	
}
