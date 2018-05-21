public class BoardTest
{
    public static void main(String[] args)
    {
        String[][] board = new String[6][7];
        for ( int row = 0; row < board.length; row++ )
        {
            for ( int col = 0; col < board[0].length; col++ )
            {
                board[row][col] = "|";
            }
        }
        for ( int startCol = 0; startCol < board[0].length-3; startCol++ )
        {
            for ( int startRow = 3; startRow < board.length; startRow++ )
            {

                int col = startCol;
                int row = startRow;
                while ( row >= 0 && col < board[0].length )
                {
                    board[row][col] += String.valueOf(startRow);
                    col++;
                    row--;
                }
            }
        }

        for ( int row = 0; row < board.length; row++ )
        {
            for ( int col = 0; col < board[0].length; col++ )
            {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}
