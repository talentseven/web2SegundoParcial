package ar.edu.uces.progweb2.booksmov.service.impl;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.uces.progweb2.booksmov.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ServletContext servletContext;
	
	@Override
	public byte[] getImage(Serializable serializable) throws IOException {
		
		MultipartFile multiPartFile = (MultipartFile) serializable;
		byte[] file = multiPartFile.getBytes();
		
		if(file.length == 0){
			ServletContextResource resource = new ServletContextResource(servletContext, "/resources/img/sin_imagen.jpg");
			file = IOUtils.toByteArray(resource.getInputStream());
		}
		
		return file;
	}
	
}
