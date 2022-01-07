package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @author Charlene Baes
 *
 * Tests the Streamer Class
 *
 */
class StreamerTest {

	/**
	 * Tests the state of Streamer cell, which should return Streamer
	 */
	@Test
	void testWho() 
	{
		Town t = new Town(1, 1);
		TownCell cell = new Streamer(t, 0, 0);
		assertEquals(State.STREAMER, cell.who());
	}

	/**
	 * Tests the rule 6A, should become RESELLER
	 * @throws FileNotFoundException
	 */
	@Test
	void testNextEmpty() throws FileNotFoundException 
	{
		Town t = new Town("StreamerTest.txt");
		TownCell cell = new Streamer(t, 1, 1);
		assertEquals(State.RESELLER, cell.next(t).who());
	}
}
