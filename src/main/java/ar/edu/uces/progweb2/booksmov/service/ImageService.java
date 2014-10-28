package ar.edu.uces.progweb2.booksmov.service;

import java.io.IOException;
import java.io.Serializable;

public interface ImageService {
	
	byte[] getImage(Serializable serializable) throws IOException;
}
