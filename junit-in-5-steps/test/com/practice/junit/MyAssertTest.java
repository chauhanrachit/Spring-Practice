package com.practice.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("AWS","DevOps","Azure");
	
	@Test
	void test() {
		
		boolean test = todos.contains("AWS");
		boolean test2 = todos.contains("GCP");
		
		//assertEquals(true, test);
		assertTrue(test);
		assertFalse(test2);
		
		//assertNull, assertNotNull(todos);
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
		
		assertEquals(3, todos.size());
	}

}
