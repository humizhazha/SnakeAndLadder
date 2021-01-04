package model;

import java.util.Random;

import model_interface.DiceStrategy;

public class SingleDice implements DiceStrategy {
	private Random random;

	public SingleDice() {
		this.random = new Random();
	}

	@Override
	public int rollTheDice() {
		return random.nextInt(6) + 1;
	}

}
