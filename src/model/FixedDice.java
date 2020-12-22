package model;

import model_interface.DiceStrategy;

public class FixedDice implements DiceStrategy{
	
	private int number;
	

	public FixedDice(int number) {
		super();
		this.number = number;
	}


	@Override
	public int rollTheDice() {
		// TODO Auto-generated method stub
		return this.number;
	}

}
