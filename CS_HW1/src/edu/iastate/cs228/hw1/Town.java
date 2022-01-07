package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;



/**
 *  @author Charlene Baes
 * The Town Class can be represented by a 2D array of TownCells, called grid. 
 * Town Class keeps track of the length and width of the given grid
 * 
 * The Town Class is where the Towns are constructed either by a file or randomly, and it also converts the Towns to Strings in order to display
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) 
	{
		grid = new TownCell[length][width];
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException 
	{
		java.net.URL url = getClass().getResource(inputFileName); //find the absolute file path of the given file
		File file = new File(url.getPath()); //create a new file using the absolute file path
		Scanner scnr = new Scanner(file); 
		
		length = scnr.nextInt();            
		width = scnr.nextInt();
		
		grid = new TownCell[length][width];
		
		/**
		 * Iterate through each grid index and create a new TownCell depending on the Scanner's input
		 */
		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < width; j++)
			{
				String str = scnr.next();
				
				if(str.equals("S"))
					grid[i][j] = new Streamer(this, i, j);
				if(str.equals("O"))
					grid[i][j] = new Outage(this, i, j);
				if(str.equals("C"))
					grid[i][j] = new Casual(this, i, j);
				if(str.equals("R"))
					grid[i][j] = new Reseller(this, i, j);
				if(str.equals("E"))
					grid[i][j] = new Empty(this, i, j);
			}
		}
		scnr.close();
	}

	/**
	 * Returns width of the grid.
	 * @return width of grid
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return length of grid
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 * 
	 * Creates new State objects within the grid corresponding with static int indicators
	 * 
	 * Assign random States for each grid index by using random generator of numbers 0-4
	 */
	public void randomInit(int seed) 
	{
		Random rand = new Random(seed);
		
		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < width; j++)
			{
				int num = rand.nextInt(5);
				
				if(num == 0)
					grid[i][j] = new Reseller(this, i, j);
				else if(num == 1)
					grid[i][j] = new Empty(this, i, j);
				else if(num == 2)
					grid[i][j] = new Casual(this, i, j);
				else if(num == 3)
					grid[i][j] = new Outage(this, i, j);
				else
					grid[i][j] = new Streamer(this, i, j);
			}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 * 
	 * @return string containing each index of the grid and its State's first letter 
	 * i.e. Casual -> C
	 */
	@Override
	public String toString() 
	{
		String returnString = "";
		
		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < width; j++)
			{
				String type = (grid[i][j].who()).toString();
				returnString += type.substring(0,1) + " ";
			}
			returnString += "\n";
		}
		
		
		return returnString;
	}
}
