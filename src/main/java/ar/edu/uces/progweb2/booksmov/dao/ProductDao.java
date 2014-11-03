package ar.edu.uces.progweb2.booksmov.dao;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Product;
import ar.edu.uces.progweb2.booksmov.model.SearchResult;

public interface ProductDao {
	
	SearchResult getProductsByUserId(Long id, Integer page);
	List<Product> getProductsByCriteria(FilterDto filterDto);
	Product getProductById(Long id);
}
