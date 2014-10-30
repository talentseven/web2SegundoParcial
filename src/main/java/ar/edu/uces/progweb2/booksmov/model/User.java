package ar.edu.uces.progweb2.booksmov.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private Long id;
	private String name;
	private String password;
	private Preference preferences;
	private Set<Book> books = new HashSet<Book>();
	private Set<Movie> movies = new HashSet<Movie>(); 
	private Set<LoanRequest> loans = new HashSet<LoanRequest>();
	
	public Preference getPreferences() {
		return preferences;
	}
	public void setPreferences(Preference preferences) {
		this.preferences = preferences;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	public Set<LoanRequest> getLoans() {
		return loans;
	}
	public void setLoans(Set<LoanRequest> loans) {
		this.loans = loans;
	}
	
	
}
