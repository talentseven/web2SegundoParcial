package ar.edu.uces.progweb2.booksmov.model;

import java.io.Serializable;

public abstract class Product {
	
	private Long id;
	protected String title;
	protected String rating;
	protected boolean alreadyUsed;
	protected boolean borrowable;
	protected Serializable image;
	
	public Product(){}
	
	public Product(String title, String rating, boolean alreadyUsed, boolean borrowable, Serializable image) {
		this.title = title;
		this.rating = rating;
		this.alreadyUsed = alreadyUsed;
		this.borrowable = borrowable;
		this.image = image;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
