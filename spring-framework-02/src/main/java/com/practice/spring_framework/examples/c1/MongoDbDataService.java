package com.practice.spring_framework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MongoDbDataService implements DataService {

	@Override
	public int[] retreiveData() {
		return new int[] { 11 , 22 , 33 , 44 , 55 };
	}

}
