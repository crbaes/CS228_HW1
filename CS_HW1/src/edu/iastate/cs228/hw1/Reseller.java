package edu.iastate.cs228.hw1;

/**
 * @author Charlene Baes
 *
 * The Reseller class is a subclass of TownCell that represents its current State
 * as well as the state that it will become using next()
 *
 */
public class Reseller extends TownCell
{
	
	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	public State who()
	{
		return State.RESELLER;
	}

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	@Override
	public TownCell next(Town tNew) 
	{
		TownCell newCell = new Empty(tNew, row, col);
		newCell.census(nCensus);
		
		//3A Casual <= 3 converts to Empty
		if(nCensus[2] <= 3)
			newCell = new Empty(tNew, row, col);
		
		//3B Empty >= 3 converts to Empty
		else if(nCensus[1] >= 3)
			newCell = new Empty(tNew, row, col);
		
		//6B 5 or more casual, converts to Streamer
		else if(nCensus[2] >= 5)
			newCell = new Streamer(tNew, row, col);
		
		else
			newCell = new Reseller(tNew, row, col);
		
		return newCell;
		
	}
}
