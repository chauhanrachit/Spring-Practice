package com.practice.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
public class SayHelloController {
	
	//"say-hello" =>"Hello! What are you learning today?"
	//say-hello
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My HTML Page Title</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My HTML Page with body");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	}
	
	//say-hello-jsp => say-hello.jsp
	//myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	//@ResponseBody  //this will return whatever is written directly,So, as we want to redirect to a view (JSP), we will remove it.
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
	
	
	
}
