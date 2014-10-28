package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app/filter")
public class FilterController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView filter(){
		
		ModelAndView mav = new ModelAndView("search");
		
		return mav;
	}
}
