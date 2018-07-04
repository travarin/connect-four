/**
 * @author Travis Langston
 * 7/3/2018
 * Serves as the main driving class for a Connect Four game.
 * Has an object for the game board, which handles the rules of the game
 * and keeps track of the two players.
 * This class calls the GameBoard object's start, move, and gameOver methods
 * to set up a new game, read in moves from the players, and check to see if either player has won or if the game is a tie.
 * It then asks the player's if they want to play another game.
 */
import java.util.Scanner;
public class ConnectFour
{
    public static void main(String[] args)
    {
        Gameboard board       = new Gameboard();
        boolean   keepPlaying = true;
        Scanner   rdIn        = new Scanner(System.in);
        board.start();
        while ( keepPlaying )
        {
            while ( !board.gameOver() )
            {
                System.out.println(board);
                board.move();
            }
            System.out.println(board);
            board.reset();
            System.out.println("Enter Y to keep playing: ");
            keepPlaying = rdIn.next().equals("Y") ? true : false;
        }
        System.out.println("Thanks for playing!");
    }
}
