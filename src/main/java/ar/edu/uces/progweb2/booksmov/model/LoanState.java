package ar.edu.uces.progweb2.booksmov.model;

public abstract class LoanState {
	
	protected Long id;
	protected String description;
	
	public abstract boolean canRequestProductLoan();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
