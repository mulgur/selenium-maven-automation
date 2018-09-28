package july21_calculator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

public class CalculatorTest {
	/*
	 * Restaurant application
	 * should list all of the menu
	 * fries costs 1
	 * coke costs 2
	 * pizza costs 3
	 * 
	 * customers should be able to create an order
	 * the system should calculate the total price for an order
	 * every other fries is free
	 * 
	 * -----------------------------------
	 * 
	 * Giver customers order pizza and fries
	 * When then calculate the total
	 * Then the system should generate the total price
	 * 
	 * Three amigos
	 * 
	 * PO
	 * dev
	 * qa
	 * 
	 * ----------------
	 * BDD -> behaviour driver development
	 */
	
	@Test
	public void menu() {
		Menu menu = new Menu();
		assertNotNull(menu);


	}
	
	
	
	@Test
	public void priceTest() {
		Menu menu = new Menu();
		assertEquals(menu.fries, 1);
		assertEquals(menu.coke, 2);
		assertEquals(menu.pizza, 3);

	}
	
	@Test
	public void orderTest() {
		Menu menu = new Menu();
		List<Integer> order = menu.createOrder("pizza", "fries");
		
		
		assertNotNull(order);
		

		
	}
	
	

}
