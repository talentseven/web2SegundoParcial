package ar.edu.uces.progweb2.booksmov.dao;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.FilterDto;
import ar.edu.uces.progweb2.booksmov.model.Product;

public interface ProductDao {
	
	List<Product> getProductsByUserId(Long id);
	List<Product> getProductsByCriteria(FilterDto filterDto);
	Product getProductById(Long id);
}
