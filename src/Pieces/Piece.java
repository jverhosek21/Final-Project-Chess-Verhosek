package Pieces;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

abstract class Piece extends Critter
{
	protected abstract ArrayList<Location> listValidMoves();
	
	private boolean bWhite;
	private Color cPlayer;
	
	/**
	 * Creates a new instance of the piece class
	 * @param bWhite parameter to set the piece color
	 */
	public Piece(boolean player1 , Color pPlayer)
	{
		bWhite = player1;
		cPlayer = pPlayer;
		
		setColor(cPlayer);
	}
	
	public boolean getSide()
	{
		return bWhite;
	}
	
	/**
	 * Checks if the location is valid for a piece and is so moves 
	 * @param y the y coordinate
	 * @param x the x coordinate 
	 */
	public void move(int x, int y)
	{
		Location move = new Location ((x), (y)); 
		
		if(canMove(move))
		{
			moveTo(move);
			Board.check(bWhite);
		}
		
		else
		{
			System.out.println("Invalid Move");
		}	
		
	}
	
	/**
	 * checks if the piece can move to the given location
	 * @param space the given location
	 * @return returns true if possible and false if not
	 */
	public boolean canMove(Location space)
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
		{
			return false;
		}
		
		if(!gr.isValid(space))
		{
			return false;
		}
		
		ArrayList<Location> moves = listValidMoves();
		for(int iCounter = 0; iCounter < moves.size(); iCounter++)
		{
			if (moves.get(iCounter).equals(space))
			{
				return true;
			}
		}
		return false;
	}
	
}