package Pieces;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Knight extends Piece
{
	
	private final static int BOARDERSTART = 0;
	private final static int BOARDEREND = 7;
	private final static int LONGMOVE = 2;
	private final static int SHORTMOVE = 1;
	
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 * @param c calls the parent class constructor
	 */
	public Knight(boolean b, Color c)
	{
		super (b, c);
	}
	
	/**
	 * gets all valid moves for the knight piece
	 */
	public ArrayList<Location> listValidMoves()
	{
		Grid<Actor> gr = getGrid();
		info.gridworld.grid.Location current = getLocation();
		int col = current.getCol();
		int row = current.getRow();
		ArrayList<Location> moves = new ArrayList<Location>();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		ArrayList<Location> occupied = gr.getOccupiedLocations();
		boolean bFriendly;
		
		moves.add(new Location(row + LONGMOVE, col + SHORTMOVE));
		moves.add(new Location(row + SHORTMOVE, col + LONGMOVE));
		moves.add(new Location(row - LONGMOVE, col + SHORTMOVE));
		moves.add(new Location(row - SHORTMOVE, col + LONGMOVE));
		moves.add(new Location(row - LONGMOVE, col - SHORTMOVE));
		moves.add(new Location(row - SHORTMOVE, col - LONGMOVE));
		moves.add(new Location(row + LONGMOVE, col - SHORTMOVE));
		moves.add(new Location(row + SHORTMOVE, col - LONGMOVE));
		
		//loops through all 8 potential locations
		for (int iCounter = 0; iCounter < moves.size(); iCounter++)
		{
			bFriendly = false;
			//check that each move is within the boundary of the board
			if(moves.get(iCounter).getRow() <= BOARDEREND && moves.get(iCounter).getRow() >= BOARDERSTART && moves.get(iCounter).getCol() <= BOARDEREND && moves.get(iCounter).getCol() >= BOARDERSTART)
			{
				//flags if a move is going to take a piece of the same color
				for(int iCount = 0; iCount < occupied.size(); iCount++)
				{
					if(occupied.get(iCount).equals(moves.get(iCounter)) && gr.get(occupied.get(iCount)).getColor().equals(this.getColor()))
					{
						bFriendly = true;
					}
				}
				//adds the move to the valid list if in board and empty or opposing piece
				if(!bFriendly)
				{
					validMoves.add(moves.get(iCounter));
				}
			}
		}
		System.out.println("Valid move locations are:");
		System.out.println(validMoves);
		
		return validMoves;
	}
	
}