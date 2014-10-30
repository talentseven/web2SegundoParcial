package ar.edu.uces.progweb2.booksmov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.booksmov.dao.ProductDao;
import ar.edu.uces.progweb2.booksmov.dto.BookDto;
import ar.edu.uces.progweb2.booksmov.dto.MovieDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.model.Book;
import ar.edu.uces.progweb2.booksmov.model.Movie;
import ar.edu.uces.progweb2.booksmov.model.Product;
import ar.edu.uces.progweb2.booksmov.service.BookConverterService;
import ar.edu.uces.progweb2.booksmov.service.MovieConverterService;
import ar.edu.uces.progweb2.booksmov.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BookConverterService bookConverter;
	@Autowired
	private MovieConverterService movieConverter;
	
	@Override
	public List<ProductDto> getProductsByUserId(Long id) {
		List<Product> products = productDao.getProductsByUserId(id);
		List<ProductDto> productsDto = new ArrayList<ProductDto>();
		
		for (Product product : products) {
			if(product instanceof Book){
				Book book = (Book) product;
				BookDto bookDto = bookConverter.transform(book);
				productsDto.add(bookDto);
			}else{
				Movie movie = (Movie) product;
				MovieDto movieDto = movieConverter.transform(movie);
				productsDto.add(movieDto);
			}
		}
		
		return productsDto;
	}

}
