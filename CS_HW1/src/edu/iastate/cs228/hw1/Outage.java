package edu.iastate.cs228.hw1;

/**
 * @author Charlene Baes
 *
 * The Outage class is a subclass of TownCell that represents its current State
 * as well as the state that it will become using next()
 *
 */
public class Outage extends TownCell
{
	public Outage(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	public State who()
	{
		return State.OUTAGE;
	}
	
	/**
	 * Determines the cell type in the next cycle
	 * 
	 * 4A: Outage converts to Empty 
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	@Override
	public TownCell next(Town tNew) 
	{
		TownCell newCell = new Empty(tNew, row, col);
		newCell.census(nCensus);

		return newCell;
	}

}
