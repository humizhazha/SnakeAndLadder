package service;

import model.Player;

public interface GameService {
	
	public void startGame();

	public boolean checkIfWin(Player player);
	
	public void round(Player player);

}
