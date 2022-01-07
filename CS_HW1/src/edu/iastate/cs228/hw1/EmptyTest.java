package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 * @author Charlene Baes
 *
 * Tests Empty Class
 *
 */
class EmptyTest {

	@Test
	void testWhoEmpty() 
	{
		Town t = new Town(1, 1);
		TownCell cell = new Empty(t, 0, 0);
		assertEquals(State.EMPTY, cell.who());
	}
	
	@Test
	void testNextEmpty() throws FileNotFoundException 
	{
		Town t = new Town("EmptyTest.txt");
		TownCell cell = new Empty(t, 1, 1);
		assertEquals(State.CASUAL, cell.next(t).who());
	}
}
