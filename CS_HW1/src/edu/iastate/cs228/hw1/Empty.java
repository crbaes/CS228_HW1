package edu.iastate.cs228.hw1;

/**
 * @author Charlene Baes
 *
 * The Empty class is a subclass of TownCell that represents its current State
 * as well as the state that it will become using next()
 *
 */
public class Empty extends TownCell
{

	public Empty(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	public State who()
	{
		return State.EMPTY;
	}

	/**
	 * Determines the cell type in the next cycle
	 * 
	 * 6A: (Num Empty + Num Outage <= 1) converts to Reseller
	 * 5A Empty converts to Casual
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
		
		//5A Empty converts to Casual
		else
			newCell = new Casual(tNew, row, col);

		return newCell;
	}
}
