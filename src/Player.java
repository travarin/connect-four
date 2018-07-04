/**
 * 
 * @author Travis Langston
 * 2/14/2018
 * Provides a player object for the Connect 4 game. Stores the mark of the player (X or O), the player's name,
 * the number of games won, the number of games attempted, and the number of games tied. 
 * Used for printing the message at the end of each game, and for making moves during the game.
 *
 */
public class Player 
{
	private String name;
	private char   mark;
	private int    gamesWon;
	private int    gamesAttempted;
	private int    gamesTied;
	
	/**
	 * Constructor to create a new player object. 
	 * Takes in a name and mark and stores them in the instance variables for the object. 
	 * @param name: name to set the name of this object to.
	 * @param mark: mark to set the mark of this object to.
	 */
	public Player(String name, char mark)
	{
		this.name = name;
		this.mark = mark;
	}
	
	/**
	 * Changes the player's mark each turn. 
	 * @param New mark to set this player's mark to. 
	 */
	public void setMark(char mark)
	{
		this.mark = mark;
	}
	
	/**
	 * If the player wins a game, increments gamesWon;
	 */
	public void setGamesWon()
	{
		gamesWon++;
	}
	
	/**
	 * At the start of every game, increments the number of games attempted.
	 */
	public void setGamesAttempted()
	{
		gamesAttempted++;
	}
	
	/**
	 * In the event of a tie, increments the gamesTied counter. 
	 */
	public void setGamesTied()
	{
		gamesTied++;
	}
	
	/**
	 * Allows GameBoard to print out this player's name in the message at the end of the game.
	 * @return The name of this player. 
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Allows GameBoard to use this player's mark when updating the board
	 * after the player has made a move.
	 * @return The mark of this player.
	 */
	public char getMark()
	{
		return mark;
	}
	
	/**
	 * Allows GameBoard to get the number of games this player has won to print out 
	 * in the message at the end of the game.
	 * @return The number of games this player has won.
	 */
	public int getGamesWon()
	{
		return gamesWon;
	}

	/**
	 * Allows GameBoard to get the number of games this player has attempted to print out
	 * in the message at the end of the game.
	 * @return The number of games this player has attempted.
	 */
	public int getGamesAttempted()
	{
		return gamesAttempted;
	}
	
	/**
	 * Allows GameBoard to get the number of games this player has tied to print out
	 * in the message at the end of the game.
	 * @return The number of games this player has tied.
	 */
	public int getGamesTied()
	{
		return gamesTied;
	}
	
	/**
	 * Returns this player's name, gamesAttempted, gamesWon, and gamesTied 
	 * print out at the end of the game.
	 */
	public String toString()
	{
		return "         Player: " + name + 
			 "\n      Games Won: " + gamesWon + 
		     "\n     Games Tied: " + gamesTied + 
		     "\nGames Attempted: " + gamesAttempted;
	}
}
