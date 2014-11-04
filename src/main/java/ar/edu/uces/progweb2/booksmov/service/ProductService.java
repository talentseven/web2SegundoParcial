package ar.edu.uces.progweb2.booksmov.service;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.CriteriaSearchDto;
import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.dto.SearchResultDto;
import ar.edu.uces.progweb2.booksmov.model.Product;

public interface ProductService {
	
	SearchResultDto getProductsByUserId(Long id, CriteriaSearchDto criteriaSearch);
	List<ProductDto> getProductsByCriteria(FilterDto filterDto);
	Product getProductById(Long id);
}
