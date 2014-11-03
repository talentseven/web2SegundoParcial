package ar.edu.uces.progweb2.booksmov.dto;

import java.util.List;

public class SearchResultDto {
	
	private List<ProductDto> products;
	private PaginationDetailsDto paginationDetails;
	
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	public PaginationDetailsDto getPaginationDetails() {
		return paginationDetails;
	}
	public void setPaginationDetails(PaginationDetailsDto paginationDetails) {
		this.paginationDetails = paginationDetails;
	}
	
	
}
