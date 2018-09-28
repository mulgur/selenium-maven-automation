package june30;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class AssertStepFails {
	
	@Test
	public void test1() {
		int n = 10; 
		int k = 5;
		
		assertEquals(n,k);
		System.out.println("next step in test1");
		assertTrue(n>k);
		
	}
	
	@Test
	public void test2() {
		int n = 10; 
		int k = 5;
		
		assertNotEquals(n,k);
		System.out.println("next step in test1");
		assertTrue(n>k);
		
		
	}

}
