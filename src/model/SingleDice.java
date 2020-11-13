package model;

import java.util.Random;

import model_interface.DiceStrategy;

public class SingleDice implements DiceStrategy{

	@Override
	public int rollTheDice() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}

}
