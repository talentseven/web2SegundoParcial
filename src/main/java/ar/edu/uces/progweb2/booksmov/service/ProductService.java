package ar.edu.uces.progweb2.booksmov.service;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.model.Product;

public interface ProductService {
	
	List<ProductDto> getProductsByUserId(Long id);
	List<ProductDto> getProductsByCriteria(FilterDto filterDto);
	Product getProductById(Long id);
}
