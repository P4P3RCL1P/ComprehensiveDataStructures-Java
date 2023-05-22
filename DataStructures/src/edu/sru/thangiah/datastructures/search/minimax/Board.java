package edu.sru.thangiah.datastructures.search.minimax;

/**
 * <p>Title: Board/p>
 *
 * <p>Description: </p>
 * 
 * Board class for the tic tac toe game
 * Handles scoring for minimax based on the board
 * 
 * Minimax is an artificial intelligence decision making algorithm
 * popular in game theory. The objective is to find the optimal move in a
 * given state. Minimax contains a maximizer and a minimizer. The maximizer
 * bases moves on a greedy approach which achieves the highest score, while
 * the minimizer attempts to get the lowest score possible. Backtracking is used in
 * a tree like data structure to navigate through all potential action states and
 * determine which optimizes the given goal.
 *
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class Board { //board class
	/**
	 * initialize constance for 3 x 3 tictactoe grid
	 */
	private final int BOARDSIZE = 9;
	private String[] board = new String[BOARDSIZE]; //Board is a standard array of Strings
	
	/**
	 * Default constructor for initializing board with placeholder values (similar to null)
	 */
	public Board() //constructor
	{
		for(int i = 0; i < BOARDSIZE; i++)
		{
			board[i] = "-";
		}
	}
	
	/**
	 * Getter method for returning the tictactoe board
	 * @return - a string representation of the tictactoe board
	 */
	public String[] getBoard()
	{
		return board;
	}
	
	/**
	 *  Return the value for a given index in the tictactoe board
	 * @param i - the index to return the value of
	 * @return The data contained at the given index
	 */
	public String getBoardVal(int i)
	{
		return board[i];
	}
	
	/**
	 * Prints a gui representation of the tictactoe board
	 */
	public void printBoard() //ASCII Tic Tac Toe Board
	{
		System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
        System.out.println("===============");
	}
	
	/**
	 * Prints a gui representation of the tictactoe board indices for better ease of use for the user
	 */
	public void printIndexBoard() //ASCII Prints the indexes for input
	{
		System.out.println("|---|---|---|");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("|-----------|");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("|-----------|");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("|---|---|---|");
        System.out.println("===============");
	}
	
	/**
	 * Method for checking user input and marking the index with the user's symbol
	 * @param location - The index the player has marked with their symbol
	 * @param symbol - The symbol the user is using to identify themselves
	 * @return True based on successful method call
	 */
	public boolean makeMove(int location, String symbol) //Makes a move based on the player symbol
	{
		location = location - 1;
		
		if(board[location] == "-") //Checks to see if spot is open
		{
			board[location] = symbol;
			return true;
		}
		else
		{
			System.out.println("Spot is already taken");
			return false;
		}
	}
	
	/**
	 * Method for initializing the bots move on the tictactoe board
	 * @param location - The index the player has marked with their symbol
	 * @param symbol - The symbol the user is using to identify themselves
	 * @return True based on successful method call
	 */
	public boolean botMove(int location, String symbol) //Makes a move anywhere despite if spot is take or not
	{ //Mostly used for the minimax moves in order to replace symbols with a blank symbol
		location = location - 1;
		board[location] = symbol;
		return true;
	}
	
	/**
	 * Method to check for all win conditions (horizontal, vertical, and diagonal)
	 * @return The symbol of the player that has won based on a true return value after checking for win conditions
	 */
	public String checkWinner() //Checks to see if there is a winner
	{
		//check winner
		for (int a = 0; a < 8; a++) { //For loop for each case
            String line = null;
  
            switch (a) { //Lines in which Tic Tac Toe can be won
            case 0: //Each case is checked with if statements after being formed into a String
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
              
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
		int emptyCount = 0; //checks for empty spaces
		for(int i = 0; i < BOARDSIZE; i++)
		{
			if(board[i] == "-")
			{
				emptyCount++;
			}
		}
		
		if(emptyCount == 0) //will return a tie if all empty spaces are gone and no winner determined
		{
			return "tie";
		}
		
		return "turn"; //just returns to the next turn of game
	}
	
	/**
	 * score checker for minimax, same as the checkWinner but for minimax leaves
	 * @param symbol - The player symbol
	 * @return The potential score for a given action
	 */
	public int checkScore(String symbol) //score checker for minimax, same as the checkWinner but for minimax leaves
	{
		//check winner
		for (int a = 0; a < 8; a++) { //loop through all cases
            String line = null;
  
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //if X is the winner
            if (line.equals("XXX")) 
            {
                if(symbol == "X")
                {
                	return 10; //return a good score if you are X, and you win
                }
                else if(symbol == "O")
                {
                	return -10; //return a bad score if you are O, and X won
                }
            }
            else if (line.equals("OOO")) //if O is the winner
            {
            	if(symbol == "X")
                {
                	return -10; //return a bad score if you are X, and O won
                }
                else if(symbol == "O")
                {
                	return 10; //return a good score if you are O, and you win
                }
            }
            	
        }
		
		return 0;
	}
}
