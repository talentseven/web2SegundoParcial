package ar.edu.uces.progweb2.booksmov.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.booksmov.dao.BookDao;
import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.model.Book;
import ar.edu.uces.progweb2.booksmov.service.BookConverterService;
import ar.edu.uces.progweb2.booksmov.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookConverterService converter;
	
	@Override
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	public List<BookDto> getBooksByUserId(Long id) {
		List<Book> books = bookDao.getBooks(id);
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		return transform(books, bookDtos);
	}

	private List<BookDto> transform(List<Book> books, List<BookDto> bookDtos) {
		for (Book book : books) {
			bookDtos.add(converter.transform(book));
		}
		return bookDtos;
	}

	@Override
	public BookDto getBookByIsbn(String isbn) {
		Book book = bookDao.getBookByIsbn(isbn);
		return converter.transform(book);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Book book) {
		bookDao.update(book);
		
	}

	@Override
	public List<BookDto> searchBooksWithCriteria(String criteria, Map<String, String> values) {
		List<Book> books = bookDao.getBooksByCriteria(criteria, values);
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		return transform(books, bookDtos);
	}

	@Override
	public List<BookDto> getBooksByUserName(String userName) {
		List<Book> books = bookDao.getBooksByUserName(userName);
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		return transform(books, bookDtos);
	}

	@Override
	public BookDto getBookById(Long id) {
		Book book = bookDao.getBookById(id);
		return converter.transform(book);
	}

}
