package ar.edu.uces.progweb2.booksmov.service;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.dto.CriteriaSearchDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.SearchResultDto;
import ar.edu.uces.progweb2.booksmov.model.Book;

public interface BookService {

	void save(Book book);
	List<BookDto> getBooksByUserId(Long id);
	BookDto getBookById(Long id);
	void update(Book book);
	List<BookDto> getBooksByUserName(String userName);
	SearchResultDto getBooksByCriteria(FilterDto filterDto, CriteriaSearchDto searchCriteria);
}
