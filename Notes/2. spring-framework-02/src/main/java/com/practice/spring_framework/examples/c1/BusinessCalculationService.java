package com.practice.spring_framework.examples.c1;

import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class BusinessCalculationService {
	
	private DataService dataService;
	
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	} 

	public int findMax() {
		return Arrays.stream(dataService.retreiveData()).max().orElse(0);
	}
}