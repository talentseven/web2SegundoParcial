package ar.edu.uces.progweb2.booksmov.service;

import java.io.IOException;
import java.io.Serializable;

public interface ImageService {
	
	byte[] getImage(Serializable serializable, String type) throws IOException;
	
	byte[] getBookImageFromDb(Long id) throws IOException;
	
	byte[] getMovieImageFromDb(Long id) throws IOException;

	byte[] getProductImageFromDb(Long id) throws IOException;

}
