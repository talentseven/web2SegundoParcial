package ar.edu.uces.progweb2.booksmov.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Preference preferences;
	private Set<Book> books = new HashSet<Book>();
	private Set<Movie> movies = new HashSet<Movie>(); 
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
}
