package com.practice.spring_framework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	private DataService dataService;
	
	public DataService getDataService() {
		return dataService;
	}

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
}

//@Component
@Named
class DataService {
	
}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	
	
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
			//context.getBean(GamingConsole.class).up();
			//context.getBean(GameRunner.class).run();
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println(context.getBean(BusinessService.class).getDataService());
		} 
	}
}