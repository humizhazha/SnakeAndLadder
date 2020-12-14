package model;

import java.util.ArrayList;

import model_interface.DiceStrategy;

public class Game {
	private Board board;
	private ArrayList<Player> playerList;
	private DiceStrategy dic;
	private Player winner;
	private boolean gameOver;

	public Game(Board board, ArrayList<Player> playerList, DiceStrategy dic) {
		this.board = board;
		this.playerList = playerList;
		this.dic = dic;
		this.winner = null;
		this.gameOver = false;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {		
		this.board = board;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public DiceStrategy getDic() {
		return dic;
	}

	public void setDic(DiceStrategy dic) {
		this.dic = dic;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public int rollDice() {
		return this.dic.rollTheDice();
	}
	
	public int getSize() {
		return this.board.getSize();
	}
	
	public int checkEvent(int position) {
		TelePort port = this.board.checkEvent(position);
		if(port==null) {
			return position;
		}else {
			return port.transferTo();
		}
	}
	
	public void startGame() {
		while (!gameOver) {
			for (Player player : this.getPlayerList()) {
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
			player.moveTo(this.checkEvent(targetPosition));
			System.out.println(player + " moves to "+targetPosition);
		}

	}

	private boolean checkBoundary(int position) {
		return position <= this.getSize();
	}

}
