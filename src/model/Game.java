package model;

import java.util.List;

import model_interface.DiceStrategy;
import model_interface.TelePort;

public class Game {
	private Board board;
	private List< Player> playerList;
	private DiceStrategy dice;

	public Game(Board board, List<Player> playerList, DiceStrategy dice) {
		this.board = board;
		this.playerList = playerList;
		this.dice = dice;
	}

	public int rollDice() {
		return this.dice.rollTheDice();
	}
	
	public int getFinalPosition(int position) {
		TelePort port = this.board.getTelePort(position);
		if(port==null) {
			return position;
		}else {
			System.out.println("A "+port+" poped up");
			return port.transferTo();
		}
	}
	
	public void run() {
		while (true) {
			for (Player player : this.playerList) {
				playOneTurn(player);
				if (checkIfWin(player)) {
					System.out.println(player + " wins the game");
					return;
				}
			}
		}
	}

	public boolean checkIfWin(Player player) {
		return player.getCurrentPosition() == this.board.size;
			
	}

	public int playOneTurn(Player player) {
		int step = this.rollDice();
		int targetPosition = player.getCurrentPosition() + step;
		if (checkBoundary(targetPosition)) {
			int finalPosition = this.getFinalPosition(targetPosition);
			player.moveTo(finalPosition);
			System.out.println(player + " moves to "+finalPosition);
			return finalPosition;
		}else {
			System.out.println(player + " moves out of boundary");
		}
		return player.getCurrentPosition();
		

	}

	public boolean checkBoundary(int position) {
		return (position <= this.board.size) && (position > 0);
	}

}
