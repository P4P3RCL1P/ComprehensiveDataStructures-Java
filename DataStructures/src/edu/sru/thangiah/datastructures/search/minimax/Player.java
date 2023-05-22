package edu.sru.thangiah.datastructures.search.minimax;

/**
 * <p>Title: Player</p>
 *
 * <p>Description: </p>
 * 
 * Player Class for Tic Tac Toe game
 * Includes minimax algorithm for bot to use when it is bot's turn
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
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

public class Player {
	private boolean isBot; //checks to see if bot
	private boolean isWinner; //checks to see if winner
	private boolean isTurn; //checks if it is Player's turn
	private String symbol; //symbol of player for game X or O
	private String opponent;
	private int moveCount;
	
	public Player() //constructor
	{
		isBot = false;
		isWinner = false;
		isTurn = false;
		symbol = "";
		moveCount = 0;
	}
	
	public Player(boolean isBot, String sym) //overloaded constructor for player
	{ //inputs if player is a bot, their symbol, and the turn
		this.isBot = isBot;
		isWinner = false;
		symbol = sym;
		moveCount = 0;
		if(symbol == "X") //X always goes furst
		{
			isTurn = true;
			opponent = "O";
		}
		else if(symbol == "O")
		{
			isTurn = false;
			opponent = "X";
		}
		else
		{
			System.out.println("Symbol is invalid");
		}
	}
	
	//getters and setters
	public boolean getIsBot()
	{
		return isBot;
	}
	
	public boolean setIsBot(boolean bot)
	{
		isBot = bot;
		return true;
	}
	
	public boolean getIsWinner()
	{
		return isWinner;
	}
	
	public boolean setIsWinner(boolean winner)
	{
		isWinner = winner;
		return true;
	}
	
	public boolean getIsTurn()
	{
		return isTurn;
	}
	
	public boolean setIsTurn(boolean turn)
	{
		isTurn = turn;
		return true;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public String setSymbol(String sym) //sets the symbols and sets the opponent based on the symbol
	{
		symbol = sym;
		if(symbol == "X") //X always goes furst
		{
			isTurn = true;
			opponent = "O";
		}
		else if(symbol == "O")
		{
			isTurn = false;
			opponent = "X";
		}
		return symbol;
	}
	
	public String getOpponent()
	{
		return opponent;
	}
	
	public int getMoveCount()
	{
		return moveCount;
	}
	
	public boolean resetMoves()
	{
		moveCount = 0;
		return true;
	}
	
	public boolean incrementMoves()
	{
		moveCount++;
		return true;
	}
	
	//decide for naming convention, gets best move
	public int decide(Board board, int depth, Player player)
	{
		return bestMove(board, depth, player);
	}
	
	//gets best move based on minimax scores returned
	public int bestMove(Board board, int depth, Player player)
	{
		//minimax for the best solution
		int bestScore = -100; //best score for user
		int move = 0;
		for (int i = 0; i < 9; i++) //checks for empty spaces (possible moves)
		{
			if(board.getBoardVal(i) == "-")
			{
				board.botMove(i+1, player.getSymbol()); //simulate move for bot
				int score = miniMax(board, 0, player, -1000, 1000, false);
				board.botMove(i+1, "-"); //undos move to check next
				if(score > bestScore) //if the score is better, replace and mark that move
				{
					bestScore = score;
					move = i+1; //funky indexing for easier user interaction
				}
			}
		}
		//board.botMove(move, player);
		System.out.println("The number of moves checked is " + moveCount);
		resetMoves();
		return move;
	}
	
	public boolean checkMoves(Board board) //checks if there are moves remaining
	{
		for (int i = 0; i < 9; i++)
		{
			if(board.getBoardVal(i) == "-")
			{
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param board - The current state of the tictactoe board
	 * @param depth - Current depth in game tree
	 * @param player - Actions of player
	 * @param maximizing
	 * 
	 * Minimax function is main purpose of demonstration
	 * Essentially breaks down each move by running through each possibility in a tree format
	 * Minimax goes turn by turn taking the min value then max value of children to make parent
	 * Simulates a real game for each possible move remaining
	 * Recursively calls itself to traverse down the tree to the lowest possible point, and end game outcome
	 * Each end game outcome has its own score, allowing for traversal back up to get a best score
	 * Best score is returned to allow for bestMove to choose the move based on returned score
	 * 
	 * ALPHA AND BETA PRUNING
	 * This v2 minimax includes alpha and beta pruning, essentially cutting off unnecessary outcomes that need checked by remembering what
	 * the previous best move is for each player. If there is already a move that will be picked over a whole section of a tree,
	 * that section of the tree can be removed to optimize the calculation time.
	 * @return
	 */
	public int miniMax(Board board, int depth, Player player, int alpha, int beta, boolean maximizing)
	{
		int score = board.checkScore(player.getSymbol()); //sets score of move
		if(score == 10) //returns a winning board
		{
			incrementMoves();
			return score;
		}
		
		if(score == -10) //returns a losing board
		{
			incrementMoves();
			return score;
		}
		
		if(!checkMoves(board))
		{
			return 0;
		}
		
		
		if(maximizing) //if it is the bots turn in the simulation
		{ //goal is to get best score

			int topScore = -100; //initial low score
			for (int i = 0; i < 9; i++)
			{
				if(board.getBoardVal(i) == "-") //checks for empty spaces
				{
					//recursive call for each open space, will place bot symbol and continue down tree
					board.botMove(i+1, player.getSymbol());
					topScore = Math.max(topScore,miniMax(board, depth + 1, player, alpha, beta, !maximizing));
					alpha = Math.max(alpha,  topScore); //sets the alpha variable to the max of the current vs the found topScore
					board.botMove(i+1, "-"); //unmakes move
					
					if(beta <= alpha)
					{
						break;
					}
				}
			}
			return topScore - depth; //returns best score for recursive score and best move
		}
		else //if it is the user's turn in the simulation
		{ //opponent wants you to have the worst score

			int lowScore = 100; //initial high score
			for (int i = 0; i < 9; i++)
			{
				if(board.getBoardVal(i) == "-") //checks empty spaces
				{
					//recursive call for each open space, will place player symbol and continue down tree
					board.botMove(i+1, player.getOpponent());
					lowScore = Math.min(lowScore,miniMax(board, depth + 1, player, alpha, beta, !maximizing));
					beta = Math.min(beta, lowScore); //sets the beta variable to the max of the current vs the found lowScore
					board.botMove(i+1, "-");  //unmakes move
					
					if(beta <= alpha)
					{
						break;
					}
				}
			}
		return lowScore + depth; //returns the lowest score for recursive call
		}
	}
}
