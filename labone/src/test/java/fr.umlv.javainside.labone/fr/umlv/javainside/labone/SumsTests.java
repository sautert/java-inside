package fr.umlv.javainside.labone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SumsTests {
	@Test
	public void tests() {
		assertEquals(950, Sums.loopSum(100));
		assertEquals(950, Sums.streamSum(100));
		assertEquals(3, Sums.loopSum(2));
		assertEquals(3, Sums.streamSum(2));
	}
}
