package ar.edu.uces.progweb2.booksmov.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ar.edu.uces.progweb2.booksmov.model.Author;

public class BookDto extends ProductDto{
	
	private String isbn;
	private String description;
	private String authors;
	private List<Author> authorsList = new ArrayList<Author>();
	
	public BookDto(){}
	
	public BookDto(String title, String rating, boolean alreadyUsed,
			boolean borrowable, Serializable image, String isbn,
			String description, Long userId) {
		super(title, rating, alreadyUsed, borrowable, image, userId);
		this.isbn = isbn;
		this.description = description;
		this.type = "book";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public List<Author> getAuthorsList() {
		return authorsList;
	}

	public void setAuthorsList(List<Author> authorsList) {
		this.authorsList = authorsList;
	}

	public void clearFields(){
		this.isbn = null;
		this.title = null;
		this.description = null;
		this.rating = null;
		this.borrowable = false;
		this.image = null;
		this.alreadyUsed = false;
		this.authors = null;
	}
}
