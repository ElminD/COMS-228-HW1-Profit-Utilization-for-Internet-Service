package edu.iastate.cs228.hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Elmin Didic
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//TODO: Write your code here.
		//double for loop to loop through the old town and update it in a new town
		for(int x = 0; x < tOld.getWidth(); x++)
		{
			for(int y = 0; y < tOld.getLength(); y++)
			{
				tNew.grid[x][y] = tOld.grid[x][y].next(tNew);
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
		//TODO: Write/update your code here.
		int C = 0;
		//double for loop to find all number of CASUAL

		for(int x = 0; x < town.getWidth(); x++) {
			for (int y = 0; y < town.getLength(); y++) {
					if(town.grid[x][y].who() == State.CASUAL)
					{
						C+=1;
					}
			}
		}


		return C;
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
	 * 
	 */
	public static void main(String []args) {
		//TODO: Write your code here.
		int UserInput;
		double Profit;
		final int BillingCycle = 12;


		Scanner scan = new Scanner(System.in);

		//ask user if they wanna use a file or update it randomly with a seed
		System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
		UserInput = scan.nextInt();
		Town t = null;

		if (UserInput == 1) {
			String filePath = "";
			try {

				//ask for file path and calls Town constructor with file updating
				System.out.println("Please Enter The File Name or Path!");
				scan.nextLine();
				filePath = scan.nextLine();

				File file = new File(filePath);
				t = new Town(filePath);
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Hey looks like you entered in a invalid file path!" + e.toString());
			}


		}

		if(UserInput == 2)
		{
			//ask for rows cols and the seed for random update and calls randomInit
			int seed;
			int row;
			int col;
			System.out.println("Enter Rows, Cols and the SEED! seperated by a space");
			row = scan.nextInt();
			col = scan.nextInt();
			seed = scan.nextInt();
			t = new Town(row,col);

			t.randomInit(seed);

		}

		double profit = 0.0;

		for(int month = 0; month < 12; month++)
		{

			//updates profit every month
			profit += (getProfit(t) / ((double)t.getWidth() * (double)t.getLength())) * 100;
			t = updatePlain(t);



		}
		profit = profit / 12;

		//prints out profit with correct formatting
		System.out.printf("%.2f%c",profit,'%');

	}
}
