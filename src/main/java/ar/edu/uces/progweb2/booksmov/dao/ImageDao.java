package ar.edu.uces.progweb2.booksmov.dao;

public interface ImageDao {
	
	byte[] getBookImage(String isbn);
	
	byte[] getMovieImage(String isan);
}
