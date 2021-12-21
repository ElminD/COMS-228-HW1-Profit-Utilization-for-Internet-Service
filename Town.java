package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Elmin Didic
 *
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
	public Town(int width, int length) {

		//Creating variables using @param length and @param width
		this.length = width;
		this.width = length;

		//creating a new TownCell using @Param
		grid = new TownCell[width][length];

	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {

		//Creates a new File using @param inputFileName
		File file = new File(inputFileName);

		//Creates a try catch for FileNotFoundException
		try {
			Scanner scan = new Scanner(file);
			this.width = scan.nextInt();
			this.length = scan.nextInt();

			grid = new TownCell[width][length];
			//while the files keep having new lines
			while(scan.hasNextLine())
			{
				//loops the grid and updates based on file
				for(int x = 0; x < width; x++)
				{
					for(int y = 0; y < length; y++)
					{
						switch(scan.next()) {
							case "C":
								grid[x][y] = new Casual(this, x, y);
								break;

							case "S":
								grid[x][y] = new Streamer(this,x,y);
								break;

							case "R":
								grid[x][y] = new Reseller(this, x, y);
								break;

							case "E":
								grid[x][y] = new Empty(this,x,y);
								break;

							case "O":
								grid[x][y] = new Outage(this,x,y);
								break;
						}
					}
				}
			}

			scan.close();



		}
		catch(FileNotFoundException e) {
			System.out.println("Hey looks like you entered in a invalid file path!" + e.toString());
		}






	}

	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		//TODO: Write your code here.

		//double for loop and a switch statement with cases of STATE to create a new object
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < length; y++)
			{
				int randval = rand.nextInt(5);
				switch(randval) {
					case TownCell.CASUAL:
						grid[x][y] = new Casual(this, x, y);
						break;

					case TownCell.STREAMER:
						grid[x][y] = new Streamer(this,x,y);
						break;

					case TownCell.RESELLER:
						grid[x][y] = new Reseller(this, x, y);
						break;

					case TownCell.EMPTY:
						grid[x][y] = new Empty(this,x,y);
						break;

					case TownCell.OUTAGE:
						grid[x][y] = new Outage(this,x,y);
						break;
				}
			}
		}


	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		//TODO: Write your code here.
		//nested for loop, grid.who.toString.charAt(0)
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < length; y++)
			{
				//s += this.grid[x][y].who().toString().charAt(0) + " ";
				s += grid[x][y].who().toString().charAt(0) + " ";
			}
			s += "\n";

		}


		return s;
	}

}
