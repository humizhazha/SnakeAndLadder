package app;
import org.json.simple.JSONObject;

import builder.GameBuilder;
import common.JSONParse;
import model.Game;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configFileName = "./src/config.json";
		
		JSONParse parser = new JSONParse();
		JSONObject config = parser.parseJSON(configFileName);
		
		GameBuilder builder = new GameBuilder();
		Game game = builder.createGame(config);
		game.startGame();

	}

}
