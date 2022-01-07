package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @author Charlene Baes
 *
 * Tests the Outage class
 */

class OutageTest {

	/**
	 * Tests the who() method by testing an Outage Cell that should return Outage State
	 */
	@Test
	void testWho() 
	{
		Town t = new Town(1, 1);
		TownCell cell = new Outage(t, 0, 0);
		assertEquals(State.OUTAGE, cell.who());
	}
	
	/**
	 * Tests Outage rule, should become Empty
	 * @throws FileNotFoundException
	 */
	@Test
	void testNextEmpty() throws FileNotFoundException 
	{
		Town t = new Town("OutageTest.txt");
		TownCell cell = new Outage(t, 1, 1);
		assertEquals(State.EMPTY, cell.next(t).who());
	}

}
