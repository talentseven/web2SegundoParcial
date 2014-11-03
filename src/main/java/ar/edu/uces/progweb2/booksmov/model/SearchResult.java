package ar.edu.uces.progweb2.booksmov.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.PaginationDetailsDto;

public class SearchResult {
	
	private List<Product> products = new ArrayList<Product>();
	private PaginationDetailsDto paginationDetails;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public PaginationDetailsDto getPaginationDetails() {
		return paginationDetails;
	}
	public void setPaginationDetails(PaginationDetailsDto paginationDetails) {
		this.paginationDetails = paginationDetails;
	}
	
	
}
