
package com.practice.springboot.myfirstwebapp.login;

//@Controller
//@SessionAttributes("name")
public class LoginController {	
//	private AuthenticationService auth;
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	
//	public LoginController(AuthenticationService auth) {
//		super();
//		this.auth = auth;
//	}
//
//	//login
//	//GET,POST both are being handled by this method, if we want it to only handle GET method---
//	@RequestMapping(value="login",method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
//	
//	@RequestMapping(value="login",method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
//		if(auth.authenticate(name, password)){
//			model.put("name", name);
//			//model.put("password", password);
//			logger.debug("Name - {} , Password - {}",name,password);
//			return "welcome";
//		}
//		model.put("errorMessage", "Invalid Credentials! Please Try Again");
//		return "login";
//	}
}