package Pieces;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

abstract class Piece extends Critter
{
	protected abstract ArrayList<Location> listValidMoves();
	
	private static boolean player1Turn;
	private static boolean bCheckmate;
	private boolean bWhite;
	private Color cPlayer;
	
	/**
	 * Creates a new instance of the piece class
	 * @param bWhite parameter to set the piece color
	 */
	public Piece(boolean player1 , Color pPlayer)
	{
		player1Turn = true;
		bCheckmate = false;
		bWhite = player1;
		cPlayer = pPlayer;
		
		setColor(cPlayer);
	}
	
	/**
	 * returns boolean to indicate side
	 * @return true if player 1 piece false if player 2 piece
	 */
	public boolean getSide()
	{
		return bWhite;
	}
	
	/**
	 * Checks if the location is valid for a piece and is so moves; also calls check and check mate methods
	 * @param y the y coordinate
	 * @param x the x coordinate 
	 */
	public void move(int x, int y)
	{
		Grid<Actor> gr = getGrid();
		Location move = new Location ((x), (y)); 
		ArrayList<Location> occupied = gr.getOccupiedLocations();
		
		//removes any pieces that have been captured from the array list
		if(canMove(move))
		{
			if(bWhite)
			{
				ArrayList<Piece> pieces = Board.getBlackPieces();
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if(occupied.get(iCounter).equals(move))
					{
						for(int iCount = 0; iCount < pieces.size(); iCount++)
						{
							if(pieces.get(iCount).getLocation().equals(occupied.get(iCounter)))
							{
								if(iCount == (pieces.size() - 1))
								{
									bCheckmate = true;
								}
								pieces.remove(iCount);
							}
						}
					}
					
				}
				Board.setBlackPieces(pieces);
				player1Turn = false;
			}
			
			else
			{
				ArrayList<Piece> pieces = Board.getWhitePieces();
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if(occupied.get(iCounter).equals(move))
					{
						for(int iCount = 0; iCount < pieces.size(); iCount++)
						{
							if(pieces.get(iCount).getLocation().equals(occupied.get(iCounter)))
							{
								if(iCount == (pieces.size() - 1))
								{
									bCheckmate = true;
								}
								pieces.remove(iCount);
							}
						}
					}
					
				}
				Board.setWhitePieces(pieces);
				player1Turn = true;
			}
			
			moveTo(move);
			
			if(bCheckmate)
			{
				Board.checkmate(bWhite);
			}
			
			else
			{
				Board.check(bWhite);	
			}
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
		if (gr == null || !gr.isValid(space) || bCheckmate)
		{
			return false;
		}
		
		ArrayList<Location> moves = listValidMoves();
		for(int iCounter = 0; iCounter < moves.size(); iCounter++)
		{
			if (moves.get(iCounter).equals(space) && bWhite == player1Turn)
			{
				return true;
			}
		}
		return false;
	}
	
}