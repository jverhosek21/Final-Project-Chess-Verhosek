package Pieces;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Queen extends Piece
{
	
	private final static int BOARDERSTART = 0;
	private final static int BOARDEREND = 7;
	
	public static final int NORTH = 0;
	/**
	 * The compass direction for northeast.
	 */
	public static final int NORTHEAST = 45;
	/**
	 * The compass direction for east.
	 */
	public static final int EAST = 90;
	/**
	 * The compass direction for south east.
	 */
	public static final int SOUTHEAST = 135;
	/**
	 * The compass direction for south.
	 */
	public static final int SOUTH = 180;
	/**
	 * The compass direction for south west.
	 */
	public static final int SOUTHWEST = 225;
	/**
	 * The compass direction for west.
	 */
	public static final int WEST = 270;
	/**
	 * The compass direction for northwest.
	 */
	public static final int NORTHWEST = 315;

	
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 * @param c calls the parent class constructor
	 */
	public Queen(boolean b, Color c)
	{
		super (b, c);
	}
	
	/**
	 * combines all possible move locations into an arrayList 
	 * @return all move locations
	 */
	public ArrayList<Location> listValidMoves()
	{
		ArrayList<Location> moves =  new ArrayList<Location>();
		moves.addAll(getSides(NORTH));
		moves.addAll(getSides(SOUTH));
		moves.addAll(getSides(WEST));
		moves.addAll(getSides(EAST));
		moves.addAll(getSides(NORTHEAST));
		moves.addAll(getSides(NORTHWEST));
		moves.addAll(getSides(SOUTHEAST));
		moves.addAll(getSides(SOUTHWEST));
		
		System.out.println("Valid move locations are:");
		System.out.println(moves);
		
		return moves;
				
	}
	
	/**
	 * gets all of the vertical/horizontal locations of the direction determined by the parameters until there is a piece in the way or the edge of the board
	 * @param direction the direction of the locations that will be returned
	 * @return array list of locations
	 */
	public ArrayList<Location> getSides(int direction)
	{
		Grid<Actor> gr = getGrid();
		info.gridworld.grid.Location current = getLocation();
		ArrayList<Location> occupied = gr.getOccupiedLocations();
		ArrayList<Location> moves = new ArrayList<Location>();
		boolean bPiece = false;
		Location newLoc = current;
		Location oldLoc = current;
		
		while(!bPiece)
		{
			newLoc = oldLoc.getAdjacentLocation(direction);
			for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
			{
				//Checks if the locations it is adding have gone off the board's boundaries or reached an occupied location, and if do stops
				if(newLoc.equals(occupied.get(iCounter)) || newLoc.getRow() < BOARDERSTART || newLoc.getRow() > BOARDEREND || newLoc.getCol() < BOARDERSTART || newLoc.getCol() > BOARDEREND)
				{
					bPiece = true;
					iCounter = occupied.size();
				}
			}
			
			// adds next location
			if(!bPiece)
			{
				moves.add(newLoc);
			}
			
			//checks if the there is a occupied location with an opposing piece next, and if so adds it
			else
			{
				ArrayList<Actor> pieces = gr.getNeighbors(oldLoc);
				for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
				{
						
					if(pieces.get(iCounter).getColor().equals(this.getColor()))
					{
							
					}
						
					else if((newLoc.equals(pieces.get(iCounter).getLocation())))
					{
						moves.add(newLoc);
					}	
				}
			}
			
			oldLoc = newLoc;
			
		}
		
		return moves;
		
	}
}