package ar.edu.uces.progweb2.booksmov.dto;


public class FilterDto {
	
	
	private String userName;
	private String rating = "3";
	private String title;
	private String type = "all";
	private boolean borrowable;
	
	/*
	private OptionSearch borrowable; 
	private OptionSearch userName;
	private OptionSearch rating; 
	private OptionSearch type; 
	private OptionSearch title; 
	*/
	/*
	public FilterDto(){
		borrowable = new OptionSearch(Product.class, "borrowable", false);
		userName = new OptionSearch(User.class, "userName", "");
		rating = new OptionSearch(Product.class, "rating", "3");
		type = new OptionSearch(String.class, "type", "all");
		title = new OptionSearch(String.class, "title", "");
	}
	*/
	public FilterDto(){
		
	}
	/*
	public Map<String, Object> getOptionsMap(){
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put("userName", userName.getValue());
		options.put("rating", rating.getValue());
		options.put("title", title.getValue());
		options.put("type", type.getValue());
		options.put("borrowable", borrowable.isBoolValue());
		
		return options;
	}
*/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isBorrowable() {
		return borrowable;
	}

	public void setBorrowable(boolean borrowable) {
		this.borrowable = borrowable;
	}
	
	
}
