/**
 * 
 * @author Travis Langston
 * 2/14/2018
 * Serves as the Gameboard for a Connect4 game. 
 * Has two player objects, which keep track of their mark, games won, games tied, and games attempted. 
 * Has a 2d array of chars for the board. Resets the board at the beginning of the game and assigns a mark to each player.
 * Each turn - has a player enter the column they want to drop their piece in. Checks to see if it is a valid move, 
 * and if so, drops the piece in. Then checks to see if any player has won - has made 4 pieces in a row.
 * If a player has one, updates games won and games attempted and prints out a message.
 *
 */
import java.util.Scanner;
public class Gameboard 
{
	private char    board[][];
	private Player  p1;
	private Player  p2;
	private Scanner rdIn;
	private int     turn;
	
	/**
	 * Starts the game. Generates a random number to assign the first marks to each player. 
	 * Then reads in the names for each player, and initializes the player objects. 
	 * Finally, initializes the board. 
	 */
	public void start()
	{
		int mark = (int) Math.random(); 
		
		rdIn = new Scanner(System.in);
		System.out.print("\n						Player 1 enter name: ");
		p1 = new Player(rdIn.next(), mark == 0 ? 'X' : 'O');
		System.out.print("\n					  Player 2 enter name: ");
		p2 = new Player(rdIn.next(), mark == 0 ? 'O' : 'X');
		
		board = new char[6][7];
		turn  = mark;
		p1.setGamesAttempted();
		p2.setGamesAttempted();
	}
	
	/**
	 * Resets the game by clearing off the board and switching the marks of the players. 
	 * Then updates each player's games attempted.
	 */
	public void reset()
	{
		board = new char[6][7];
		char tempMark = p1.getMark();
		p1.setMark(p2.getMark());
		p2.setMark(tempMark);
		p1.setGamesAttempted();
		p2.setGamesAttempted();
	}
	
	/**
	 * Updates the turn variable to show which player's turn it is. 
	 */
	private void setTurn()
	{
		if ( turn == 1 )
		{
			turn = 0;
		}
		else
		{
			turn = 1;
		}
	}
	
	/**
	 * Makes the move for this turn.
	 * If turn equals 0, then it is player1's turn. If not, it is player2's turn. 
	 * Calls readMoves for the correct player, and then sets turn for the next turn. 
	 */
	public void move()
	{
		if ( turn == 0 )
		{
			readMoves(p1);
		}
		else
		{
			readMoves(p2);
		}
		setTurn();
	}
	
	/**
	 * Reads in the player's move for this turn. 
	 * Then calls validMoves to see if the move is valid, and placeMove to place the move on the board.
	 * @param p: The player whose move is to be read.
	 */
	private void readMoves(Player p)
	{
		System.out.print("\nPlayer " + p.getName() + " enter a column to place your move in: ");
		int col = rdIn.nextInt();
		while ( !validMove(col) )
		{
			System.out.println("\nMove invalid. Enter another: ");
			col = rdIn.nextInt();
		}
		placeMove(col, p.getMark());
	}
	
	/**
	 * Checks to see if the move entered is valid. 
	 * First checks if the move is in bounds, and then checks if that column is full. 
	 * @param col: the column the player chose to place their move in.
	 * @return true if the move is valid, false otherwise.
	 */
	private boolean validMove(int col)
	{
		if ( col < 0 || col > 6 || board[0][col] != 0 )
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Places the player's move on the board. 
	 * The move is guaranteed to be valid since validMove has already been called.
	 * @param col: The column to place the player's mark in.
	 * @param mark: The player's mark to place on the board.
	 */
	private void placeMove(int col, char mark)
	{
		int 	row    = 5;
		boolean placed = false;
		while ( row > -1 && !placed )
		{
			if ( board[row][col] == 0 )
			{
				board[row][col] = mark;
				placed = true;
			}
			row--;
		}
	}
	
	/**
	 * Returns the current state of the board 
	 * to be printed out at the beginning of each turn 
	 * and at the end of the game.
	 */
	public String toString()
	{
		StringBuilder bd = new StringBuilder();
		bd.append("---------------");
		for ( int row = 0; row < board.length; row++ )
		{
			bd.append("|");
			for ( int col = 0; col < board.length; col++)
			{
				if ( board[row][col] != 0 )
				{
					bd.append(board[row][col] + "|");
				}
				else
				{
					bd.append(" ");
				}
			}
			bd.append("\n");
		}
		bd.append("---------------");
		return bd.toString();
	}
}
