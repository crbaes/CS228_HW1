package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @author Charlene Baes
 *
 * Tests the ISPBusiness Class
 *
 */
class ISPBusinessTest {

	/**
	 * Tests get profit for a 4x4 Town of Casuals, that should return 16
	 * @throws FileNotFoundException
	 */
	@Test
	void testGetProfit() throws FileNotFoundException 
	{
		Town t = new Town("ISPTest.txt");
		assertEquals(16, ISPBusiness.getProfit(t));
	}

	/**
	 * Tests the first and second iteration of ISP4x4.txt to see if updatePlain() updates the new and old towns
	 * @throws FileNotFoundException
	 */
	@Test
	void testUpdatePlain() throws FileNotFoundException 
	{
		Town t = new Town("ISP4x4.txt");
		Town t2 = new Town("ISP4x42nd.txt");
		assertEquals(t2.toString(), (ISPBusiness.updatePlain(t)).toString());
	}
	
}
