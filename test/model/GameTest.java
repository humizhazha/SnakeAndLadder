package model;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import model_interface.DiceStrategy;

public class GameTest {
	private static Game game;

	@Before
	public void testSetup() {
		game = initGame();
	}
	Game initGame() {
		DiceStrategy dice = mock(DiceStrategy.class);
		when(dice.rollTheDice()).thenReturn(5);
		return new Game(initBoard(), initPlayerList(), dice);
	}
	Board initBoard() {
		int size = 100;
		return new Board(initTeleportList(), size);
	}
	List<Player> initPlayerList() {
	    List<Player> playerList = Arrays.asList(new Player("Vivi"),new Player("Roger"));
		return playerList;
	}
	HashMap<Integer, TelePort> initTeleportList() {
		HashMap<Integer, TelePort> teleportMap = new HashMap<>();
		TelePort snake = new Snake(68, 74);
		TelePort ladder = new Ladder(54, 90);
		teleportMap.put(snake.eventPosition(), snake);
		teleportMap.put(ladder.eventPosition(), ladder);
		return teleportMap;
	}


	@Test
	public void testCheckEvent() {
		assertEquals(65,game.getFinalPosition(65));		
		assertEquals(0,game.getFinalPosition(0));
		assertEquals(-1,game.getFinalPosition(-1));
		assertEquals(68,game.getFinalPosition(74));
		assertEquals(90,game.getFinalPosition(54));

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
	public void testPlayOneTurn() {
		Player player = new Player("Test",95);
		assertEquals(100, game.playOneTurn(player));
		
		player.setCurrentPosition(65);
		assertEquals(70, game.playOneTurn(player));
		
		player.setCurrentPosition(98);
		assertEquals(98, game.playOneTurn(player));
		
		player.setCurrentPosition(100);
		assertEquals(100, game.playOneTurn(player));
		
	}

	@Test
	public void testRound() {
		Player player = new Player("Test",100);
		game.playOneTurn(player);
		assertEquals(100,player.getCurrentPosition());

		player.setCurrentPosition(55);
		game.playOneTurn(player);
		assertEquals(60,player.getCurrentPosition());

		player.setCurrentPosition(69);
		game.playOneTurn(player);
		assertEquals(68,player.getCurrentPosition());

		player.setCurrentPosition(49);
		game.playOneTurn(player);
		assertEquals(90,player.getCurrentPosition());

		player.setCurrentPosition(0);
		game.playOneTurn(player);
		assertEquals(5,player.getCurrentPosition());

	}

}
