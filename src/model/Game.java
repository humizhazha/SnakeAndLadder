package model;

import java.util.ArrayList;
import java.util.List;

import model_interface.DiceStrategy;

public class Game {
	private Board board;
	private List< Player> playerList;
	private DiceStrategy dice;
	private Player winner;
	private boolean gameOver;

	public Game(Board board, List<Player> playerList, DiceStrategy dice) {
		this.board = board;
		this.playerList = playerList;
		this.dice = dice;
		this.winner = null;
		this.gameOver = false;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public int rollDice() {
		return this.dice.rollTheDice();
	}
	
	public int getSize() {
		return this.board.getSize();
	}
	
	public int checkEvent(int position) {
		TelePort port = this.board.checkEvent(position);
		if(port==null) {
			return position;
		}else {
			System.out.println("A "+port+" poped up");
			return port.transferTo();
		}
	}
	
	public void startGame() {
		while (!gameOver) {
			for (Player player : this.playerList) {
				round(player);
				this.gameOver = checkIfWin(player);
				if (gameOver) {
					System.out.println(this.getWinner() + " wins the game");
					break;
				}
			}
		}
	}

	public boolean checkIfWin(Player player) {
		if(player.getCurrentPosition() == this.getSize()) {
			this.setWinner(player);
			return true;
		}
		return false;
			
	}

	public void round(Player player) {
		int step = this.rollDice();
		int targetPosition = player.getCurrentPosition() + step;
		if (checkBoundary(targetPosition)) {
			int finalPosition = this.checkEvent(targetPosition);
			player.moveTo(finalPosition);
			System.out.println(player + " moves to "+finalPosition);
		}else {
			System.out.println(player + " moves out of boundary");
		}

	}

	public boolean checkBoundary(int position) {
		return (position <= this.getSize()) && (position > 0);
	}

}
