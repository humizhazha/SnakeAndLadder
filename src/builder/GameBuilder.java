package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.TelePortType;
import model.Board;
import model.Game;
import model.Player;
import model.SingleDice;
import model_interface.TelePort;

public class GameBuilder {
	private TelePortFactory factory;

	public GameBuilder() {
		this.factory = new TelePortFactory();
	}

	public TelePort buildTeleport(TelePortType type, int start, int end) {
		TelePort port = factory.createTelePort(type, start, end);
		return port;
	}

	private Board buildBoard(JSONArray teleportData, int size) {
		Map<Integer, TelePort> telePortTable = new HashMap<Integer, TelePort>();
		for (int i = 0; i < teleportData.size(); i++) {
			JSONObject teleport = (JSONObject) teleportData.get(i);
			TelePortType type = TelePortType.valueOf(teleport.get("type").toString());
			int start = Integer.parseInt(teleport.get("start").toString());
			int end = Integer.parseInt(teleport.get("end").toString());
			TelePort port = buildTeleport(type, start, end);
			telePortTable.put(port.eventPosition(), port);
		}
		return new Board(telePortTable, size);

	}

	private List<Player> buildPlayer(JSONArray playerData) {
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (int i = 0; i < playerData.size(); i++) {
			playerList.add(new Player(((((JSONObject) playerData.get(i)).get("name").toString()))));
		}
		return playerList;
	}

	public Game getGame(JSONObject config) {
		JSONArray playerData = (JSONArray) config.get("players");
		JSONObject boardData = (JSONObject) config.get("board");
		JSONArray teleportData = (JSONArray) boardData.get("teleports");
		int boardSize = Integer.parseInt(boardData.get("size").toString());
		return new Game(buildBoard(teleportData, boardSize), buildPlayer(playerData), new SingleDice());

	}

}
