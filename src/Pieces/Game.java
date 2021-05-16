package Pieces;
import java.awt.Color;
import java.util.Scanner;
import Pieces.Board;

public class Game 
{
	
	private static boolean bActive = true;
	private static boolean bGame = true;
	private static  Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.WHITE, Color.GRAY, Color.GREEN, Color.RED, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW };
	private static String[] colorNames = new String[] {"Black", "Blue", "Cyan", "White", "Gray", "Green", "Red", "Magenta", "Orange", "Pink", "Yellow"};
	
	/**
	 * Prompts the user to begin the game, change piece colors, and end the game
	 */
	public static void main(String[] args)
	{
		Scanner scInput = new Scanner(System.in);
		do
		{
			System.out.println("During the game enter 1 to begin new game");
	    	System.out.println("Enter 2 to customize piece color.");
	    	System.out.println("or enter 3 to exit.");
	    	int tester = scInput.nextInt();
	    	if(tester == 1)
	    	{
	    		Board chess = new Board();
	    		chess.setBoard();
	    	}
	    	
	    	else if(tester == 2)
	    	{
	    		for(int iCounter = 0; iCounter < colors.length; iCounter++)
	    		{
	    			System.out.println(iCounter + ": " + colorNames[iCounter]);
	    		}
	    		System.out.println("Please enter the number value of the Color for Player 1");
	    		Color player1 = colors[scInput.nextInt()];
	    		System.out.println("Please enter the number value of the Color for Player 2");
	    		Color player2 = colors[scInput.nextInt()];
	    		
	    		Board chess = new Board(player1, player2);
	    		chess.setBoard();
	    	}
	    	
	    	else
	    	{
	    		bActive = false;
	    	}
	    	
		}while(bActive);
	}
	
}
