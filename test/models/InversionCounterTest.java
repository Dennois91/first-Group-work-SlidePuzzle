package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InversionCounterTest {
	@Test
	@DisplayName("A list of numbers has a certain number of inversions.")
	void count() {
		// Given
		var inversionCounter = new InversionCounter();
		var listWithTenInversions = List.of(1,8,2,4,3,7,6,5);
		var listWithFortyOneInversions = List.of(13,2,10,3,1,12,8,4,5,9,6,15,14,11,7);
		var listWithZeroInversions = List.of(1,2,3,4,5,6,7,8,9);

		// When
		var tenInversions = inversionCounter.count(listWithTenInversions);
		var fortyOneInversions = inversionCounter.count(listWithFortyOneInversions);
		var zeroInversions = inversionCounter.count(listWithZeroInversions);

		// Then
		assertEquals(10, (int) tenInversions);
		assertEquals(41, (int) fortyOneInversions);
		assertEquals(0, (int) zeroInversions);
	}
}