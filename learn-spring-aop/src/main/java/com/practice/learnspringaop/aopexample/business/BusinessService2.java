package com.practice.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.practice.learnspringaop.aopexample.data.DataService2;

@Service
public class BusinessService2 {
	
	private DataService2 dataService2;
	
	public BusinessService2(DataService2 dataService2) {
		this.dataService2 = dataService2;
	}

	public int calculateMin() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int[] data = dataService2.retrieveData();
		//throw new RuntimeException("Something Went wrong");
		return Arrays.stream(data).min().orElse(0);
	}
	
}
