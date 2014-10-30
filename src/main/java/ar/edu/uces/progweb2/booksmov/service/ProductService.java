package ar.edu.uces.progweb2.booksmov.service;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> getProductsByUserId(Long id);
}
