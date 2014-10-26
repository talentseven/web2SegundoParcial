package ar.edu.uces.progweb2.booksmov.dto;

import java.io.Serializable;
import java.util.Set;

import ar.edu.uces.progweb2.booksmov.model.Author;

public class BookDto {
	
	private String title;
	private String rating;
	private boolean alreadyUsed;
	private boolean borrowable;
	private Serializable image;
	private String isbn;
	private String description;
	private Set<Author> authors;
	private Author newAuthor;
	
	public BookDto(){}
	
	public BookDto(String isbn){
		this.isbn = isbn;
	}
	
	public BookDto(String title, String rating, boolean alreadyUsed,
			boolean borrowable, Serializable image, String isbn,
			String description, Set<Author> authors, Author newAuthor) {
		this.title = title;
		this.rating = rating;
		this.alreadyUsed = alreadyUsed;
		this.borrowable = borrowable;
		this.image = image;
		this.isbn = isbn;
		this.description = description;
		this.authors = authors;
		this.newAuthor = newAuthor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isAlreadyUsed() {
		return alreadyUsed;
	}

	public void setAlreadyUsed(boolean alreadyUsed) {
		this.alreadyUsed = alreadyUsed;
	}

	public boolean isBorrowable() {
		return borrowable;
	}

	public void setBorrowable(boolean borrowable) {
		this.borrowable = borrowable;
	}

	public Serializable getImage() {
		return image;
	}

	public void setImage(Serializable image) {
		this.image = image;
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

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Author getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(Author newAuthor) {
		this.newAuthor = newAuthor;
	}
	
	
	
}
