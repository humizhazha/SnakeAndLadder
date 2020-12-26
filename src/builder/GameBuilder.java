package builder;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Board;
import model.Game;
import model.Player;
import model.SingleDice;

public class GameBuilder {
	private BoardBuilder builder;

	public GameBuilder() {
		this.builder = new BoardBuilder();
	}

	private Board createBoard(JSONArray teleportData, int size) {
		return builder.createBoard(teleportData, size);

	}

	private List<Player> createPlayer(JSONArray playerData) {
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (int i = 0; i < playerData.size(); i++) {
			playerList.add(new Player(((((JSONObject) playerData.get(i)).get("name").toString()))));
		}
		return playerList;
	}

	public Game createGame(JSONObject config) {
		JSONArray playerData = (JSONArray) config.get("players");
		JSONObject boardData = (JSONObject) config.get("board");
		JSONArray teleportData = (JSONArray) boardData.get("teleports");
		return new Game(createBoard(teleportData, Integer.parseInt(boardData.get("size").toString())),
				createPlayer(playerData), new SingleDice());

	}

}
