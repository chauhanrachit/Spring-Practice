package com.practice.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService auth;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public LoginController(AuthenticationService auth) {
		super();
		this.auth = auth;
	}

	//login
	//GET,POST both are being handled by this method, if we want it to only handle GET method---
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
		if(auth.authenticate(name, password)){
			model.put("name", name);
			//model.put("password", password);
			logger.debug("Name - {} , Password - {}",name,password);
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials! Please Try Again");
		return "login";
	}
}