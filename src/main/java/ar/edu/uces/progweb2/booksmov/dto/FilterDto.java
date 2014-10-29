package ar.edu.uces.progweb2.booksmov.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import ar.edu.uces.progweb2.booksmov.model.Product;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.search.filter.OptionSearch;

public class FilterDto {
	
	/*
	private String userName;
	private String rating = "3";
	private String title;
	private String type = "all";
	private boolean borrowable;
	*/
	private OptionSearch borrowable; 
	private OptionSearch userName;
	private OptionSearch rating; 
	private OptionSearch type; 
	private OptionSearch title; 
	
	public FilterDto(){
		borrowable = new OptionSearch(Product.class, "borrowable", false);
		userName = new OptionSearch(User.class, "userName", "");
		rating = new OptionSearch(Product.class, "rating", "3");
		type = new OptionSearch(String.class, "type", "all");
		title = new OptionSearch(String.class, "title", "");
	}
	
	public Map<String, Object> getOptionsMap(){
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put("userName", userName.getValue());
		options.put("rating", rating.getValue());
		options.put("title", title.getValue());
		options.put("type", type.getValue());
		options.put("borrowable", borrowable.isBoolValue());
		
		return options;
	}

	public OptionSearch getBorrowable() {
		return borrowable;
	}

	public void setBorrowable(OptionSearch borrowable) {
		this.borrowable = borrowable;
	}

	public OptionSearch getUserName() {
		return userName;
	}

	public void setUserName(OptionSearch userName) {
		this.userName = userName;
	}

	public OptionSearch getRating() {
		return rating;
	}

	public void setRating(OptionSearch rating) {
		this.rating = rating;
	}

	public OptionSearch getType() {
		return type;
	}

	public void setType(OptionSearch type) {
		this.type = type;
	}

	public OptionSearch getTitle() {
		return title;
	}

	public void setTitle(OptionSearch title) {
		this.title = title;
	}
	
	
}
