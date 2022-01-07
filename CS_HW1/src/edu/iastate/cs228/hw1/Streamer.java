package edu.iastate.cs228.hw1;

/**
 * @author Charlene Baes
 *
 * The Streamer class is a subclass of TownCell that represents its current State
 * as well as the state that it will become using next()
 *
 */
public class Streamer extends TownCell
{

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	//Returns the State of the given TownCell
	public State who()
	{
		return State.STREAMER;
	}

	/**
	 * Determines the cell type in the next cycle
	 * 
	 * 6A: (Num Empty + Num Outage <= 1) converts to Reseller
	 * 2A: Reseller > 0, converts to Outage
	 * 2B: Outage > 0, converts to Empty
	 * 
	 * if !rules, any cell >= 5 casual neighbors converts to streamer
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	@Override
	public TownCell next(Town tNew) 
	{
		TownCell newCell = new Empty(tNew, row, col);
		newCell.census(nCensus);
		
		//6A: (Num Empty + Num Outage <= 1) converts to Reseller
		if(nCensus[1] + nCensus[3] <= 1)
			newCell = new Reseller(tNew, row, col);
	
		//2A: Reseller > 0, converts to Outage
		else if(nCensus[0] > 0)
			newCell = new Outage(tNew, row, col);
		
		//2B: Outage > 0, converts to Empty
		else if(nCensus[3] > 0)
			newCell = new Empty(tNew, row, col);
		
		//if !rules, any cell >5 casual neighbors converts to streamer
		//regardless, Streamer will stay Streamer
		else
			newCell = new Streamer(tNew, row, col);
		
		return newCell;
	}
}
