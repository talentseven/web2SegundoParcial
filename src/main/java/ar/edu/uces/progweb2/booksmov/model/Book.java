package ar.edu.uces.progweb2.booksmov.model;

import java.util.HashSet;
import java.util.Set;

public class Book extends Product{
	
	private String isbn;
	private String description;
	private Set<Author> authors = new HashSet<Author>();
	
	public Book(){}
	
	public Book(String isbn, String title, String mark, boolean alreadyUsed, boolean borrowable, byte[] image, String description, User user){
		super(title, mark, alreadyUsed, borrowable, image, user);
		this.isbn = isbn;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
