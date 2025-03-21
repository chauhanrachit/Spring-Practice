package com.practice.learnspringaop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.learnspringaop.aopexample.business.BusinessService1;
import com.practice.learnspringaop.aopexample.business.BusinessService2;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	
	//To make use of the spring beans we created (BussinessService1, DataService1) we will use Command Line Runner
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private BusinessService1 businessService1 ;
	private BusinessService2 businessService2 ;
	
	public LearnSpringAopApplication (BusinessService1 businessService1 , BusinessService2 businessService2){
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value returned is {}" , businessService1.calculateMax());
		logger.info("Value returned is {}" , businessService2.calculateMin());
	}

}
