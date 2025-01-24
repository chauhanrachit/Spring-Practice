package com.practice.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	
	private MyMath math = new MyMath();
	
	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}
	
	@Test
	void calculateSum_ThreeMemberArray() {
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
		//fail("Not yet implemented");
		//Absence of Failure is Success
		//We write Test Condition or Asserts checking for certain behavior
		//And only if one of these asserts fail, our JUnit test would fail
	}
}