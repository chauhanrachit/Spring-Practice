package com.practice.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.practice.learnspringaop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	
	private DataService1 dataService1;
	
	public BusinessService1(DataService1 dataService1) {
		this.dataService1 = dataService1;
	}

	public int calculateMax() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int[] data = dataService1.retrieveData();
		//throw new RuntimeException("Something Went wrong");
		return Arrays.stream(data).max().orElse(0);
	}
	
}
