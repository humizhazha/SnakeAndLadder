package model;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import model_interface.DiceStrategy;

public class GameTest {
	private static Game game;

	@BeforeClass
	public static void testSetup() {
		game = initGame();
	}
	static Game initGame() {
		DiceStrategy dice = new FixedDice(5);
		return new Game(initBoard(), initPlayerList(), dice);
	}
	static Board initBoard() {
		int size = 100;
		return new Board(initTeleportList(), size);
	}
	static ArrayList<Player> initPlayerList() {
		ArrayList<Player> playerList = new ArrayList<> (Arrays.asList(new Player("Vivi"), new Player("Roger")));
		return playerList;
	}
	static HashMap<Integer, TelePort> initTeleportList() {
		HashMap<Integer, TelePort> teleportList = new HashMap<>();
		TelePort snake = new Snake(68, 74);
		TelePort ladder = new Ladder(54, 90);
		teleportList.put(snake.eventPosition(), snake);
		teleportList.put(ladder.eventPosition(), ladder);
		return teleportList;
	}


	@Test
	public void testCheckEvent() {
		assertEquals(65,game.checkEvent(65));		
		assertEquals(0,game.checkEvent(0));
		assertEquals(-1,game.checkEvent(-1));
		assertEquals(68,game.checkEvent(74));
		assertEquals(90,game.checkEvent(54));

	}

	@Test
	public void testCheckBoundary() {
		assertEquals(false,game.checkBoundary(-1));		
		assertEquals(false,game.checkBoundary(0));
		assertEquals(true,game.checkBoundary(68));
		assertEquals(true,game.checkBoundary(100));
		assertEquals(false,game.checkBoundary(101));

	}

	@Test
	public void testCheckIfWin() {
		Player player = new Player("Test",100);
		assertEquals(true,game.checkIfWin(player));	

		player.setCurrentPosition(-1);
		assertEquals(false,game.checkIfWin(player));

		player.setCurrentPosition(101);
		assertEquals(false,game.checkIfWin(player));	

	}

	@Test
	public void testRound() {
		Player player = new Player("Test",100);
		game.round(player);
		assertEquals(100,player.getCurrentPosition());

		player.setCurrentPosition(55);
		game.round(player);
		assertEquals(60,player.getCurrentPosition());

		player.setCurrentPosition(69);
		game.round(player);
		assertEquals(68,player.getCurrentPosition());

		player.setCurrentPosition(49);
		game.round(player);
		assertEquals(90,player.getCurrentPosition());

		player.setCurrentPosition(0);
		game.round(player);
		assertEquals(5,player.getCurrentPosition());

	}

}
