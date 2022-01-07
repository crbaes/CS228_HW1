package edu.iastate.cs228.hw1;

/**
 * @author Charlene Baes
 *
 * The Casual class is a subclass of TownCell that represents its current State
 * as well as the state that it will become using next()
 *
 */
public class Casual extends TownCell
{
	public Casual(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	public State who()
	{
		return State.CASUAL;
	}

	/**
	 * Determines the cell type in the next cycle
	 * 
	 * 6A: (Num Empty + Num Outage <= 1) converts to Reseller
	 * 1A any Resellers in neighborhood, convert to Outage
	 * 1B any Streamer neighbors, convert to Streamer
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
		
		//1A any Resellers in neighborhood, convert to Outage
		else if(nCensus[0] > 0)
			newCell = new Outage(tNew, row, col);
		
		//1B any Streamer neighbors, convert to Streamer
		else if(nCensus[4] > 0)
			newCell = new Streamer(tNew, row, col);
		
		//if !rules, any cell >= 5 casual neighbors converts to streamer
		else if(nCensus[2] >= 5)
			newCell = new Streamer(tNew, row, col);
		
		else
			newCell = new Casual(tNew, row, col);
		
		
		return newCell;
	}
}
