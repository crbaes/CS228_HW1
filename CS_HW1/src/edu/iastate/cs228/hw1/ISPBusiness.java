package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Charlene Baes
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness 
{
	protected static double totalProfit = 0; //keeps track of the total profit for the whole entire year
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) 
	{
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		
		
		for(int i = 0; i < tOld.getLength(); i++)
		{
			for(int j = 0; j < tOld.getWidth(); j++)
			{
				tNew.grid[i][j] = tOld.grid[i][j].next(tOld);
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int profitMonth = 0;
		for(int i = 0; i < town.getLength(); i++)
		{
			for(int j = 0; j < town.getWidth(); j++)
			{
				if(town.grid[i][j].who() == State.CASUAL) //profit++ if there is a CASUAL State in the grid
					profitMonth++;
			}
		}
		
		return profitMonth;
		
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 * 
	 */
	public static void main(String []args) throws FileNotFoundException {
		
		Scanner scnr = new Scanner(System.in);
		Town t = null;
		int i = 0;
		int totalProfit = 0;
		
		System.out.println("How would you like to populate the grid (type 1 or 2)? 1: from a file 2: randomly with a seed");
		
		if(scnr.nextInt() == 2)
		{
			System.out.println("Provide the number of rows, columns, and seed integer separated by a space: ");
			
			int row = scnr.nextInt();
			int col = scnr.nextInt();
			int seed = scnr.nextInt();
			t = new Town(row, col);
			t.randomInit(seed);

		}
		else
		{
			System.out.println("Provide the file name: ");	
			t = new Town(scnr.next());
		}
		
		while(i < 12)
		{
			t = updatePlain(t);
			totalProfit += getProfit(t);
			i++;
		}
		
		double yearlyProfit = 100 * (totalProfit / (double)(t.getLength() * t.getWidth() * 12));
		System.out.print("Profit: ");
		System.out.print(String.format("%,.2f", yearlyProfit));
		System.out.print("%");
		
		scnr.close();
	}
}
