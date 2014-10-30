package ar.edu.uces.progweb2.booksmov.dao;

import java.util.List;
import java.util.Map;

import ar.edu.uces.progweb2.booksmov.model.Book;

public interface BookDao {
	
	void save(Book book);
	List<Book> getBooks(Long id);
	void update(Book book);
	List<Book> getBooksByCriteria(String criteria, Map<String, String> values);
	List<Book> getBooksByUserName(String userName);
	Book getBookById(Long id);
}
