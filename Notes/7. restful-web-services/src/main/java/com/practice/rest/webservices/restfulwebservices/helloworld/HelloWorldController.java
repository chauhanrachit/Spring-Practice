package com.practice.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//1 To Expose Rest API
@RestController
public class HelloWorldController {

	// 2 To give a specific URL to this API, Ex - /hello-world
	// 3 If someone types this URL, we want to return "Hello World" back

	// @RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	// path parameters
	// /users/{id}/todos/{id} = > /users/2/todos/200
	// /hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		// return new HelloWorldBean("Hello "+name) ;
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {

		Locale locale = LocaleContextHolder.getLocale();
//		Return the Locale associated with the current thread, if any,or the system default Locale otherwise. 
//		This is effectively a replacement for java.util.Locale.getDefault(),
//		able to optionally respect a user-level Locale setting. 
		System.out.println("Current Locale: " + locale);
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

		// return "Hello World" ;

//		1: Define these messages somewhere, so that we can pick them up   //good.morning.message
//		2: Write the code to pick those values up
//		Example: en - English (Good Morning)
//		Example: nl - Dutch (Goedemorgen)
//		Example: fr - French (Bonjour)
//		Example: de - Deutsh (Guten Morgen)
	}

}
