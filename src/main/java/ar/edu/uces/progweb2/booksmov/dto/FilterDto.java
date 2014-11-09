package ar.edu.uces.progweb2.booksmov.dto;


public class FilterDto {
	
	
	private String userName;
	private String rating;
	private String title;
	private String type = "all";
	private String borrowable;
	
	public FilterDto(String userName, String rating, String title, String type,
			String borrowable) {
		this.userName = userName;
		this.rating = rating;
		this.title = title;
		this.type = type;
		this.borrowable = borrowable;
	}
	public FilterDto(){
		
	}
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
	public String getBorrowable() {
		return borrowable;
	}
	public void setBorrowable(String borrowable) {
		this.borrowable = borrowable;
	}

}
