package exercises2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsTest {
	
	@Test
	public void testProductSimple() {
		
		assertEquals(6, Digits.product(123));
		assertEquals(8, Digits.product(222));
		assertEquals(28, Digits.product(74));
		
		assertEquals(1, Digits.product(111111111));
		
		assertNotEquals(6, Digits.product(1234));
	}
	
	@Test
	public void testProductZero() {
		assertEquals(0, Digits.product(250346675));
		assertEquals(0, Digits.product(0));
		assertNotEquals(0, Digits.product(71));
	}
	
//	@Test
//	public void testProductMaximum() {
//		int bigNumber = 1999999999;
//		assertEquals((int)Math.pow(9, String.valueOf(bigNumber).length()), Digits.product(bigNumber));
//		
//		System.out.format("%.0f is not the same as %d!",
//				Math.pow(9, String.valueOf(bigNumber).length()), Digits.product(bigNumber));
//	}
//	
	@Test
	public void testProductNegative() {
		assertEquals(10, Digits.product(-25));
		assertEquals(6, Digits.product(-123));
		assertEquals(72, Digits.product(-89));
	}
	
	
	@Test
	public void testProductNull() {
		assertEquals(0, Digits.product(null));
	}


}
