package com.practice.spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	
//	Field-based Dependency Injection(DI)-
//	@Autowired
//	Dependency1 dependency1;
//	@Autowired
//	Dependency2 dependency2;
	
	Dependency1 dependency1;
	Dependency2 dependency2;
	
//	Constructor-based DI -- 
//	@Autowired not required in Constructor-based DI 
//	recommended by Spring team among the 3 types of DI
//	As dependencies as automatically set when an object is created
//	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
//	Setter-based DI 
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2 ;
	}
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	
	
	public static void main(String[] args) {
		//System.out.println("aaaa");
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
			//context.getBean(GamingConsole.class).up();
			//context.getBean(GameRunner.class).run();
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class).toString());
		} 
	}
}