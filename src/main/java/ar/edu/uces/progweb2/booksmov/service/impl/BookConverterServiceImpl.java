package ar.edu.uces.progweb2.booksmov.service.impl;

import org.springframework.stereotype.Service;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.model.Book;
import ar.edu.uces.progweb2.booksmov.service.BookConverterService;

@Service
public class BookConverterServiceImpl implements BookConverterService{

	@Override
	public BookDto transform(Book book) {
		
		BookDto bookDto = new BookDto();
		bookDto.setAlreadyUsed(book.isAlreadyUsed());
		bookDto.setAuthorsSet(book.getAuthors());
		bookDto.setBorrowable(book.isBorrowable());
		bookDto.setImage(book.getImage());
		bookDto.setIsbn(book.getIsbn());
		bookDto.setRating(book.getRating());
		bookDto.setTitle(book.getTitle());
		
		return bookDto;
	}

}
