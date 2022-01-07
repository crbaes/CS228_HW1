package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 * @author Charlene Baes
 *
 * Tests the TownCell class
 *
 */
class TownCellTest {
	
	/**
	 * Tests who() method by looking at Empty cell that should return Empty
	 * @throws FileNotFoundException
	 */
	@Test
	void testWho1() throws FileNotFoundException 
	{
		Town t = new Town("ISP4x4.txt");
		assertEquals(State.EMPTY, t.grid[1][1].who());
	}
	
	/**
	 * Tests who() method by looking at Reseller cell that should return Reseller
	 * @throws FileNotFoundException
	 */
	@Test
	void testWho2() throws FileNotFoundException 
	{
		Town t = new Town("ISP4x4.txt");
		assertEquals(State.RESELLER, t.grid[3][3].who());
	}
	
	/**
	 * Tests Census by counting the neighbors of the Streamer cell in ISP4x4.txt
	 * @throws FileNotFoundException
	 */
	@Test
	void testCensus() throws FileNotFoundException 
	{
		Town t = new Town("ISP4x4.txt");
		TownCell cell = new Streamer(t, 2, 2);
		cell.census(TownCell.nCensus);
		
		assertEquals(2, TownCell.nCensus[0]);
		assertEquals(1, TownCell.nCensus[1]);
		assertEquals(1, TownCell.nCensus[2]);
		assertEquals(2, TownCell.nCensus[3]);
		assertEquals(2, TownCell.nCensus[4]);
	}
	
	/**
	 * Tests Census by counting the neighbors of the Outage cell in ISP4x4.txt
	 * @throws FileNotFoundException
	 */
	@Test
	void testCensus2() throws FileNotFoundException 
	{
		Town t = new Town("ISP4x4.txt");
		TownCell cell = new Outage(t, 0, 0);
		cell.census(TownCell.nCensus);
		
		assertEquals(TownCell.nCensus[0], 1);
		assertEquals(TownCell.nCensus[1], 2);
		assertEquals(TownCell.nCensus[2], 0);
		assertEquals(TownCell.nCensus[3], 0);
		assertEquals(TownCell.nCensus[4], 0);
	}
	
	/**
	 * Tests Census by counting the neighbors of the Outage cell in ISP4x4.txt
	 * @throws FileNotFoundException
	 */
	@Test
	void testCensus3() throws FileNotFoundException 
	{
		Town t = new Town("ISP4x4.txt");
		TownCell cell = new Outage(t, 1, 0);
		cell.census(TownCell.nCensus);
		
		assertEquals(TownCell.nCensus[0], 1);
		assertEquals(TownCell.nCensus[1], 2);
		assertEquals(TownCell.nCensus[2], 0);
		assertEquals(TownCell.nCensus[3], 1);
		assertEquals(TownCell.nCensus[4], 1);
	}

}
