package com.practice.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		//When we want to do filtering according to the API, we cant define the filtering logic directly on the bean, 
		//we have to define the logic to filter in the rest API, for which we use -
		//MappingJacksonValue
		
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		MappingJacksonValue mappingJacksonValue = extracted(someBean,new String[]{"field1","field3"});
		
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {

		List<SomeBean> beanList = Arrays.asList( new SomeBean("value1","value2","value3"),
				new SomeBean("value11","value22","value33"),new SomeBean("value111","value222","value333"));
		
		MappingJacksonValue mappingJacksonValue = extracted(beanList,new String[]{"field2","field3"});
		
		return mappingJacksonValue;
	}
	
	private MappingJacksonValue extracted(Object someBean, String[] arr) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept(arr);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}

