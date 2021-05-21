package Pieces;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class King extends Piece
{
	
	private final static int BOARDERSTART = 0;
	private final static int BOARDEREND = 7;
	
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 * @param c calls the parent class constructor
	 */
	public King(boolean b, Color c)
	{
		super (b, c);
	}
	
	/**
	 * Prints and returns all valid moves for the king piece at its given location
	 * @return
	 */
	public ArrayList<Location> listValidMoves()
	{
		info.gridworld.grid.Location current = getLocation();
		current.getCol();
		current.getRow();
		
		ArrayList<Actor> pieces = getGrid().getNeighbors(current);
		ArrayList<Location> moves = getMoveLocations();
		
		for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
		{
			//Makes sure that the king doesn't move off the board or take a piece of its own color
			if((pieces.get(iCounter).getLocation().getCol() < BOARDERSTART) || (pieces.get(iCounter).getLocation().getRow() > BOARDEREND) || (pieces.get(iCounter).getLocation().getCol() > BOARDEREND) || (pieces.get(iCounter).getLocation().getRow() < BOARDERSTART) || (pieces.get(iCounter).getColor().equals(this.getColor())))
			{
				
			}
			
			else
			{
				moves.add(pieces.get(iCounter).getLocation());
			}
		}
		
		System.out.println("Valid move locations are:");
		System.out.println(moves);
		return moves;
	}
	
}
