package ar.edu.uces.progweb2.booksmov.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import ar.edu.uces.progweb2.booksmov.model.Author;

public class BookDto extends ProductDto{
	
	private String isbn;
	private String description;
	private String authors;
	private Set<Author> authorsSet = new HashSet<Author>();
	
	public BookDto(){}
	
	public BookDto(String title, String rating, boolean alreadyUsed,
			boolean borrowable, Serializable image, String isbn,
			String description) {
		this.title = title;
		this.rating = rating;
		this.alreadyUsed = alreadyUsed;
		this.borrowable = borrowable;
		this.image = image;
		this.isbn = isbn;
		this.description = description;
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
	
	public Set<Author> getAuthorsSet() {
		return authorsSet;
	}

	public void setAuthorsSet(Set<Author> authorsSet) {
		this.authorsSet = authorsSet;
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
