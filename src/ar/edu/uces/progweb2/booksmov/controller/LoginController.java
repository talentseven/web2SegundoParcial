package ar.edu.uces.progweb2.booksmov.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.booksmov.dto.UserDto;
import ar.edu.uces.progweb2.booksmov.model.User;
import ar.edu.uces.progweb2.booksmov.service.LoginService;
import ar.edu.uces.progweb2.booksmov.validator.UserValidator;

@Controller
@SessionAttributes("user")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String processLogin(ModelMap model){
		User user = (User) model.get("user");
		if(user == null){
			model.addAttribute("userDto", new UserDto());
		}
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processLogin(@ModelAttribute("userDto") UserDto userDto, BindingResult result, HttpServletRequest request){
		userValidator.validate(userDto, result);
		if(!result.hasErrors()){
			User user = loginService.getUserByEmail(userDto.getEmail());
			if(user != null){
				request.getSession().setAttribute("user", user);
				return "redirect:/app/search";
			}
		}
		return "login";
	}
}
