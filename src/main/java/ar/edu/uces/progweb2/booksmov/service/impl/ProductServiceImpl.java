package ar.edu.uces.progweb2.booksmov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.booksmov.dao.ProductDao;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.model.Product;
import ar.edu.uces.progweb2.booksmov.service.ProductConverterService;
import ar.edu.uces.progweb2.booksmov.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductConverterService converter;
	
	
	@Override
	public List<ProductDto> getProductsByUserId(Long id) {
		List<Product> products = productDao.getProductsByUserId(id);
		List<ProductDto> productsDto = new ArrayList<ProductDto>();
		for (Product product : products) {
			productsDto.add(converter.toDto(product));
		}
		
		return productsDto;
	}

	@Override
	public Product getProductById(Long id) {
		return productDao.getProductById(id);
	}

}
