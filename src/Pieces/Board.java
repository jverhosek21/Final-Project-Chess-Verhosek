package Pieces;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class Board
{

	private static ArrayList<Piece> whitePieces;
	private static ArrayList<Piece> blackPieces;
	private static ActorWorld world;
	private Color player1;
	private Color player2;
	
	/**
	 * Sets up board with traditional colors
	 */
	public Board ()
	{
		player1 = Color.WHITE;
		player2 = Color.BLACK;
	}
	
	/**
	 * Sets up the board with user selected colors
	 * @param cP1 Color player 1 selected
	 * @param cP2 Color player 2 selected
	 */
	public Board (Color cP1, Color cP2)
	{
		player1 = cP1;
		player2 = cP2;
	}
    
    /**
     * Sets board up with boarder and pieces in starting positions
     */
    public void setBoard()
    {
    	world = new ActorWorld();
    	whitePieces = new ArrayList<Piece>();
    	
    	world.setMessage("Player 1, select a piece and move to begin.");
    	
    	//all white/player 1's pieces
    	boolean bWhite = true;
    	
    	for (int iCol = 0; iCol < 8; iCol++)
		{
    		Pawn wPawn = new Pawn(bWhite, player1);
			world.add(new Location (6, iCol), wPawn);
			whitePieces.add(wPawn);
		}
    	
    	Rook rook1 = new Rook(bWhite, player1);
    	Rook rook2 = new Rook(bWhite, player1);
    	Knight knight1 = new Knight(bWhite, player1);
    	Knight knight2 = new Knight(bWhite, player1);  	
    	Bishop bishop1 = new Bishop(bWhite, player1);
    	Bishop bishop2 = new Bishop(bWhite, player1);
    	Queen queen = new Queen(bWhite, player1);
    	King king = new King(bWhite, player1);
    	
    	whitePieces.add(rook1);
    	whitePieces.add(rook2);
    	whitePieces.add(knight1);
    	whitePieces.add(knight2);
    	whitePieces.add(bishop1);
    	whitePieces.add(bishop2);
    	whitePieces.add(queen);
    	whitePieces.add(king);
    	
    	world.add(new Location (7, 0), rook1);
    	world.add(new Location (7, 7), rook2);
    	world.add(new Location (7, 1), knight1);
    	world.add(new Location (7, 6), knight2);
    	world.add(new Location (7, 2), bishop1);
    	world.add(new Location (7, 5), bishop2);
    	world.add(new Location (7, 3), queen);
    	world.add(new Location (7, 4), king);
    	
    	//all black/player 2's pieces
    	bWhite = false;
    	
    	blackPieces = new ArrayList<Piece>();
    	
    	for (int iCol = 0; iCol < 8; iCol++)
    	{
    		Pawn bPawn = new Pawn(bWhite, player2);
    		world.add(new Location (1, iCol), bPawn);
    		blackPieces.add(bPawn);
    	}
    	
    	Rook rook3 = new Rook(bWhite, player2);
    	Rook rook4 = new Rook(bWhite, player2);
    	Knight knight3 = new Knight(bWhite, player2);
    	Knight knight4 = new Knight(bWhite, player2);  	
    	Bishop bishop3 = new Bishop(bWhite, player2);
    	Bishop bishop4 = new Bishop(bWhite, player2);
    	Queen queen2 = new Queen(bWhite, player2);
    	King king2 = new King(bWhite, player2);
    	
    	blackPieces.add(rook3);
    	blackPieces.add(rook4);
    	blackPieces.add(knight3);
    	blackPieces.add(knight4);
    	blackPieces.add(bishop3);
    	blackPieces.add(bishop4);
    	blackPieces.add(queen2);
    	blackPieces.add(king2);
    	
    	world.add(new Location(0, 7), rook3);
    	world.add(new Location (0, 0), rook4);
    	world.add(new Location(0, 6), knight3);
    	world.add(new Location (0, 1), knight4);
    	world.add(new Location(0, 5), bishop3);
    	world.add(new Location (0, 2), bishop4);
    	world.add(new Location(0, 3), queen2);
    	world.add(new Location (0, 4), king2);
    	world.show();
    }
    
    /**
     * gets the array list of player 1's pieces
     * @return array list
     */
    public static ArrayList<Piece> getWhitePieces()
    {
    	return whitePieces;
    }
    
    /**
     * gets the array list of player 2's pieces
     * @return array list 
     */
    public static ArrayList<Piece> getBlackPieces()
    {
    	return blackPieces;
    }
    
    /**
     * sets the array list for player 1's pieces
     * @param array list
     */
    public static void setWhitePieces(ArrayList<Piece> pieceList)
    {
    	whitePieces = pieceList;
    }
    
    /**
     * sets the array list for player 2's pieces
     * @return array list
     */
    public static void setBlackPieces(ArrayList<Piece> pieceList)
    {
    	blackPieces = pieceList;
    }
    
    /**
     * Check if the opposing sides king is in check by comparing it's location with all possible locations of the current player's pieces
     * @param bWhite signifies which side made the most current move
     */
    public static void check(boolean bWhite)
    {
    	
    		ArrayList<Location> check = new ArrayList<Location>();
    	
    		if(bWhite)
    		{
    			Location kingLoc = blackPieces.get(blackPieces.size() - 1).getLocation();
    		
    			for(int iIndex = 0; iIndex < whitePieces.size(); iIndex++)
    			{
    				check.addAll(whitePieces.get(iIndex).listValidMoves());
    			}
    		
    			for(int iCounter = 0; iCounter < check.size(); iCounter++)
    			{
    				if(check.get(iCounter).getRow() == kingLoc.getRow() && check.get(iCounter).getCol() == kingLoc.getCol())
    				{
    					world.setMessage("Player 2 King is in Check");
    					iCounter = check.size();
    				}
    			
    				else
    				{
    					world.setMessage("Player 2's turn");
    				}
    			}
    		}
    	
    		else
    		{
    			Location kingLoc = whitePieces.get(whitePieces.size() - 1).getLocation();
    			
    			for(int iIndex = 0; iIndex < blackPieces.size(); iIndex++)
    			{
    				check.addAll(blackPieces.get(iIndex).listValidMoves());
    			}
    		
    			for(int iCounter = 0; iCounter < check.size(); iCounter++)
    			{
    				if(check.get(iCounter).getRow() == kingLoc.getRow() && check.get(iCounter).getCol() == kingLoc.getCol())
    				{
    					world.setMessage("Player 1 King is in Check");
    					iCounter = check.size();
    				}	
    			
    				else
    				{
    					world.setMessage("Player 1's turn");
    				}
    			}
    		}
    	}
    
    /**
     * Sets the message to indicate the winner when check mate has occurred
     * @param bWhite color of the piece that just moved
     */
    public static void checkmate(boolean bWhite)
    {
    	if(bWhite)
    	{		
    		world.setMessage("Checkmate! Player 1 Wins!");    		
    	}
    	
    	else
    	{
    		world.setMessage("Checkmate! Player 2 Wins!");
    	}
    }
}