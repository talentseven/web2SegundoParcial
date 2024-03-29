package ar.edu.uces.progweb2.booksmov.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private Long id;
	private String name;
	private String password;
	private Preference preferences;
	private Set<Product> products = new HashSet<Product>();
	private Set<LoanRequest> pendingLoans = new HashSet<LoanRequest>();
	
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

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Set<LoanRequest> getPendingLoans() {
		return pendingLoans;
	}
	public void setPendingLoans(Set<LoanRequest> pendingLoans) {
		this.pendingLoans = pendingLoans;
	}
	
}
