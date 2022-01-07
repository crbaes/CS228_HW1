package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @author Charlene Baes
 *
 * Tests the Reseller Class
 *
 */
class ResellerTest {

	/**
	 * Tests the who() method by testing a Reseller cell that should return as Reseller
	 */
	@Test
	void testWho() 
	{
		Town t = new Town(1, 1);
		TownCell cell = new Reseller(t, 0, 0);
		assertEquals(State.RESELLER, cell.who());
	}
	
	/**
	 * Tests rule 6B, should return Streamer
	 * @throws FileNotFoundException
	 */
	@Test
	void testNextEmpty() throws FileNotFoundException 
	{
		Town t = new Town("ResellerTest.txt");
		TownCell cell = new Reseller(t, 1, 1);
		assertEquals(State.STREAMER, cell.next(t).who());
	}

}
