package model;

import java.util.ArrayList;

import model_interface.DiceStrategy;

public class Game {
	private Board board;
	private ArrayList<Player> playerList;
	private DiceStrategy dic;
	private Player winner;

	public Game(Board board, ArrayList<Player> playerList, DiceStrategy dic) {
		this.board = board;
		this.playerList = playerList;
		this.dic = dic;
		this.winner = null;
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

}
