package com.practice.mockito.mockito_demo.business;

public class SomeBusinessImpl {

	private DataService dataService;
	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
	}
}

interface DataService{
	int[] retrieveAllData();
}