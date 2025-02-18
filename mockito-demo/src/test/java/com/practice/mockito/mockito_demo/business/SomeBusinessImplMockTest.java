package com.practice.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		DataService dataServiceMock = mock(DataService.class);
		// dataServiceMock.retrieveAllData() => new int[] {25,15,5}
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 25, 15, 5 });

		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(25, someBusinessImpl.findTheGreatestFromAllData());
	}
	@Test
	void findTheGreatestFromAllData_withOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		// dataServiceMock.retrieveAllData() => new int[] {25,15,5}
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});

		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(35, someBusinessImpl.findTheGreatestFromAllData());
	}
}