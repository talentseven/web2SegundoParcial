package ar.edu.uces.progweb2.booksmov.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app/logout")
public class LogoutController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String logout(HttpSession session){
		
		session.invalidate();
		return "index";
	}
}
