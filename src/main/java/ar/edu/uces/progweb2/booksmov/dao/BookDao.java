package ar.edu.uces.progweb2.booksmov.dao;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.CriteriaSearchDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Book;
import ar.edu.uces.progweb2.booksmov.model.SearchResult;

public interface BookDao {
	
	void save(Book book);
	List<Book> getBooks(Long id);
	void update(Book book);
	List<Book> getBooksByUserName(String userName);
	Book getBookById(Long id);
	SearchResult getBooksByCriteria(FilterDto filterDto, CriteriaSearchDto searchCriteria);
}
