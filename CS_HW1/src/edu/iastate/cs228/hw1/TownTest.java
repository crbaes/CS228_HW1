package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @author Charlene Baes
 *
 * Tests the Town Class
 *
 */

class TownTest {
	
	private Town t = new Town(4, 5);
	private Town t2 = new Town(4, 5);
	private Town t3 = new Town(2, 2);

	/**
	 * Test the getLength() method, should return 4
	 */
	@Test
	void testLength() 
	{
		assertEquals(4, t.getLength());
	}
	
	/**
	 * Test the getWidth() method, should return 5
	 */
	@Test
	void testWidth()
	{
		assertEquals(5, t.getWidth());
	}
	
	/**
	 * Test random init with two different seeds
	 * Should not be equal
	 */
	@Test
	void testRandomInit()
	{
		t.randomInit(10);
		t2.randomInit(15);
		assertNotEquals(t.toString(), t2.toString());
	}
	
	/**
	 * Test random init with two of the same seeds
	 * Should be Equal
	 */
	@Test
	void testRandomInit2()
	{
		t.randomInit(5);
		t2.randomInit(5);
		assertEquals(t.toString(), t2.toString());
	}
	
	/**
	 * Created a String and hardcoded it into a String and tested it to see if toString() was equal for the input file
	 * @throws FileNotFoundException
	 */
	@Test
	void testFile() throws FileNotFoundException
	{
		Town fileTown = new Town("ISP4x4.txt");
		String test = ("O R O R \nE E C O \nE S O S \nE O R R \n");
		assertEquals(test, fileTown.toString());
	}
	
	/**
	 * Created a String and hardcoded it into a String and tested it to see if toString() was equal
	 * @throws FileNotFoundException
	 */
	@Test
	void testToString()
	{	
		t3 = new Town(2, 2);
		t3.randomInit(2);
		String test = ("O C \nR C \n");
				
		assertEquals(test, t3.toString());
	}


}
