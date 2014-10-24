package ar.edu.uces.progweb2.booksmov.model;

import java.io.Serializable;
import java.util.Set;

public class Book extends Product{
	
	private String description;
	private Set<Author> authors;
	
	public Book(){}
	
	public Book(String title, String mark, boolean alreadyUsed, boolean borrowable, Serializable image, String description, Set<Author> authors){
		super(title, mark, alreadyUsed, borrowable, image);
		this.description = description;
		this.authors = authors;
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
	
}
