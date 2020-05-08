package rockPaperScissor;

import java.util.Random;

import javax.swing.ImageIcon;

public enum RPS
{
	ROCK(new ImageIcon(RPS.class.getResource("images/rock.png"))),
	PAPER(new ImageIcon(RPS.class.getResource("images/paper.png"))),
	SCISSORS(new ImageIcon(RPS.class.getResource("images/scissors.png")));

	//FIELDS
	ImageIcon image;
	
	//CONSTRUCTOR
	private RPS(ImageIcon i)
	{
		image = i;
	}
	
	//METHODS
	static String evaluate(RPS player1, RPS player2)
	{
		String winner = "";
		
		if(player1.equals(player2))
			winner = "YOU TIED";
		else if(player1 == RPS.ROCK && player2 == RPS.PAPER)
			winner = "YOU LOST";
		else if(player1 == RPS.PAPER && player2 == RPS.SCISSORS)
			winner = "YOU LOST";
		else if (player1 == RPS.SCISSORS && player2 == RPS.ROCK)
			winner = "YOU LOST";
		else
			winner = "YOU WON";
		
		return winner;
	}

}