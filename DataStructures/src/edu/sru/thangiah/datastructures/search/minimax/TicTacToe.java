package edu.sru.thangiah.datastructures.search.minimax;

import java.util.Scanner;

/**
 * <p>Title: TicTacToe</p>
 *
 * <p>Description: </p>
 * Tic Tac Toe game using the minimax algorithm to generate a list of moves for the bot to use
 * Bot will choose optimal move to play against the player
 *
 *
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
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class TicTacToe {
	
	public static void main(String[] args)
	{
		//Initialize the board, players, winner string, userchoice, and loop booleans
		Board board = new Board();
		Player player = new Player(false, "X");
		Player bot = new Player(true, "O");
		String hasWinner = "";
		int chooseSymbol;
		int userChoice;
		boolean playerMove = false;
		boolean symbolLoop = true;
		
		
		/**
		 * Scanner used for user input
		 */
		Scanner choice = new Scanner(System.in);
		
		//ensure the symbol input is correctly checked
		while(symbolLoop == true)
		{
		System.out.println("Choose a symbol (1 for X, 2 for O)");
		chooseSymbol = choice.nextInt();
		
		//Bot symbol is set to O if user chooses X
		if(chooseSymbol == 1)
		{
			player.setSymbol("X");
			bot.setSymbol("O");
			symbolLoop = false;
		}
		//Bot symbol is set to X if user chooses O
		else if(chooseSymbol == 2)
		{
			player.setSymbol("O");
			bot.setSymbol("X");
			symbolLoop = false;
		}
		else
		{
			//Continue prompting for user input while there is incorrect input
			symbolLoop = true;
		}
		System.out.println(chooseSymbol);
		}
		//visualize the board
		board.printIndexBoard();
		//begin turn loop
		while(hasWinner != "X" || hasWinner != "O" || hasWinner != "tie") //each turn check winner
		{
			while(playerMove == false) //checks to make sure the player move is still false
			{
				if(player.getIsTurn() == true)
				{
					System.out.println("Choose a position (1-9), auto move with 777, exit by entering 99");
					userChoice = choice.nextInt(); //gets user input
					if(userChoice == 99) //quits if user enter exit input
					{
						return;
					}
					if(1 <= userChoice && userChoice <= 9) //checks to make sure choice is in bounds
					{
						if(board.makeMove(userChoice,player.getSymbol()) == true) //makes sure space is open
						{
							//board.makeMove(choice.nextInt(),player.getSymbol());
							playerMove = true;
						}
						else //loops if space is taken
						{
							playerMove = false;
						}
					}
					else if(userChoice == 777) //auto move for the player, if they choose
					{
						System.out.println("Auto making move...");
						board.makeMove(player.decide(board,  0, player), player.getSymbol());
						playerMove = true;
					}
					else //loops if input it out of bounds
					{
						playerMove = false;
						System.out.println("Move is out of index, choose 1-9");
					}
				}
				else //bot's move
				{
					System.out.println("Bot is making its move");
					board.makeMove(bot.decide(board, 0, bot), bot.getSymbol());
					playerMove = true;
				}
			}
			
			hasWinner = board.checkWinner(); //checks for winner
			
			//end of game cases, or swaps turn
			if(hasWinner == "X")
			{
				board.printBoard();
				System.out.println("X is the winner");
				player.setIsWinner(true);
				break;
			}
			else if(hasWinner == "O")
			{
				board.printBoard();
				System.out.println("O is the winner");
				bot.setIsWinner(true);
				break;
			}
			else if(hasWinner == "tie")
			{
				board.printBoard();
				System.out.println("The game ends in a tie");
				break;
			}
			else if(player.getIsTurn() == true && hasWinner == "turn")
			{
				player.setIsTurn(false);
				bot.setIsTurn(true);
			}
			else if(bot.getIsTurn() == true && hasWinner == "turn")
			{
				player.setIsTurn(true);
				bot.setIsTurn(false);
			}
			board.printBoard();
			playerMove = false;
		}
		//closes scanner
		choice.close();
	}
}

