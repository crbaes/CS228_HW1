package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @author Charlene Baes
 *
 * Tests the Casual Class
 *
 */
class CasualTest {

	/**
	 * Tests the who() method by looking at a Casual cell that should return Casual
	 */
	@Test
	void testWhoCasual() 
	{
		Town t = new Town(1, 1);
		TownCell cell = new Casual(t, 0, 0);
		assertEquals(State.CASUAL, cell.who());
	}
	
	/**
	 * Tests a casual cell that should return Casual
	 */
	@Test
	void testWhoCasual2() 
	{
		Town t = new Town(1, 1);
		TownCell cell = new Casual(t, 0, 0);
		assertEquals(State.CASUAL, cell.who());
	}
	
	/**
	 * Tests rule 1A that should return Casual to Outage
	 * @throws FileNotFoundException
	 */
	@Test
	void testNext() throws FileNotFoundException 
	{
		Town t = new Town("CasualTestText");
		TownCell cell = new Casual(t, 1, 1);
		assertEquals(State.OUTAGE, cell.next(t).who());
	}
}
