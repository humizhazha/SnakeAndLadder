package builder;

import java.util.ArrayList;
import java.util.List;

import common.TelePortType;
import model.Board;
import model.Game;
import model.Player;
import model.SingleDice;

public class GameBuilder {
	private BoardBuilder builder;

	public GameBuilder() {
		this.builder = new BoardBuilder();
	}

	private Board createBoard(List<TelePortType> portList, int size) {
		return builder.createBoard(portList, size);

	}

	private ArrayList<Player> createPlayer(List<String> nameList) {
		return null;
	}

	public Game createGame(List<String> nameList, List<TelePortType> portList, int size) {
		return new Game(createBoard(portList, size), createPlayer(nameList), new SingleDice());
	}

}
