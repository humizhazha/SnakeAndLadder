package service;

import model.Game;
import model.Player;

public class GameServiceImpl implements GameService {
	private Game game;
	private boolean gameOver;

	public GameServiceImpl(Game game) {
		this.game = game;
		this.gameOver = false;

	}

	@Override
	public void startGame() {
		while (!gameOver) {
			for (Player player : this.game.getPlayerList()) {
				round(player);
				this.gameOver = checkIfWin(player);
				if (gameOver) {
					System.out.println(this.game.getWinner() + " wins the game");
					break;
				}

			}
		}

	}

	@Override
	public boolean checkIfWin(Player player) {
		if(player.getCurrentPosition() == this.game.getSize()) {
			this.game.setWinner(player);
			return true;
		}
		return false;
			
	}

	@Override
	public void round(Player player) {
		int step = this.game.rollDice();
		int targetPosition = player.getCurrentPosition() + step;
		if (checkBoundary(targetPosition)) {
			player.moveTo(this.game.checkEvent(targetPosition));
		}

	}

	private boolean checkBoundary(int position) {
		return position <= this.game.getSize();
	}

}
