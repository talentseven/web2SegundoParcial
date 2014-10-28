package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.progweb2.booksmov.service.ImageService;

@Controller
@RequestMapping("/app/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/book/{isbn}", method=RequestMethod.GET)
	@ResponseBody
	public byte[] getBookImage(@PathVariable("isbn") String isbn){
		return imageService.getBookImageFromDb(isbn);
	}
	
	@RequestMapping(value="/movie/{isan}", method=RequestMethod.GET)
	@ResponseBody
	public byte[] getMovieImage(@PathVariable("isan") String isan){
		return imageService.getMovieImageFromDb(isan);
	}
}
